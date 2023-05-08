class Solution {
    boolean solution(String s) {
        int leftParent = 0;
        for(int i = 0; i < s.length(); i++) {
            // 1. '('를 만났을 경우
            if(s.charAt(i) == '(') {
                leftParent++;
            }
            // 2. ')'를 만났을 경우
            else {
                // 2-1. '('를 만난 적이 없는 경우
                if(leftParent == 0)
                    return false;
                    // 2-2. '('를 만난 적이 있는 경우
                else
                    leftParent--;
            }
        }

        if(leftParent != 0)
            return false;
        else
            return true;
    }
}