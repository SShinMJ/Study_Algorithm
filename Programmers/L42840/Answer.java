import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] eachCorr = new int[3];

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == first[(i % first.length)]) {
                eachCorr[0]++;
            }
            if(answers[i] == second[(i % second.length)]) {
                eachCorr[1]++;
            }
            if(answers[i] == third[(i % third.length)]) {
                eachCorr[2]++;
            }
        }

        List<Integer> list = new ArrayList<>();
        int maxCorr = Math.max(eachCorr[0], Math.max(eachCorr[1], eachCorr[2]));
        for(int i = 0; i < 3; i++) {
            if(maxCorr == eachCorr[i])
                list.add(i+1);
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }


        return answer;
    }
}