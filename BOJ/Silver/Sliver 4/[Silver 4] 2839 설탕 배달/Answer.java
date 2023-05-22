import java.io.BufferedReader;
import java.io.InputStreamReader;

// DP
public class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        dp[0] = 0;
        dp(0);

        if(dp[N] != 0)
            System.out.println(dp[N]);
        else
            System.out.println(-1);
    }

    public static void dp(int n) {
        // f(n+3) = f(n)+1, f(n+5) = f(n)+1
        if(n+5 <= N && dp[n+5] == 0) {
            dp[n + 5] = dp[n] + 1;
            dp(n + 5);
        }
        if(n+3 <= N && dp[n+3] == 0) {
            dp[n + 3] = dp[n] + 1;
            dp(n + 3);
        }
    }
}