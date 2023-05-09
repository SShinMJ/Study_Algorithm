import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<List<Integer>> queue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            queue.add(Arrays.asList(priorities[i], i));
        }

        int answer = 1;
        while(true) {
            for(int i = 1; i < priorities.length; i++) {
                for(int j = 0; j < queue.size(); j++) {
                    if(queue.peek().get(0) < priorities[i]) {
                        queue.add(queue.poll());
                    } else {
                        break;
                    }
                }
            }

            if(queue.peek().get(1) != location) {
                queue.poll();
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}