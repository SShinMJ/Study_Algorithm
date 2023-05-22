import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] nums;
    static boolean[] check;
    static boolean isEnd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        nums = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                //i에서 j로 가는 간선이 존재
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 정점 i에서 j로 가는 경로가 있는지 모두 확인
        for(int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++) {
                isEnd = false;  // 초기화
                check = new boolean[N+1];  // 초기화
                dfs(i, j);
                if(isEnd) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    public static void dfs(int start, int end) {
        check[start] = true;  // 체크인

        for(int i = 1 ; i <= N; i++) {  // 연결된 곳을 순회
            if (nums[start][i] == 1) {  // 갈 수 있으며
                // 다음 행선지가 목적지라면
                if (i == end) {
                    // i에서 j로 가는 경로가 있다는 것.
                    isEnd = true;
                    break;
                }
                // 도착지가 아니라면 연결된 곳으로 이동
                else if (!check[i]) {
                    dfs(i, end);  // 재귀
                }
            }
        }
    }
}