import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N%2 == 0) {
            int[] dp = new int[Math.max(N/2, 2)];
            dp[0] = 3;
            dp[1] = 11;
            int tmp = 0;
            for (int i = 2; i < N/2; i++) {
                // 점화식 ( n=4 부터 2가지 경우의 수가 추가되는 것을 생각한다. )
                dp[i] = dp[i-1] * 3 + 2 + (tmp+=dp[i-2]*2);
            }
            System.out.println(dp[N/2-1]);
        } else {
            System.out.println(0);
        }
    }
}