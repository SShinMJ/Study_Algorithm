import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// BFS
public class Main {
    static int N, L, R;
    static int[][] population;
    static boolean[][] visited;
    static int[] directionX = {1, 0, -1, 0};
    static int[] directionY = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        population = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean go;
        int count = -1;
        do {
            go = false;
            count++;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j])
                        if (bfs(i, j))
                            go = true;
                }
            }
        } while (go);

        System.out.println(count);
    }

    public static boolean bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int nowX, nowY;
        int count = 1;
        int sum = population[x][y];
        List<int[]> union = new ArrayList<>();
        union.add(new int[]{x, y});
        boolean movement = false;

        while(!q.isEmpty()) {
            int[] move = q.poll();
            x = move[0];
            y = move[1];

            for (int i = 0; i < 4; i++) {
                nowX = x + directionX[i];
                nowY = y + directionY[i];

                if(nowX < 0 || nowY < 0 || nowX >= N || nowY >= N)
                    continue;

                if(visited[nowX][nowY])
                    continue;

                int differ = Math.abs(population[nowX][nowY]-population[x][y]);

                if(differ >= L && differ <= R) {
                    count++; sum += population[nowX][nowY];
                    visited[nowX][nowY] = true;
                    union.add(new int[]{nowX, nowY});
                    q.add(new int[]{nowX, nowY});
                    movement = true;
                }

            }
        }

        if(movement) {
            for (int i = 0; i < union.size(); i++) {
                int[] move = union.get(i);
                population[move[0]][move[1]] = sum / count;
            }
        }

        return movement;
    }
}