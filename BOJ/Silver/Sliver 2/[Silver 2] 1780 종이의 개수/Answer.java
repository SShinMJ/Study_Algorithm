import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] paper;
    static int minusOne = 0, zero = 0, one = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(!checkSame(0, 0, N)) {
            divisionPaper(0, 0, N);
        } else {
            if(paper[0][0] == -1) {
                minusOne++;
            }
            else if(paper[0][0] == 0)
                zero++;
            else
                one++;
        }


        System.out.println(minusOne + "\n" + zero + "\n" + one);
    }

    public static void divisionPaper(int x, int y, int N) {
        int i = x, j = y;
        while (i < x+N) {
            while (j < y+N) {
                if(checkSame(i, j, N/3)) {
                    if(paper[i][j] == -1)
                        minusOne++;
                    else if(paper[i][j] == 0)
                        zero++;
                    else
                        one++;
                } else {
                    divisionPaper(i, j, N/3);
                }
                j += N/3;
            }
            j = y;
            i += N/3;
        }
    }

    public static boolean checkSame(int x, int y, int length) {
        int standard = paper[x][y];
        for (int i = x; i < x+length; i++) {
            for (int j = y; j < y+length; j++) {
                if(paper[i][j] != standard) {
                    return false;
                }
            }
        }

        return true;
    }
}