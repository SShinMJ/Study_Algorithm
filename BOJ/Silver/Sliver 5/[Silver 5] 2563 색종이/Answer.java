import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static boolean[][] background;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        background = new boolean[100][100];
        int squareX, squareY;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            squareX = Integer.parseInt(st.nextToken());
            squareY = Integer.parseInt(st.nextToken());

            for (int j = squareX; j < squareX + 10; j++) {
                for (int k = squareY; k < squareY + 10; k++) {
                    background[j][k] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < background.length; i++) {
            for (int j = 0; j < background[i].length; j++) {
                if(background[i][j])
                    answer++;
            }
        }

        System.out.println(answer);
    }
}