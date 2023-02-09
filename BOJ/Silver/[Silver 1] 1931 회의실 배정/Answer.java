import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 그리디 알고리즘
public class Main {
    static int N;
    static int[][] times;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        times = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(times, Comparator.comparingInt(o -> o[1]));

        answer = 0;
        int start = 0;
        for (int i = 0; i < N; i++) {
            if(times[i][1] < start) {
                start = times[i][1];
            } else if (times[i][0] >= start) {
                answer++;
                start = times[i][1];
            }
        }
        System.out.println(answer);
    }
}