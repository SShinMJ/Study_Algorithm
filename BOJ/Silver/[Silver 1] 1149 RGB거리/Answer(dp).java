import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] arr = new int[N][3];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            for(int j=0;j<3;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());	// 각 집마다 R,G,B 가격 저장
            }
        }
        int[][] dp = new int[N][3];	//  현재까지 칠한 값의 합

        for(int i=0;i<3;i++) {
            // 첫번째 집: i번쨰 색깔을 칠하면  해당 dp에 저장
            dp[0][i] = arr[0][i];
        }
        for(int i=1; i<N;i++) {
            // 현재 0번쨰 색깔을 칠하는 경우: 전까지 1,2번째 색깔 누적 합 중 최소인 것 + 현재 새깔의 가격을 dp 배열에 저장
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            // 현재 1번쨰 색깔을 칠하는 경우: 전까지 0,2번째 색깔 누적 합 중 최소인 것 + 현재 새깔의 가격을 dp 배열에 저장
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            // 현재 0번쨰 색깔을 칠하는 경우: 전까지 0,1번째 색깔 누적 합 중 최소인 것 + 현재 새깔의 가격을 dp 배열에 저장
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }
        int min = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
        System.out.println(min);
    }
}