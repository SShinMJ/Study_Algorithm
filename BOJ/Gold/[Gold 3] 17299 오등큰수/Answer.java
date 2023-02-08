import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 출처 : https://dy-coding.tistory.com/m/entry/%EB%B0%B1%EC%A4%80-17299%EB%B2%88-%EC%98%A4%EB%93%B1%ED%81%B0%EC%88%98
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        int[] numCount = new int[1000001];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            numCount[nums[i]]++;
        }

        StringBuilder sb = new StringBuilder();
        int[] answer = new int[N];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < N; i++){
            // stack에 있는 index의 count와 비교
            // stack을 peek한 값이 새로 들어오는 index의 count보다 작다면
            while(!s.isEmpty() && numCount[nums[s.peek()]]<numCount[nums[i]]){
                // index를 pop해주고 peek한 값을 새로 들어온 index의 data값으로 바꿔준다.
                answer[s.pop()] = nums[i];
            }

            // 같다면 stack에 있는 값을 pop하지 않고 add
            // stack에는 data의 index를 넣는다.
            s.add(i);
        }

        // 새로 들어오는 data가 없기 때문에 오등큰수를 찾을 수 없어
        // stack에 남아있는 index들의 answer을 -1로 초기화
        while(!s.isEmpty())
            answer[s.pop()] = -1;

        for(int i = 0; i<N; i++)
            sb.append(answer[i]).append(" ");

        System.out.println(sb);
    }
}