import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int answer = 0;
        boolean flag = true;
        int leftCal =1;
        char cur;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            cur = s.charAt(i);
            if(cur == '('){
                leftCal *= 2;
                stack.add(cur);
            } else if(cur == '['){
                leftCal *= 3;
                stack.add(cur);
            } else {
                if (cur == ')') {
                    // 괄호가 잘못됐을 경우 멈추고 0 출력
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag=false;
                        break;
                    }
                    // 바로 이전 값이 ')'이면 지금까지 저장해놓은 값을 answer에 저장
                    if(s.charAt(i-1) =='(') {
                        answer += leftCal;
                    }
                    // 괄호가 닫힐 때마다 저장해준 값들을 정리
                    stack.pop();
                    leftCal /= 2;
                } else if (cur ==']') {
                    // 괄호가 잘못됐을 경우 멈추고 0 출력
                    if(stack.isEmpty() || stack.peek() != '[') {
                        flag=false;
                        break;
                    }
                    // 바로 이전 값이 ']'이면 지금까지 저장해놓은 값을 answer에 저장
                    if(s.charAt(i-1)=='[') {
                        answer += leftCal;
                    }
                    // 괄호가 닫힐 때마다 저장해준 값들을 정리
                    stack.pop();
                    leftCal /= 3;
                } else {
                    flag = false;
                    break;
                }
            }
        }

        // 에러이거나 st이 비어있지 않으면 0 출력
        if(!flag || !stack.isEmpty()) {
            System.out.println(0);
        }
        // 올바른 괄호일 경우 answer 출력
        else {
            System.out.println(answer);
        }
    }

}