import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] sortNum = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            sortNum[i] = Integer.toString(numbers[i]);
        }

        // 비교하는 두 숫자를 앞, 뒤로 번갈아가며 이어붙인 것을 기준으로 비교한다
        Arrays.sort(sortNum, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 0은 여러개 쓸 필요x
        if (sortNum[0].equals("0")) {
            return "0";
        }

        String answer = "";
        for(String s : sortNum)
            answer += s;

        return answer;
    }
}