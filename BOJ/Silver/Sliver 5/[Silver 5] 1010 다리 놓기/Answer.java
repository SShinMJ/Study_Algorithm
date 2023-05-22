import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N, M;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            dp = new long[M+1][N+1];
            // mCn 구하기
            // 조합은 뽑는 순서를 고려하지 않기 때문에
            // 다리가 교차되는 경우는 없다.
            sb.append(dpBC(M, N) + "\n");
        }

        System.out.println(sb);
    }

    static long dpBC(int N, int K) {
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