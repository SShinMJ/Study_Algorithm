import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] heightList;
    static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        heightList = new int[N][N];
        int maxHeight = 0, minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                heightList[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, heightList[i][j]);
                minHeight = Math.min(minHeight, heightList[i][j]);
            }
        }

        int maxSafeArea = 1;
        int safeAreaNum;
        for (int i = minHeight; i < maxHeight; i++) {
            checked = new boolean[N][N];
            safeAreaNum = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(heightList[j][k] > i && !checked[j][k]) {
                        bfs(j, k, i);
                        safeAreaNum++;
                    }
                }
            }
            if(maxSafeArea < safeAreaNum)
                maxSafeArea = safeAreaNum;
        }

        System.out.println(maxSafeArea);
    }

    public static void bfs(int x, int y, int height) {
        int[] dx = {1, 0 , -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(x,y));
        checked[x][y] = true;

        while(!qu.isEmpty()){
            Pair p = qu.poll();

            for(int i=0; i<4; i++){
                int nX = p.x + dx[i];
                int nY = p.y + dy[i];

                if(nX < 0 || nX >= N || nY < 0 || nY >= N){
                    continue;
                }

                if(heightList[nX][nY] <= height || checked[nX][nY]) {
                    continue;
                }

                qu.offer(new Pair(nX, nY));
                checked[nX][nY] = true;
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