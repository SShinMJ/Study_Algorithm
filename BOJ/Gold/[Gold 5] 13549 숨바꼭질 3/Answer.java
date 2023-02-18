import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
public class Main {
    static int N, K;
    static int[] count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        count = new int[100001];

        System.out.println(bfs(N));
    }

    public static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        count[start] = 1;

        while(!q.isEmpty()) {
            start = q.poll();

            if(start == K) {
                return count[start]-1;
            } else {
                if(100001 > start*2 && count[start*2] == 0) {
                    q.add(start * 2);
                    count[start*2] = count[start];
                }
                if (start - 1 >= 0 && count[start - 1] == 0) {
                    q.add(start - 1);
                    count[start - 1] = count[start] + 1;
                }
                if (start+1 < 100001 && count[start + 1] == 0) {
                    q.add(start + 1);
                    count[start + 1] = count[start] + 1;
                }
            }
        }
        return -1;
    }
}