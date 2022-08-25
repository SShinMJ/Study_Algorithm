class Solution{
    //B의 값일 경우 이길 수 있는 값을 리턴하여 같은지 확인.
    public int func(int record){
        if(record == 0) return 1;
        else if(record == 1) return 2;
        return 0;
    }

    public int solution(int[] recordA, int[] recordB){
        int cnt = 0;
        for(int i = 0; i < recordA.length; i++){
            //비기면
            if(recordA[i] == recordB[i])
                continue;
            //이기면
            else if(recordA[i] == func(recordB[i]))
                cnt = cnt + 3;
            else
                //계단을 올라가지 못한 경우 내려가지 않도록 조건문을 추가해야 한다.
                cnt = cnt - 1; // Answer : if(cnt != 0) cnt--; 
        }
        return cnt;
    }

    // The following is main method to output testcase. The main method is correct and you shall correct solution method.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] recordA = {2,0,0,0,0,0,1,1,0,0};
        int[] recordB = {0,0,0,0,2,2,0,2,2,2};
        int ret = sol.solution(recordA, recordB);

        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}
