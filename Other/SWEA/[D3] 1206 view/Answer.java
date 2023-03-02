import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int N;
        int[] buildings;
        int answer;
        int maxHeight;
        for (int i = 1; i <= 10; i++) {
            N = Integer.parseInt(br.readLine());
            buildings = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                buildings[j] = Integer.parseInt(st.nextToken());
            }

            answer = 0;
            maxHeight = 0;
            // 모든 건물을 거친다.
            for (int n = 2; n < N-2; n++) {
                // n번째 건물의 높이가 n-2, n-1, n+1, n+2번재 건물의 높이의 최대값보다 크다면
                maxHeight = Math.max(Math.max(buildings[n-2], buildings[n-1]), Math.max(buildings[n+1], buildings[n+2]));
                if(buildings[n] > maxHeight) {
                    // answer += buildings[n] - buildings[최대높이인 건물]
                    answer += buildings[n] - maxHeight;
                }
            }

            sb.append("#" + i + " " + answer + "\n");
        }

        System.out.println(sb);
    }
}