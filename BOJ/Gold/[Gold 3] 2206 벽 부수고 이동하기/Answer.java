import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// BFS
public class Main {
    static int N, M;
    static int[][] map;
    static int[][] distance;
    static boolean[][][] visited;    // 벽을 부순 여부에 따라 방문 여부 기록

    static int[] directionX = {1, 0, -1, 0};
    static int[] directionY = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 시작지점과 도착지점이 같을 경우!
        if(N-1 == 0 && M-1 == 0){
            System.out.print(1);
            System.exit(0);
        }

        map = new int[N][M];
        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        visited = new boolean[2][N][M];
        distance = new int[N][M];
        bfs();
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        distance[0][0] = 1;
        visited[0][0][0] = true;
        int x, y;
        int nowX, nowY;

        while(!q.isEmpty()) {
            int[] move = q.poll();
            x = move[0];
            y = move[1];

            for (int i = 0; i < 4; i++) {
                nowX = x + directionX[i];
                nowY = y + directionY[i];

                if(nowX < 0 || nowY < 0 || nowX >= N || nowY >= M)
                    continue;

                if(nowX == N-1 && nowY == M-1) {
                    System.out.println(distance[x][y]+1);
                    return;
                }

                // 다음 칸에 벽이 있을 때 -> (1) 벽을 부순적이 있는지 체크
                //                        (2) 그 벽을 방문한적이 있는지 체크
                if(map[nowX][nowY] == '1') {
                    if(move[2] == 0 && !visited[1][nowX][nowY]) {
                        visited[move[2]][nowX][nowY] = true;    // 방문 처리
                        distance[nowX][nowY] = distance[x][y] + 1; // 거리 측정
                        q.offer(new int[]{nowX, nowY, 1});    // 다시 큐에 넣어줘서 BFS!
                    }
                }
                // 벽이 아닐 경우 -> 벽을 "부순 여부"에 따른 방문을 했는지 체크!
                else {
                    if(!visited[move[2]][nowX][nowY]){
                        // 해당 칸을 방문을 안했을 때!
                        visited[move[2]][nowX][nowY] = true;    // 방문 처리
                        distance[nowX][nowY] = distance[x][y] + 1; // 거리 측정
                        q.offer(new int[]{nowX, nowY, move[2]});    // 다시 큐에 넣어줘서 BFS!
                    }
                }
            }
        }
        System.out.println(-1);
    }
}