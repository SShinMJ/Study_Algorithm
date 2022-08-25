class Solution {
    public int[] solution(int N, int[] votes) {
        //후보수만큼의 크기의 배열 생성(이때 번호값이 중요하므로 1부터 담는다.)
        //후보수는 N이므로 11이 아닌 N+1이 들어가야한다.
        int voteCounter[] = new int[N+1];
        //votes에 담긴 투표된 후부 값에 맞는 배열에 +1 하여 후보별 추천 수를 카운트하는 배열 완성.
        for (int i = 0; i < votes.length; i++) {
            voteCounter[votes[i]] += 1;
        }
        //가장 많은 추천을 받은 후보 찾기.
        int maxVal = 0;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (maxVal < voteCounter[i]) {
                maxVal = voteCounter[i];
                cnt = 1;
            }
            //중복이면 답 배열 크기+1
            else if(maxVal == voteCounter[i]){
                cnt += 1;
            }
        }
        //답 배열에 추천 수가 가장 많은 후보 번호 넣기.
        int answer[] = new int[cnt];
        for (int i = 1, idx = 0; i <= N; i++){
            if (voteCounter[i] == maxVal) {
                answer[idx] = voteCounter[i];   // Answer : 답에는 후보의 번호를 출력해야 하므로 voteCounter[i] > i로 출력!
                idx += 1;
            }
        }
        return answer;
    }
    
    // The following is main method to output testcase. The main method is correct and you shall correct solution method.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int N1 = 5;
        int[] votes1 = {1,5,4,3,2,5,2,5,5,4};
        int[] ret1 = sol.solution(N1, votes1);
 
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + Arrays.toString(ret1) + " .");
        

        int N2 = 4;
        int[] votes2 = {1, 3, 2, 3, 2};
        int[] ret2 = sol.solution(N2, votes2);
 
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + Arrays.toString(ret2) + " .");
    }
}
