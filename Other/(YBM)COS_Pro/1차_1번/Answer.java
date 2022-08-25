class Solution {
  long solution(long num) {
        //num 일의 자리가 9라면 < num+2
            //num+2/10의 값이 0이 아니고, 십의 자리가 0이라면 num+10
                //위 과정을 100의 자리, 1000의 자리 순으로 늘려가며 반복
                //나눈 값이 0이라면 종료 후 answer에 담아 리턴

        // >> 피드백 : 나머지 값이 0일 경우 1을 더하는 과정이 쉬움!(num%10 == 0 ? num+1 : null)
        num++;
        long digit = 1;
        while (num / digit % 10 == 0) {
            num += digit;
            digit *= 10;
        }
        return num;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution sol = new Solution();
        long num = 9949999;
        long ret = sol.solution(num);

        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}
