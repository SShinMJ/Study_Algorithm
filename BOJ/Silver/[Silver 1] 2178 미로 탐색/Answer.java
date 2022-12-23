import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] miro;  // 미로를 저장할 배열
    static int[][] dist;   // 거리를 계산할 dist 배열
    static int[] dx = {1, 0 , -1, 0};       // 상하좌우 계산할 x좌표
    static int[] dy = {0, 1, 0, -1};        // 상하좌우 계산할 y좌표
    static Queue<Pair> qu;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new char[N][M];
        dist = new int[N][M];
        qu = new LinkedList<>();

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                miro[i][j] = line.charAt(j);
                dist[i][j] = -1;    // 거리를 -1로 세팅하면, 방문여부를 확인가능.
            }
        }

        qu.offer(new Pair(0,0));  // 시작점
        dist[0][0] = 1;   // 연결된 칸 수를 세야하므로 1부터 시작.
        bfs();

        // 마지막 지점의 거리를 출력해주면 된다.
        System.out.print(dist[N-1][M-1]);
    }

    public static void bfs() {
        while(!qu.isEmpty()){
            Pair p = qu.poll();

            // 상, 하, 좌, 우를 계산해준다.
            for(int i=0; i<4; i++){
                int nX = p.x + dx[i];
                int nY = p.y + dy[i];

                // 벽에 부딪히거나, 범위를 넘어가면 PASS
                if(nX < 0 || nX >= N || nY < 0 || nY >= M){
                    continue;
                }
                // 길이 아니거나, 방문을 했다면 PASS
                if(miro[nX][nY] == '0' || dist[nX][nY] != -1){
                    continue;
                }

                // 큐에 이동한 좌표를 넣어준다.
                qu.offer(new Pair(nX, nY));
                // 한칸 이동하였기 때문에, 이전 출발지점의 거리 +1을 해준다.
                dist[nX][nY] = dist[p.x][p.y] + 1;
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

// 출처 : https://iseunghan.tistory.com/312