import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        int[][] dp = new int[N][M];
        int maxNum = 0;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                dp[i][j] = map[i][j] - '0';
                if(dp[i][j] == 1 && maxNum == 0) maxNum =1;
                if (j > 0 && i > 0) {
                    // [i-1][j], [i][j-1], [i-1][j-1] 셋이  0보다 크고 (사각형을 구성할 조건을 갖춤),
                    // [i][j](현재위치)가 1이라면 나머지 셋중 가장 작은 값에 +1
                    if (dp[i - 1][j] > 0 && dp[i][j - 1] > 0 && dp[i - 1][j - 1] > 0 && dp[i][j] == 1) {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                        maxNum = Math.max(dp[i][j], maxNum);
                    }
                }
            }
        }
        System.out.println(maxNum* maxNum);
    }
}