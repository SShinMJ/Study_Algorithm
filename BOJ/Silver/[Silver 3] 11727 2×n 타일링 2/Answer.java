import java.io.BufferedReader;
import java.io.InputStreamReader;

// DP
public class Main {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if(n == 1) {
            System.out.println(1);
            System.exit(0);
        }

        dp = new int[n];

        // 점화식 : dp[n] = dp[n-1] + (2 * dp[n-2])
        dp[0] = 1; dp[1] = 3;
        for (int i = 2; i < n; i++) {
            // 계속 숫자를 더하고 마지막 출력시에만 mod연산을 해줄 경우
            // Integer.MAX_VALUE를 넘어 Overflow가 발생하므로
            // 반드시 연산할 때마다 mod 연산을 해준다.
            dp[i] = (dp[i-1] + (2 * dp[i-2])) % 10007;
        }

        System.out.println(dp[n-1]);
    }
}

// 참고 : https://girawhale.tistory.com/34?category=915305