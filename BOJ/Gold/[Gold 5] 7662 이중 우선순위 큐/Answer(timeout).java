import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int K;
        PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            K = Integer.parseInt(br.readLine());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                if(st.nextToken().equals("I")) {
                    int num = Integer.parseInt(st.nextToken());
                    priorityQueueHighest.add(num);
                    priorityQueueLowest.add(num);
                } else {
                    if(priorityQueueHighest.isEmpty())
                        sb.append("EMPTY\n");
                    else {
                        if (st.nextToken().equals("1")) {
                            int max = priorityQueueHighest.poll();
                            priorityQueueLowest.remove(max);
                        } else {
                            int min = priorityQueueLowest.poll();
                            priorityQueueHighest.remove(min);
                        }
                    }
                }
            }
        }

        if(priorityQueueHighest.isEmpty())
            sb.append("EMPTY\n");
        else {
            sb.append(priorityQueueHighest.peek() + " " + priorityQueueLowest.peek());
        }

        System.out.println(sb);
    }
}