import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] isBabyShark;
    static int[] dx = {1, 1, -1, -1, 1, 0 , -1, 0};       // 8방향 계산할 x좌표
    static int[] dy = {1, -1, 1, -1, 0, 1, 0, -1};        // 8방향 계산할 y좌표
    static int sharkDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isBabyShark = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                isBabyShark[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int safetyDist = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(isBabyShark[i][j] == 0) {
                    sharkDistance = 0;
                    bfs(i, j);
                    // 최대한 멀어질 수 있는 거리(안전 거리)를 저장
                    safetyDist = Math.max(safetyDist, sharkDistance);
                }
            }
        }

        System.out.println(safetyDist);
    }

    public static void bfs(int n, int m) {
        Queue<Pair> qu = new LinkedList<>();
        int[][] distance = new int[N+1][M+1];
        qu.offer(new Pair(n,m));  // 시작점
        distance[n][m] = 1;

        while(!qu.isEmpty()){
            Pair p = qu.poll();

            // 8방향 모두를 계산해준다.
            for(int i=0; i<8; i++){
                int nX = p.x + dx[i];
                int nY = p.y + dy[i];

                // 벽에 부딪히거나, 범위를 넘어가면 PASS
                if(nX <= 0 || nX > N || nY <= 0 || nY > M){
                    continue;
                }

                // BFS로 탐색할 경우 가장 먼저 발견된 1이 가장 가까운 것이므로 그냥 종료한다.
                if(isBabyShark[nX][nY] == 1) {
                    sharkDistance =  distance[p.x][p.y];
                    return;
                }

                // 이미 지나간 경로라면 PASS
                if(distance[nX][nY] > 0)
                    continue;

                // 큐에 이동한 좌표를 넣어준다.
                qu.offer(new Pair(nX, nY));
                // 한칸 이동하였기 때문에, 이전 출발지점의 거리 +1을 해준다.
                distance[nX][nY] = distance[p.x][p.y] + 1;
            }
        }
    }

    // 큐에 좌표를 넣어주기 위한 클래스
    public static class Pair{
        int x, y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}