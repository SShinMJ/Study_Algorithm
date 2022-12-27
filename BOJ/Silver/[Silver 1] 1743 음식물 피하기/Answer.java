import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] nums;
    static int biggest;
    static int[] dx = {1, 0 , -1, 0};       // 상하좌우 계산할 x좌표
    static int[] dy = {0, 1, 0, -1};        // 상하좌우 계산할 y좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        nums = new boolean[N+1][M+1];
        int x, y;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            nums[x][y] = true;
        }

        biggest = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // 해당 위치에서 뭉쳐진 음식물의 크기가 더 크다면 교체
                if(nums[i][j]) {
                    biggest = Math.max(biggest, bfs(i, j));
                }
            }
        }

        System.out.println(biggest);
    }

    public static int bfs(int n, int m) {
        Queue<Pair> qu = new LinkedList<>();
        int sum = 1;
        qu.offer(new Pair(n,m));  // 시작점
        // 체크인. 한 번 계산하면 필요 없으므로 false.
        // == checked 리스트를 따로 둘 필요가 없다! (메모리 초과 원인)
        nums[n][m] = false;

        while(!qu.isEmpty()){
            Pair p = qu.poll();

            // 상, 하, 좌, 우를 계산해준다.
            for(int i=0; i<4; i++){
                int nX = p.x + dx[i];
                int nY = p.y + dy[i];

                // 벽에 부딪히거나, 범위를 넘어가면 PASS
                if(nX <= 0 || nX > N || nY <= 0 || nY > M){
                    continue;
                }
                // 길이 아니거나, 방문을 했다면 PASS
                if(!nums[nX][nY]){
                    continue;
                }

                // 큐에 이동한 좌표를 넣어준다.
                qu.offer(new Pair(nX, nY));
                nums[nX][nY] = false; // 체크인
                sum++; // 음식물의 크기 계산
            }
        }
        return sum;
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