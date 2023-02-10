import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }

        if(N == 1) {
            System.out.println(0);
            return;
        }

        int answer = 0;
        int sum = 0;
        while (true){
            sum = priorityQueue.poll() + priorityQueue.poll();
            answer += sum;
            if(priorityQueue.isEmpty())
                break;
            priorityQueue.add(sum);
        }

        System.out.println(answer);
    }
}
