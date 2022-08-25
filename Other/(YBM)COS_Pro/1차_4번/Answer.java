import java.util.*;

class Solution {
    public int[] solution(int[] arrA, int[] arrB) {
        int arrA_idx = 0, arrB_idx = 0;
        int arrA_len = arrA.length;
        int arrB_len = arrB.length;
        int answer[] = new int[arrA_len + arrB_len];
        int answer_idx = 0;
        //A와 B 배열의 크기가 다를 수 있으므로 둘 중 작은 크기의 배열 값이 다 입력되면 종료.
        while(@@@){  // @@@ = arrA_idx < arrA_len && arrB_idx < arrB_len
            if(arrA[arrA_idx] < arrB[arrB_idx])
                answer[answer_idx++] = arrA[arrA_idx++];
            else
                answer[answer_idx++] = arrB[arrB_idx++];
        }
        //A와 B 배열의 크기가 다르면 비교가 불가. 따라서 더 큰 크기의 남은 배열 값들을 넣어준다. 
        while(@@@)  // @@@ = arrA_idx < arrA_len
            answer[answer_idx++] = arrA[arrA_idx++];
        while(@@@)  // @@@ = arrB_idx < arrB_len
            answer[answer_idx++] = arrB[arrB_idx++];
        return answer;
    }
    
    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arrA = {-2, 3, 5, 9};
        int[] arrB = {0, 1, 5};
        int[] ret = sol.solution(arrA, arrB);
 
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + Arrays.toString(ret) + " .");
    }
}
