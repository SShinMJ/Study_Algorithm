import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long mod = 1_000_000_000;

        long[][] dp = new long[N + 1][10];
        // 점화식
        // 길이가 i이고 j=0으로 시작하는 수 일 때, dp[i][j] = dp[i-1][j+1]
        // 길이가 i이고 j=1~8로 시작하는 수일 때, dp[i][j] = dp[i-1][j+1] + dp[i-1][j+1]
        // 길이가 i이고 j=9로 시작하는 수일 때, dp[i][j] = dp[i-1][j-1]
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0)
                    dp[i][j] = (dp[i - 1][j + 1]) % mod;
                else if (j == 9)
                    dp[i][j] = (dp[i - 1][j - 1]) % mod;
                else
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;

            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[N][i];
        }
        System.out.println(sum % mod);
    }
}