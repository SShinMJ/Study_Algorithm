import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] countryScore;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        countryScore = new int[N][3];
        int sequence;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sequence = Integer.parseInt(st.nextToken())-1;
            countryScore[sequence][0] = Integer.parseInt(st.nextToken());
            countryScore[sequence][1] = Integer.parseInt(st.nextToken());
            countryScore[sequence][2] = Integer.parseInt(st.nextToken());
        }

        int answer = 1;
        for (int i = 0; i < N; i++) {
            if(countryScore[i][0] > countryScore[K-1][0])
                answer++;
            else if (countryScore[i][0] == countryScore[K-1][0]) {
                if(countryScore[i][1] > countryScore[K-1][1])
                    answer++;
                else if (countryScore[i][1] == countryScore[K-1][1]) {
                    if(countryScore[i][2] > countryScore[K-1][2])
                        answer++;
                    else continue;
                }
                else continue;
            }
            else continue;
        }

        System.out.println(answer);
    }
}