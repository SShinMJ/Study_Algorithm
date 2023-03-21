import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static char[] str1, str2;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        dp = new int[str1.length+1][str2.length+1];

        LCS();
        getLCSToString(str1.length, str2.length);

        System.out.println(sb);

    }

    public static void LCS() {
        for(int i = 1; i < str1.length+1; i++) {
            for(int j= 1; j < str2.length+1; j++) {
                if(str1[i-1] == str2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        sb.append(dp[str1.length][str2.length] + "\n");
    }

    static StringBuilder getLCSToString(int i, int j) {
        Stack<Character> st = new Stack<>();
        while(i > 0 && j > 0) {
            if(dp[i][j] == dp[i-1][j]) {
                i--;
            }
            else if(dp[i][j] == dp[i][j-1]) {
                j--;
            }
            else {
                st.push(str1[i-1]);
                i--;
                j--;
            }
        }

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb;
    }
}