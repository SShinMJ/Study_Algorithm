import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int count = 0;
        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(N % i == 0) {
                count++;
                if (count == K) {
                    answer = i;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
