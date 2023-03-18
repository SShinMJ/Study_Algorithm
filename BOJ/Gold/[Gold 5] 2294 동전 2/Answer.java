import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] coins;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        dp = new long[K + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0;i < N; i++){
            for(int j = coins[i]; j <= K; j++){
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        if(dp[K] != Integer.MAX_VALUE)
            System.out.println(dp[K]);
        else
            System.out.println(-1);

    }
}