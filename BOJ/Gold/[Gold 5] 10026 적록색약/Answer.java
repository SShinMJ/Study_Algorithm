import java.io.*;

public class Main {
    static int N;
    static char[][] colors;
    static boolean[][] publicVisted;
    static boolean[][] colorWeaknessVisted;
    static int[] directionX = {1, 0, -1, 0};
    static int[] directionY = {0, 1, 0, -1};
    static int colorWeaknessNum;
    static int publicNum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String s;
        colors = new char[N][N];
        for(int i = 0; i < N; i++){
            s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                colors[i][j] = s.charAt(j);
            }
        }

        publicVisted = new boolean[N][N];
        colorWeaknessVisted = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!publicVisted[i][j]) {
                    publicNum++;
                    publicDfs(i, j);
                }
                if(!colorWeaknessVisted[i][j]) {
                    colorWeaknessNum++;
                    colorWeaknessDfs(i, j);
                }
            }
        }

        System.out.println(publicNum + " " + colorWeaknessNum);
    }

    static void publicDfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nowX = x + directionX[i];
            int nowY = y + directionY[i];

            if(nowX < 0 || nowY < 0 || nowX >= N || nowY >= N)
                continue;

            if(!publicVisted[nowX][nowY]) {
                if(colors[nowX][nowY] == colors[x][y]) {
                    publicVisted[nowX][nowY] = true;
                    publicDfs(nowX, nowY);
                }
            }
        }
    }

    static void colorWeaknessDfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nowX = x + directionX[i];
            int nowY = y + directionY[i];

            if(nowX < 0 || nowY < 0 || nowX >= N || nowY >= N)
                continue;

            if(!colorWeaknessVisted[nowX][nowY]) {
                if(colors[nowX][nowY] == colors[x][y] ||
                        ((colors[x][y] == 'R' || colors[x][y] == 'G') &&
                                (colors[nowX][nowY] == 'R' || colors[nowX][nowY] == 'G'))){
                    colorWeaknessVisted[nowX][nowY] = true;
                    colorWeaknessDfs(nowX, nowY);
                }
            }
        }
    }
}
