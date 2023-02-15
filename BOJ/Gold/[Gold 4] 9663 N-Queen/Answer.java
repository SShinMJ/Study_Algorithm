import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Math.abs;

// DFS 백트래킹
public class Main {
    static int N;
    static int[] chessBoard;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        chessBoard = new int[N];

        backtracking(0);

        System.out.println(answer);
    }

    public static void backtracking(int idx) {
        // cdx가 마지막 행까지 수행하고 여기까지 오면, 찾기 완료
        if (idx == N) {
            answer++;
            return;
        }
        // 마지막 행에 도달하고 돌아와도 아직 다른 경우의 수가 있다면 모두 찾게끔 돌아간다.

        for (int i = 0; i < N; i++) {
            chessBoard[idx] = i; // cdx번째 행, i번째 열에 queen을 놓아본다.
            // 이후 그 행에 둔 것에 대한 유망성을 판단한다.
            if (invulnerable(idx)) { // 그 자리에 두어도 괜찮았다면,
                backtracking(idx + 1); // 그 다음 행에 대해 퀸을 놓는 것을 해 본다.
            }
        }
    }

    static boolean invulnerable(int idx) {
        // 퀸을 놓기 위한 조건을 확인한다.
        // 1. N-Queen 규칙에는 퀸이 서로 다른 열에 놓이게 된다.
        // 2. i는 현재 놓이는 열을 받게 된다.
        // 조건 - 같은 열이면 안되고, 대각선상에 있어서도 안 된다.
        // 대각선상에 위치한지 알아보는 방법 =
        // 놓을 퀸의 행 번호와, 그 위에 놓여 있는 다른 퀸들의 행 번호 차이가
        // 놓을 퀸의 열 번호와, 다른 퀸의 열 번호의 차이와 같다면 대각선상에 위치한 것.
        for (int i = 0; i < idx; i++) {
            if (chessBoard[idx] == chessBoard[i] || idx - i == abs(chessBoard[idx] - chessBoard[i])) {
                return false;
            }
        }
        return true;
    }
}