import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, targetA, targetB, M;
    static int[][] kinship;
    static boolean[] check;
    static int degreeKinship;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        StringTokenizer st = new StringTokenizer(br.readLine());
        targetA = Integer.parseInt(st.nextToken());
        targetB = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        kinship = new int[N+1][N+1];
        check = new boolean[N+1];
        int x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            kinship[x][y] = 1;
            kinship[y][x] = 1;
        }

        degreeKinship = 0;
        if(dfs(targetA))
            System.out.println(degreeKinship);
        else
            System.out.println(-1);
    }

    static boolean dfs(int start) {
        check[start] = true;  // 체크인

        // 목적지인가? = targetB와 연결되어 있는가?
        if(start == targetB) {
            return true;
        }

        // 연결된 곳을 순회
        for (int i = 1; i < N+1; i++) {
            // 갈 수 있는가?
            if(kinship[start][i] == 1 && !check[i]) {
                degreeKinship++;
                if(dfs(i))
                    return true;
                check[i] = false; // 체크아웃
            }

        }

        // 목적지가 없는 연결이므로 초기화
        degreeKinship--;
        return false;
    }
}