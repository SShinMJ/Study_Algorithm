import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(calBC(N, K));
    }

    // nCr = n! / (r! * (n - r)!)
    static int factorial(int N) {
        if(N == 0) {
            return 1;
        }
        return N * factorial(N - 1);
    }

    static int calBC(int N, int K) {
        // n과 r이 같거나, r=0 이라면 1
        if(N == K || K == 0) {
            return 1;
        }
        // '파스칼의 법칙' nCk = n-1Ck-1 + n-1Ck
        return calBC(N - 1, K - 1) + calBC(N - 1, K);
    }

    static int dpBC(int N, int K) {
        int[][] dp = new int[N + 1][K + 1]; // main에 선언
        // 이미 풀었던 sub문제일 경우 값을 재활용
        if(dp[N][K] > 0) {
            return dp[N][K];
        }

        // n과 r이 같거나, r=0 이라면 1
        if(N == K || K == 0) {
            return dp[N][K] = 1;
        }
        // '파스칼의 법칙' n+1Cr+1 = nCr + nCr+1
        return dp[N][K] = dpBC(N - 1, K - 1) + dpBC(N - 1, K);
    }
}