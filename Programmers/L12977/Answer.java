class Solution {
    static int[] numList;
    static int answer = 0;

    public int solution(int[] nums) {
        numList = nums;

        dfs(0, 0, 0);

        return answer;
    }

    public static void dfs(int idx, int cnt, int sum) {
        for(int i = idx; i < numList.length; i++) {
            if(cnt < 2) {
                dfs(i+1, cnt+1, sum+numList[i]);
            } else {
                if(checkNum(sum+numList[i]))
                    answer++;
            }
        }
    }

    public static boolean checkNum(int num) {
        for(int i = 2; i*i <= num; i++) {
            if(num % i == 0)
                return false;
        }

        return true;
    }
}