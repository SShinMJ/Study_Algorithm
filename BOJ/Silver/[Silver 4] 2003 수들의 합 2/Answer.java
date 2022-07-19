import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int numbers[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++){
            numbers[n] = Integer.parseInt(st.nextToken());
        }

        int low = 0, high = 0, sum = numbers[0], count = 0;
        while (true) {
            if(sum == M){
                count++;
                sum -= numbers[low++];
            }
            else if (sum > M) {
                sum -= numbers[low++];
            }
            else {
                sum += numbers[++high];
            }
            if(high == N)
                break;
        }
        System.out.println(count);
    }
}
