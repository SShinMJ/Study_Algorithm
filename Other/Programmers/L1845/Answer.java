import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int limit = nums.length / 2;
        int answer = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null) {
                answer++;
                map.put(nums[i], true);
            }

            if(answer == limit)
                break;
        }


        return answer;
    }
}