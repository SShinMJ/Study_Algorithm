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
        q.add(start);  // 시작 노드를 받아온다.
        count[start] = 1;

        while(!q.isEmpty()) {  // 모두 돌 때까지 순회
            start = q.poll();  // 큐에서 꺼낸다.

            // 연결된 곳을 순회
            if(start == K) {  // 목적지에 도착한다면(동생을 찾았다면),
                return count[start]-1;
            } else { // 더 움직여야 한다면
                if(100001 > start*2 && count[start*2] == 0) {
                    q.add(start * 2);  // 'X*2로 이동'을 큐에 넣는다.
                    count[start*2] = count[start]+1;
                }
                if (start+1 < 100001 && count[start + 1] == 0) {
                    q.add(start + 1);  // 'X+1로 이동'을 큐에 넣는다.
                    count[start + 1] = count[start] + 1;
                }
                if (start - 1 >= 0 && count[start - 1] == 0) {
                    q.add(start - 1);  // 'X-1로 이동'을 큐에 넣는다.
                    count[start - 1] = count[start] + 1;
                }
            }
        }
        return -1;
    }
}