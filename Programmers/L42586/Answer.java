import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        int idx = 0, days, nextDays, count;
        while(idx < progresses.length) {
            count = 1;
            days = (100 - progresses[idx]);
            days = (days % speeds[idx] != 0) ? (days / speeds[idx] + 1) : (days / speeds[idx]);

            idx++;
            for(int i = idx; i < progresses.length; i++) {
                nextDays = (100 - progresses[i]);
                nextDays = (nextDays % speeds[i] != 0) ? (nextDays / speeds[i] + 1) : (nextDays / speeds[i]);
                if(days < nextDays) {
                    idx = i;
                    break;
                } else {
                    count++;
                    idx++;
                }
            }

            list.add(count);
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}