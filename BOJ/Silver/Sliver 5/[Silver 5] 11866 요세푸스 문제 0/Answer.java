import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<Integer>();
        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] seq = new int[N];
        int count = 0;
        while (count < N) {
            for (int i = 1; i < K; i++) {
                int temp = deque.pollFirst();
                deque.offerLast(temp);
            }
            seq[count] = deque.pollFirst();
            count++;
        }

        System.out.print("<");
        for (int i = 0; i < seq.length; i++) {
            System.out.print(seq[i]);
            if(i != seq.length-1)
                System.out.print(", ");
        }
        System.out.println(">");
    }
}