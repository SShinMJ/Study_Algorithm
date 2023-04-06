import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// N의 크기가 매우 크므로 시간초과가 나온다.
public class Main {
    static int N;
    static int[][] nums;
    static boolean[][] checked;
    static int rupee = 0;
    static int answer;
    static int[] directionX = {1, 0, -1, 0};
    static int[] directionY = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = 0;

        StringBuilder sb = new StringBuilder();
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0)
                break;

            count++;
            answer = Integer.MAX_VALUE;

            nums = new int[N][N];
            checked = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    nums[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            rupee = nums[0][0];
            checked[0][0] = true;
            dfs(0, 0);

            sb.append("Problem " + count + ": " + answer + "\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        if(x == N-1 && y == N-1) {
            answer = Math.min(answer, rupee);
            return;
        }

        if(rupee > answer)
            return;

        int nowX, nowY;
        for (int i = 0; i < 4; i++) {
            nowX = x + directionX[i];
            nowY = y + directionY[i];

            if(nowX < 0 || nowY < 0 || nowX > N-1 || nowY > N-1)
                continue;

            if(!checked[nowX][nowY]) {
                checked[nowX][nowY] = true;
                rupee += nums[nowX][nowY];
                dfs(nowX, nowY);
                checked[nowX][nowY] = false;
                rupee -= nums[nowX][nowY];
            }
        }
    }
}