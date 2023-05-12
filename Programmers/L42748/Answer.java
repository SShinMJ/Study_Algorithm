import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int[] sortArray;
        int start, end, sequence;
        for(int i = 0; i < commands.length; i++) {
            start = commands[i][0];
            end = commands[i][1];
            sequence = commands[i][2];
            sortArray = new int[(end - start + 1)];

            for(int j = start-1; j < end; j++) {
                sortArray[j - start + 1] = array[j];
            }

            Arrays.sort(sortArray);
            answer[i] = sortArray[sequence-1];
        }

        return answer;
    }
}