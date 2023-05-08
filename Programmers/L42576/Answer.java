import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // 주의! 참가자 중에는 동명이인이 있을 수 있다.
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < completion.length; i++) {
            if(map.get(completion[i]) == null)
                map.put(completion[i], 1);
            else
                map.put(completion[i], map.get(completion[i])+1);
        }

        for(int i = 0; i < participant.length; i++) {
            if(map.get(participant[i]) == null) {
                answer = participant[i];
                break;
            } else {
                if(map.get(participant[i]) == 0) {
                    answer = participant[i];
                    break;
                }
                else
                    map.put(participant[i], map.get(participant[i])-1);
            }
        }

        return answer;
    }
}