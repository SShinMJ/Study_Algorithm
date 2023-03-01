import java.io.BufferedReader;
import java.io.InputStreamReader;

// DP
public class Main {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // Bottom-Up
        dp[1] = arr[1];
        if (N > 1) {
            dp[2] = arr[1] + arr[2];
        }
        for (int i = 3; i <= N; i++) {
            // 마지막 dp의 값이 항상 최댓값을 보장하는 것이 아니기 때문에
            // dp[i - 2] 와 dp[i - 3] + arr[i - 1] 중 큰 값이 반환되었을 때,
            // 이 값을 이전 N인 dp[i - 1]과 '비교'하여 dp[N]의 최댓값을 갱신하는 것
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));

        }
        System.out.println(dp[N]);
    }
}