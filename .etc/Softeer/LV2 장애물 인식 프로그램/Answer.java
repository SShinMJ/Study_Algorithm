import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int[][] map;
    static boolean[][] checked;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int notRoads;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String s;
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            s = br.readLine();
            for(int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int blockCount = 0;
        List<Integer> notRoadCounts = new ArrayList<>();
        checked = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!checked[i][j] && map[i][j] == 1) {
                    notRoads = 1;
                    checked[i][j] = true;
                    dfs(i, j);
                    blockCount++;
                    notRoadCounts.add(notRoads);
                }
            }
        }

        Collections.sort(notRoadCounts);

        StringBuilder sb = new StringBuilder();
        sb.append(blockCount + "\n");
        for(int i = 0; i < notRoadCounts.size(); i++) {
            sb.append(notRoadCounts.get(i) + "\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        int nowX, nowY;
        for(int i = 0; i < 4; i++) {
            nowX = x + dx[i];
            nowY = y + dy[i];

            if(nowX < 0 || nowY < 0 || nowX >= N || nowY >= N)
                continue;

            if(!checked[nowX][nowY] && map[nowX][nowY] == 1) {
                checked[nowX][nowY] = true;
                notRoads++;
                dfs(nowX, nowY);
            }
        }
    }
}