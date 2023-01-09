import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean isEmpty;
        StringBuilder sb = new StringBuilder();
        int last = 0;

        for (int i = 0; i < N; i++) {
            isEmpty = queue.isEmpty();
            st = new StringTokenizer(br.readLine());
            String cal = st.nextToken();

            if(cal.equals("push")) {
                last = Integer.parseInt(st.nextToken());
                queue.add(last);
            } else if(cal.equals("pop")) {
                if(!isEmpty)
                    sb.append(queue.poll() + "\n");
                else
                    sb.append("-1\n");
            } else if(cal.equals("size")) {
                sb.append(queue.size() + "\n");
            } else if(cal.equals("empty")) {
                if(!isEmpty)
                    sb.append("0\n");
                else
                    sb.append("1\n");
            } else if(cal.equals("front")) {
                if(!isEmpty)
                    sb.append(queue.peek() + "\n");
                else
                    sb.append("-1\n");
            } else {
                if(!isEmpty)
                    sb.append(last + "\n");
                else
                    sb.append("-1\n");
            }
        }

        System.out.println(sb);
    }

}