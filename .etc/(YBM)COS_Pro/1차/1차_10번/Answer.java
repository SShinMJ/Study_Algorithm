class Solution {
    class Pair{
        public int firstNum;
        public int secondNum;
    }
    
    public int func_a(int numA, int numB, char exp){
        if (exp == '+')
            return numA + numB;
        else if (exp == '-')
            return numA - numB;
        else
            return numA * numB;
    }
    
    public int func_b(String exp){
        for(int i = 0; i < exp.length(); i++){
            char e = exp.charAt(i);
            if(e == '+' || e == '-' || e == '*')
                return i;
        }
        return -1;
    }
    public Pair func_c(String exp, int idx){
        Pair ret = new Pair();
        ret.firstNum = Integer.parseInt(exp.substring(0, idx));
        ret.secondNum = Integer.parseInt(exp.substring(idx + 1));
        return ret;
    }
    
    public int solution(String expression) {
        int expIndex = func_@@@(@@@);  // b, expression
        Pair numbers = func_@@@(@@@);  // c, expIndex
                                            // class 객체의 변수 : 객체명.변수명 
        int result = func_@@@(@@@);     // a, numbers.fisrtNum, numbers.secondNum, exp.charAt(expIndex)
                                                                                //func_b에서 i번째에 연산자가 존재함을 알 수 있다.
                                                                                //문자열의 i번째 문자 추출 : .charAt(i)
        return result;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution sol = new Solution();
        String expression = "123+12";
        int ret = sol.solution(expression);

        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}
