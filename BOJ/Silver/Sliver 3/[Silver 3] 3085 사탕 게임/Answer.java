import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static char[][] board;	// 맵 크기
    public static int N;			// 맵 크기
    public static int max = 0;		// 먹을 수 있는 최대 사탕개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        /* 가로로 인접한 두 사탕 교환하고 최대 사탕 개수 찾고 원위치 */
        for(int i=0; i<N; i++) {
            for(int j=0; j<N-1; j++) {
                // 가로로 인접한 두 문자 교환
                swap(i, j, i, j+1);

                // →, ↓ 체크
                arrCheck();

                // 이전에 교환한 문자 복구
                swap(i, j, i, j+1);
            }
        }

        /* 세로로 인접한 두 사탕 교환하고 최대 사탕 개수 찾고 원위치 */
        for(int i=0; i<N; i++) {
            for(int j=0; j<N-1; j++) {
                // 세로로 인접한 두 문자 교환
                swap(j, i, j+1, i);

                // →, ↓ 체크
                arrCheck();

                // 이전에 교환한 문자 복구
                swap(j, i, j+1, i);
            }
        }

        System.out.println(max);
    }

    /* 두 문자 교환하는 메소드 */
    public static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    /* 가로로, 세로로 비교하면서 먹을 수 있는 사탕의 최대 갯수 찾기 */
    public static void arrCheck() {

        // → 가로로 체크
        for(int i=0; i<N; i++) {
            int count = 1;
            for(int j=0; j<N-1; j++) {

                // 이전 사탕과 동일한 경우 -> 계속 먹는다
                if(board[i][j] == board[i][j+1])
                    count ++;

                    // 이전과 다른 사탕인 경우 -> 새로 먹어야하므로 1로 초기화
                else
                    count = 1;

                // 사탕 최대 개수 저장
                max = Math.max(max, count);
            }
        }

        // ↓ 세로로 체크
        for(int i=0; i<N; i++) {
            int count = 1;
            for(int j=0; j<N-1; j++) {
                if(board[j][i] == board[j+1][i])
                    count ++;
                else
                    count = 1;
                max = Math.max(max, count);
            }
        }
    }
}