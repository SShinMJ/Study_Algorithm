import java.io.BufferedReader;
import java.io.InputStreamReader;

// DP
public class Main {
    static int T, N;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        dp = new int[11];
        dp[0] = 0;
        dp(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N] + "\n");
        }

        System.out.println(sb);
    }

    public static void dp(int n) {
        if(n+1 < 11) {
            dp(n + 1);
            dp[n + 1]++;
        }
        if(n+2 < 11) {
            dp(n + 2);
            dp[n + 2]++;
        }
        if(n+3 < 11) {
            dp(n+3);
            dp[n+3]++;
        }
    }
}