import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        for(int i = 1; i <= N; i++) {
            int top = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()) {
                if(stack.peek()[1] >= top) {
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
                //  입력 받은 높이 값이 현재 높이값 보다 낮을 경우에도
                //  어차피 해당 탑에는 레이저가 닿을 수 없으므로 pop
                stack.pop();
            }

            // 현재 스택이 비어있다면 레이저가 닿을 수 있는 탑이 없다는 의미이므로 0을 출력
            if(stack.isEmpty()) {
                System.out.print("0 ");
            }

            // 출력을 위한 탑의 위치 값 i와 탑의 높이 값 top을 함께 stack 넣는다.
            stack.push(new int[] {i, top});
        }
    }
}

// 참고 : https://moonsbeen.tistory.com/204