import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();

        list.add(arr[0]);
        int count = 0;
        for(int i = 1; i < arr.length; i++) {
            if(list.get(count) != arr[i]) {
                count++;
                list.add(arr[i]);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}