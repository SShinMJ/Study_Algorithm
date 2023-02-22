import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// BFS
public class Main {
    static int N, M;
    static int[][] map;
    static int result = Integer.MIN_VALUE;
    static int[] directionX = {1, 0, -1, 0};
    static int[] directionY = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(result);
    }

    // 벽을 3개 세우는 모든 경우의 수를 탐색할 dfs
    public static void dfs(int depth) {
        if (depth == 3) {
            // 벽 3개를 세우는 경우의 수 마다 바이러스 확산 시뮬레이션을 한다.
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // 바이러스 확산 시뮬 BFS
    public static void bfs() {
        int[][] virus_map = new int[N][M];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 벽이 세워진 map의 값들을 받아 새로 virus_map을 만든다.
                virus_map[i][j] = map[i][j];
                // 동시에 바이러스의 위치를 큐에 모두 담는다.
                if (virus_map[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int x, y;
        while (!queue.isEmpty()) {
            int[] move = queue.poll();
            x = move[0];
            y = move[1];

            for (int i = 0; i < 4; i++) {
                int nowX = x + directionX[i];
                int nowY = y + directionY[i];

                if(nowX < 0 || nowY < 0 || nowX >= N || nowY >= M)
                    continue;

                if(virus_map[nowX][nowY] == 0) {
                    virus_map[nowX][nowY] = 2;
                    queue.add(new int[]{nowX, nowY});
                }
            }
        }

        // 바이러스 확산이 끝난 후 남은 안전 구역의 개수를 센다.
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virus_map[i][j] == 0) {
                    count++;
                }
            }
        }

        // dfs를 통해 구해진 벽을 세우는 모든 경우에 수에 대한 바이러스 확산도를
        // 구하면서 안전구역이 최대로 될 때를 구한다.
        result = Math.max(result, count);
    }
}