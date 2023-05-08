class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        int max = dp[0][0];
        for(int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                int lt = j-1 < 0 ? 0 : dp[i-1][j-1];
                int rt = dp[i-1][j];
                dp[i][j] = Math.max(lt, rt)  + triangle[i][j];
                if(i+1 == triangle.length) {
                    max = Math.max(max , dp[i][j]);
                }
            }
        }

        return max;
    }
}