class Solution {
    public String func_a(String str, int len){
        String padZero = "";
                            // 해당 문자열이 최대 길이와 같아질 수 있도록 부족한 길이만 가져올 수 있도록 한다.
        int padSize = @@@;  // @@@ = len - str.length()
        for(int i = 0; i < padSize; i++)
            padZero += "0";
        return padZero + str;
    }
    
    public int solution(String binaryA, String binaryB) {
        int maxLength = Math.max(binaryA.length(), binaryB.length());
        binaryA = func_a(binaryA, maxLength);
        binaryB = func_a(binaryB, maxLength);
        
        int hammingDistance = 0;
        for(int i = 0; i < maxLength; i++)
                    // binaryA, binaryB는 String이므로 한글자씩 가져오려면 charAt 사용!
            if(@@@)  // @@@ = binaryA.charAt(i) != binaryB.charAt(i)
                hammingDistance += 1;
        return hammingDistance;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution sol = new Solution();
        String binaryA = "10010";
        String binaryB = "110";
        int ret = sol.solution(binaryA, binaryB);
        
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}
