import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// BFS
public class Main {
    static int N, K;
    static int[] count;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        count = new int[100001];
        parent = new int[100001];

        System.out.println(bfs(N));

        List<Integer> list = new ArrayList<>();
        list.add(K);
        int start = K;
        while(start != N) {
            list.add(parent[start]);
            start = parent[start];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.size()-1; i >= 0; i--) {
            sb.append(list.get(i) + " ");
        }

        System.out.println(sb);
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
                    count[start*2] = count[start]+1;
                    parent[start*2] = start;
                }
                if (start - 1 >= 0 && count[start - 1] == 0) {
                    q.add(start - 1);
                    count[start - 1] = count[start] + 1;
                    parent[start - 1] = start;
                }
                if (start+1 < 100001 && count[start + 1] == 0) {
                    q.add(start + 1);
                    count[start + 1] = count[start] + 1;
                    parent[start + 1] = start;
                }
            }
        }
        return -1;
    }
}