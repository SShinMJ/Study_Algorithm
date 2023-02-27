import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

// DP
public class Main {
    static int N;
    static int[][] nums;
    static int[][] mindp;
    static int[][] maxdp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        nums = new int[N+1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
            nums[i][2] = Integer.parseInt(st.nextToken());
        }

        mindp = new int[N+1][3];
        maxdp = new int[N+1][3];
        for (int i = 1; i <= N; i++)
        {
            mindp[i][0] = min(mindp[i - 1][0], mindp[i - 1][1]) + nums[i][0];
            mindp[i][1] = min(mindp[i - 1][0], min(mindp[i - 1][1], mindp[i - 1][2])) + nums[i][1];
            mindp[i][2] = min(mindp[i - 1][1], mindp[i - 1][2]) + nums[i][2];
            maxdp[i][0] = max(maxdp[i - 1][0], maxdp[i - 1][1]) + nums[i][0];
            maxdp[i][1] = max(maxdp[i - 1][0], max(maxdp[i - 1][1], maxdp[i - 1][2])) + nums[i][1];
            maxdp[i][2] = max(maxdp[i - 1][1], maxdp[i - 1][2]) + nums[i][2];
        }

        int max = max(maxdp[N][0], max(maxdp[N][1], maxdp[N][2]));
        int min = min(mindp[N][0], min(mindp[N][1], mindp[N][2]));

        System.out.println(max + " " + min);
    }
}