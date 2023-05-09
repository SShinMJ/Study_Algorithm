import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Arrays.sort(truck_weights);

        int i = 0;
        int sum = 0;
        while(i < truck_weights.length) {
            sum += truck_weights[i];
            if(weight >= sum) {
                i++;
                if(i == truck_weights.length)
                    answer += bridge_length;
                else {
                    answer++;
                }
            } else {
                answer += bridge_length-1;
                sum = 0;
            }
        }

        return answer;
    }
}