class Solution {
    // 자릿수의 절반으로 나눌 수 있는 기준값 구하기
    public int func_a(int n){
        int ret = 1;
        while(n > 0){
            ret *= 10;
            n--;
        }
        return ret;
    }

    // 자릿수 계산
    int func_b(int n){
        int ret = 0;
        while(n > 0){
            ret++;
            n /= 10;
        }
        return ret;
    }
    
    //각 자릿수의 합
    int func_c(int n){
        int ret = 0;
        while(n > 0){
            ret += n%10;
            n /= 10;
        }
        return ret;
    }
    
	public int solution(int num) {
        int nextNum = num;
        while(true){
            nextNum++;
            // 자릿수 계산
            int length = func_@@@(@@@);  // b, nextNum
            if(length % 2 != 0)
                continue;

            // 앞 자릿수 절반과 뒷 자릿수 절반을 분리하기
                                              // 절반으로 분리하므로 전체 길이의 절반 값 넘겨줌.
            int divisor = func_@@@(@@@); // a, length/2
            int front = nextNum / divisor;
            int back = nextNum % divisor;
            
            // 앞과 뒤 자리수들의 합 구하기
            int frontSum = func_@@@(@@@); // c, front
            int backSum = func_@@@(@@@);  // c, back
            if(frontSum == backSum)
                break;
        }
        return nextNum - num;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int num1 = 1;
        int ret1 = sol.solution(num1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int num2 = 235386;
        int ret2 = sol.solution(num2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
