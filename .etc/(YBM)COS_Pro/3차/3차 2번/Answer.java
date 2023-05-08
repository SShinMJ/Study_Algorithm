public class Solution {
    public boolean func_a(ArrayList<String> list, String s) {
		for (int i = 0; i < list.size(); i++)
            // palindromes에 같은 문자열이 이미 들어있는지 확인
			if (s.equals(list.get(i)))
				return true;
		return false;
	}

    public boolean func_b(String s) {
		int length = s.length();
		for (int i = 0; i < length / 2; i++)
            // 부분 문자열이 팰린드롬 문자열인지 확인
			if (s.charAt(i) != s.charAt(length - i - 1))
				return false;
		return true;
	}
    
    public String func_c(ArrayList<String> palindromes, int k) {
        // palindromes를 정렬. 
        Collections.sort(palindromes);
        // 배열 길이가 k보다 작다면 "NULL"을 리턴
        if (palindromes.size() < k)
        	return "NULL";
        // 그렇지 않으면 배열의 k-1번째 원소를 리턴
        else
        	return palindromes.get(k-1);
    }

    public String solution(String s, int k) {
        ArrayList<String> palindromes = new ArrayList<String>();
        int length = s.length();
        for (int startIdx = 0; startIdx < length; startIdx++) {
            for (int cnt = 1; cnt < length - startIdx + 1; cnt++) {
                String subStr = s.substring(startIdx, startIdx + cnt);
                // 부분 문자열이 팰린드롬 문자열인지 확인
                if (func_@@@(@@@)) {                // b, subStr
                    //palindromes에 같은 문자열이 이미 들어있는지 확인
                	if (func_@@@(@@@) == false)     // a, palindromes, subStr
                		palindromes.add(subStr);
                }
            }
        }

        String answer = func_@@@(@@@);              // c, palindromes, k
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
    	Solution sol = new Solution();
        String s1 = new String("abcba");
        int k1 = 4;
        String ret1 = sol.solution(s1, k1);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");
        
        String s2 = new String("ccddcc");
        int k2 = 7;
        String ret2 = sol.solution(s2, k2);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
