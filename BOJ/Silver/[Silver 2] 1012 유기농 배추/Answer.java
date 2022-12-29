import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] cabbage;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            cabbage = new boolean[N][M];
            int x, y;
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                cabbage[x][y] = true;
            }

            int earthwormNum = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(cabbage[j][k]) {
                        bfs(j, k);
                        earthwormNum++;
                    }
                }
            }

            System.out.println(earthwormNum);
        }
    }

    public static void bfs(int n, int m) {
        int[] dx = {1, 0 , -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(n,m));
        cabbage[n][m] = false;

        while(!qu.isEmpty()){
            Pair p = qu.poll();

            for(int i=0; i<4; i++){
                int nX = p.x + dx[i];
                int nY = p.y + dy[i];

                if(nX < 0 || nX >= N || nY < 0 || nY >= M){
                    continue;
                }

                if(!cabbage[nX][nY])
                    continue;

                qu.offer(new Pair(nX, nY));
                cabbage[nX][nY] = false;
            }
        }
    }

    public static class Pair{
        int x, y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}