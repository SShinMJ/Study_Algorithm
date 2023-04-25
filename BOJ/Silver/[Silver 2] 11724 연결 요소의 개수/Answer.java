import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int x, y;
        graph = new int[N+1][N+1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            // 간선 연결
            graph[x][y] = graph[y][x] = 1;
        }

        int result = 0 ;
        visited = new boolean[N+1];
        // dfs 탐색
        for(int i = 1; i <= N; i++) {
            if(visited[i] == false) { // 방문한 적 없는 노드라면 dfs.
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    public static void dfs(int index) {
        if(visited[index] == true)
            return;
        else {
            visited[index] = true;
            for(int i = 1; i <= N; i++) {
                if(graph[index][i] == 1) {
                    dfs(i);
                }
            }
        }
    }
}