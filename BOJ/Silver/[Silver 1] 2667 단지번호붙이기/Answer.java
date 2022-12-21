import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] isApart;
    static boolean[][] check;
    static int apartComplexNum;
    static List<Integer> buildingNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        isApart = new int[N+1][N+1];
        check = new boolean[N+1][N+1];
        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < N; j++) {
                isApart[i][j] = s.charAt(j) - '0';
            }
        }

        apartComplexNum = 0;
        buildingNum = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(isApart[i][j] == 1 && !check[i][j]) {
                    apartComplexNum++;
                    buildingNum.add(dfs(i, j, 1));
                }
            }
        }

        System.out.println(apartComplexNum);
        buildingNum.sort(null);
        for (int i = 0; i < buildingNum.size(); i++) {
            System.out.println(buildingNum.get(i));
        }
    }

    static int dfs(int row, int col, int count) {
        check[row][col] = true;

        if(col+1 < N && isApart[row][col+1] == 1 && !check[row][col+1]) {
            count = dfs(row, col+1, count+1);
        }
        if(col > 0 && isApart[row][col-1] == 1 && !check[row][col-1]) {
            count = dfs(row, col-1, count+1);
        }
        if(row+1 < N && isApart[row+1][col] == 1 && !check[row+1][col]) {
            count = dfs(row+1, col, count+1);
        }
        if(row > 0 && isApart[row-1][col] == 1 && !check[row-1][col]) {
            count = dfs(row-1, col, count+1);
        }

        return count;
    }
}