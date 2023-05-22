import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DP
public class Main {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[0] = dp[1] = 0;

        System.out.println(recur(N));
    }

    static int recur(int n) {
        if (n > 1 && dp[n] == 0) {
            // 6으로 나눠지는 경우
            if (n % 6 == 0) {
                dp[n] = Math.min(recur(n - 1), Math.min(recur(n / 3), recur(n / 2))) + 1;
            }
            // 3으로만 나눠지는 경우
            else if (n % 3 == 0) {
                dp[n] = Math.min(recur(n / 3), recur(n - 1)) + 1;
            }
            // 2로만 나눠지는 경우
            else if (n % 2 == 0) {
                dp[n] = Math.min(recur(n / 2), recur(n - 1)) + 1;
            }
            // 2와 3으로 나누어지지 않는 경우
            else {
                dp[n] = recur(n - 1) + 1;
            }
        }
        return dp[n];
    }
}