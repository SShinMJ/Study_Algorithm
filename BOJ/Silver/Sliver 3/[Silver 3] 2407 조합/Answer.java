import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    // 게산 값이 long 범위를 벗어날 수 있으므로 BigInteger 사용.
    static BigInteger[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 단순 팩토리얼이나 파스칼법칙을 사용하면 시간초과.
        // 캐싱을 통해 이미 계산한 것을 재활용하여 시간을 줄여야하므로
        // dp를 사용한다.
        dp = new BigInteger[N + 1][K + 1];
        System.out.println(dpBC(N, K));
    }

    static BigInteger dpBC(int N, int K) {
        // 이미 풀었던 sub문제일 경우 값을 재활용
        if(dp[N][K] != null) {
            return dp[N][K];
        }

        // n과 r이 같거나, r=0 이라면 1
        if(N == K || K == 0) {
            return dp[N][K] = BigInteger.ONE;
        }
        // '파스칼의 법칙' n+1Cr+1 = nCr + nCr+1
        return dp[N][K] = dpBC(N - 1, K - 1).add(dpBC(N - 1, K));
    }
}