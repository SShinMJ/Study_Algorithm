import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DFS 백트래킹
public class Main {
    static int[][] sudokuBoard = new int[9][9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudokuBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
    }

    public static void sudoku(int row, int col) {
        // 해당 행이 다 채워졌을 경우 다음 행의 첫 번째 열부터 시작
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        // 행과 열이 모두 채워졌을 경우 출력 후 종료
        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudokuBoard[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            // 출력 뒤 시스템을 종료한다.
            System.exit(0);
        }

        // 만약 해당 위치의 값이 0 이라면 1부터 9까지 중 가능한 수 탐색
        if(sudokuBoard[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                // i 값이 중복되지 않는지 검사
                if (possibility(row, col, i)) {
                    // 중복되지 않았다면 i를 저장.
                    sudokuBoard[row][col] = i;
                    // 다음 칸으로 넘어감.
                    sudoku(row, col + 1);
                }
            }
            // 전부 채워 넣지 못했다면 해당 값은 틀린 것이므로 다른 숫자를 집어넣어 보도록 한다.
            sudokuBoard[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);
    }

    public static boolean possibility(int row, int col, int value) {
        // 같은 열에 있는 원소들 중 겹치는 행 원소가 있는지 검사
        for (int i = 0; i < 9; i++) {
            if(sudokuBoard[i][col] == value)
                return false;
        }

        // 같은 행에 있는 원소들 중 겹치는 열 원소가 있는지 검사
        for (int i = 0; i < 9; i++) {
            if(sudokuBoard[row][i] == value)
                return false;
        }

        // 3*3 칸에 중복되는 원소가 있는지 검사
        int set_row = (row / 3) * 3; // value가 속한 3x3의 행의 첫 위치
        int set_col = (col / 3) * 3; // value가 속한 3x3의 열의 첫 위치
        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if(sudokuBoard[i][j] == value)
                    return false;
            }
        }

        // 조건을 모두 통과 했다면
        return true;
    }
}