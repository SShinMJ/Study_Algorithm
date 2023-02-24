import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DP
public class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0] = Integer.parseInt(st.nextToken());
        int num;
        int max = dp[0];
        for (int i = 1; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            if(dp[i-1] + num > num) {
                dp[i] = dp[i-1] + num;
            } else {
                dp[i] = num;
            }
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}