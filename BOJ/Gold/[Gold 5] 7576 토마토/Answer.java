import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// BFS
public class Main {
    static int N, M;
    static int[][] tomato;
    static Queue<Point> q = new LinkedList<>();
    static int[] directionX = {1, 0, -1, 0};
    static int[] directionY = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomato = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j] == 1)
                    q.add(new Point(i, j));
            }
        }

        int count = 0;
        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                count = Math.max(count, tomato[i][j]);
            }
        }
        System.out.println(count-1);
    }

    public static void bfs() {
        int x, y;

        while(!q.isEmpty()) {
            Point p = q.poll();
            x = (int) p.getX();
            y = (int) p.getY();

            for (int i = 0; i < 4; i++) {
                int nowX = x + directionX[i];
                int nowY = y + directionY[i];

                if(nowX < 0 || nowY < 0 || nowX >= N || nowY >= M)
                    continue;

                if(tomato[nowX][nowY] == 0 || tomato[nowX][nowY] > tomato[x][y]+1) {
                    tomato[nowX][nowY] = tomato[x][y] + 1;
                    q.add(new Point(nowX, nowY));
                }
            }
        }
    }
}