import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] dp = new int[N][N];
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//      - 반복문(Bottom-Up)
        dp[0][0] = arr[0][0];

        int max = dp[0][0];
        for (int i = 1; i < N; i++) {
            for(int j = 0; j <= i; j++) {
                int lt = j-1 < 0 ? 0 : dp[i-1][j-1];
                int rt = dp[i-1][j];
                dp[i][j] = Math.max(lt, rt)  + arr[i][j];
                if(i+1 == N) {
                    max = Math.max(max , dp[i][j]);
                }
            }
        }

        System.out.println(max);
    }
}