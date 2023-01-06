import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean isEmpty;
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();  //스택 선언
        String cal;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            isEmpty = stack.isEmpty();
            st = new StringTokenizer(br.readLine(), " ");
            cal = st.nextToken();

            if(cal.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (cal.equals("pop")) {
                if(!isEmpty) {
                    sb.append(stack.pop() + "\n");
                } else {
                    sb.append("-1\n");
                }
            } else if (cal.equals("size")) {
                sb.append(stack.size() + "\n");
            } else if (cal.equals("empty")) {
                if(!isEmpty) {
                    sb.append("0\n");
                } else {
                    sb.append("1\n");
                }
            } else {
                if(!isEmpty) {
                    sb.append(stack.peek() + "\n");
                } else {
                    sb.append("-1\n");
                }
            }
        }

        System.out.println(sb);
    }

}