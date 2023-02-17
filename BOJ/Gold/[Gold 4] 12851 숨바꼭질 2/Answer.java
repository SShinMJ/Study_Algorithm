import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
public class Main {
    static int N, K;
    static int[] count;
    static int cnt = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        count = new int[100001];
        bfs(N);
        System.out.println(count[K]-1);
        System.out.println(cnt);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        count[start] = 1;
        int min = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            start = q.poll();

            if(start == K) {
                if(min > count[start]-1) {
                    min = count[start]-1;
                    cnt = 1;
                } else if(min == count[start]-1){
                    cnt++;
                }
            } else {
                if(100001 > start*2 && (count[start*2] == 0 || count[start*2] == count[start]+1)) {
                    q.add(start * 2);
                    count[start*2] = count[start]+1;
                }
                if (start+1 < 100001 && (count[start+1] == 0 || count[start+1] == count[start]+1)) {
                    q.add(start + 1);
                    count[start + 1] = count[start] + 1;
                }
                if (start - 1 >= 0 && (count[start-1] == 0 || count[start-1] == count[start]+1)) {
                    q.add(start - 1);
                    count[start - 1] = count[start] + 1;
                }
            }
        }
    }
}