import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[15][16];
        for (int i = 1; i < dp.length; i++) {
            dp[0][i] = i;

        }
        for (int j = 1; j <= 14; j++) {
            for (int l = 1; l <= 15; l++) {
                if(l == 1)
                    dp[j][l] = dp[j-1][l];
                else {
                    dp[j][l] = dp[j][l-1] + dp[j-1][l];
                }
            }
        }

        int k, n;
        for (int i = 0; i < T; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());

            sb.append(dp[k][n] + "\n");
        }

        System.out.println(sb);
    }
}