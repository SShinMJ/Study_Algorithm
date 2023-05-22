import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DP
public class Main {
    static int N;
    static int[] reservDay;
    static int[] reservCost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        reservDay = new int[N];
        reservCost = new int[N+1];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            reservDay[i] = Integer.parseInt(st.nextToken());
            reservCost[i] = Integer.parseInt(st.nextToken());
        }

        //dp : N일에 얻을 수 있는 최대 수익
        int[] dp = new int[N+1];

        //점화식
        //현재 날짜에서 소요 시간과 비용을 더해 dp에 저장한다.
        //이후, 중복될 때 최대값을 넣는다.
        //dp[i + t[i]] = max(dp[i + t[i]], dp[i] + p[i]);

        for (int i=0; i<N; i++) {
            if (i + reservDay[i] <= N) {
                //날짜가 범위를 넘어가지 않는 경우
                dp[i + reservDay[i]] = Math.max(dp[i + reservDay[i]], dp[i] + reservCost[i]);
            }
            //현재 경우의 수가 0일 수 있기 때문에 이전의 최대값을 넣어줌.
            //해당 날짜에 일할 수 없다면, 이전까지 일한 최대 수당을 넣어주어야 한다.
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[N]);
    }
}