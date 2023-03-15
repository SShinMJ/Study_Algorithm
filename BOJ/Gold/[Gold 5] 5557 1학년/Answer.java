import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];

        String[] s = br.readLine().split(" ");

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        // 점화식
        // dp [i][prev+arr [i]] += dp [i-1][prev]
        // dp [i][prev-arr [i]] +=dp [i-1][prev]
        // (단, prev+arr [i]와 prev-arr [i]가 0 이상 0 이하인지 체크하고 진행해야 한다.)
        long [][] dp = new long[n][21];
        dp[0][arr[0]]=1;
        int plus;
        int minus;
        for(int i=1; i<n-1; i++){
            for(int j=0; j<=20; j++){
                if(dp[i-1][j]!=0){
                    plus = j+arr[i];
                    minus = j-arr[i];
                    if(plus>=0 && plus<=20){
                        dp[i][plus]+=dp[i-1][j];
                    }
                    if(minus>=0 && minus<=20){
                        dp[i][minus]+=dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[n-2][arr[n-1]]);
    }
}