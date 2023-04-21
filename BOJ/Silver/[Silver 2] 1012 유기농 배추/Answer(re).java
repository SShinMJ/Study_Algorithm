import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] cabbage;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int K, answer;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cabbage = new boolean[N][M];
            int x, y;
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                y = Integer.parseInt(st.nextToken());
                x = Integer.parseInt(st.nextToken());
                cabbage[x][y] = true;
            }

            answer = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(cabbage[j][k] == true) {
                        answer++;
                        bfs(j, k);
                    }
                }
            }
            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int nowX, nowY;
        for (int i = 0; i < 4; i++) {
            nowX = x + dx[i];
            nowY = y + dy[i];

            if(nowX < 0 || nowY < 0 || nowX >= N || nowY >= M)
                continue;

            if(cabbage[nowX][nowY] == true) {
                cabbage[nowX][nowY] = false;
                bfs(nowX, nowY);
            }
        }
    }
}