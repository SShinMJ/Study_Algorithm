import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] alphabet;
    static boolean[] visted = new boolean[26];
    static int[] directionX = {1, 0, -1, 0};
    static int[] directionY = {0, 1, 0, -1};
    static int maxRoute;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        String s;
        alphabet = new char[R][C];
        for(int i = 0; i < R; i++){
            s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                alphabet[i][j] = s.charAt(j);
            }
        }

        int idx = alphabet[0][0] - 'A';
        visted[idx] = true;
        maxRoute = 1;
        answer = 0;
        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int x, int y) {
        int idx;

        for (int i = 0; i < 4; i++) {
            int nowX = x + directionX[i];
            int nowY = y + directionY[i];

            if(nowX < 0 || nowY < 0 || nowX >= R || nowY >= C)
                continue;

            idx = alphabet[nowX][nowY] - 'A';
            if(!visted[idx]) {
                visted[idx] = true;
                maxRoute++;
                dfs(nowX,nowY);
            }
        }
        answer = Math.max(answer, maxRoute);
        maxRoute--;
        idx = alphabet[x][y] - 'A';
        visted[idx] = false;
    }
}