import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];
        for (int j = 1; j <= N; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        // 출처 : https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbfP60k%2FbtrxqaQI1k6%2F5g2uftIAy20K1TyyGVxDS1%2Fimg.png
        int[][] cumulativeSum = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                cumulativeSum[i][j] = cumulativeSum[i-1][j] + cumulativeSum[i][j-1] - cumulativeSum[i-1][j-1] + arr[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        int x1, y1, x2, y2;
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            // 출처 : https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FUzDFc%2FbtrxsEjuXbJ%2FvldpUKgr9g0dabfHEsU7uK%2Fimg.png
            sb.append(cumulativeSum[x2][y2] - cumulativeSum[x2][y1-1] - cumulativeSum[x1-1][y2] + cumulativeSum[x1-1][y1-1] + "\n");
        }

        System.out.println(sb);
    }
}