class Solution
{
    public int solution(int n, int m) {
        int answer = 0;

        for(int i = n; i <=m; i++) {
            if(checkNum(i))
                answer++;
        }

        return answer;
    }

    public static boolean checkNum(int num) {
        String numStr = String.valueOf(num);

        for(int i = 0; i < numStr.length() / 2; i++) {
            if(numStr.charAt(i) != numStr.charAt(numStr.length() - i - 1))
                return false;
        }

        return true;
    }
}