import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, K;
    public static int[] durability;
    public static boolean[] robot;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        durability = new int[2 * N];
        robot = new boolean[N];
        for (int i = 0; i < 2*N; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(simulation(0));
    }

    public static int simulation(int cnt) {
        while (isOK()) {
            int temp = durability[durability.length - 1]; // 1. 벨트 한 칸 회전
            for (int i = durability.length - 1; i > 0; i--) {
                durability[i] = durability[i - 1];
            }
            durability[0] = temp;

            for (int i = robot.length - 1; i > 0; i--) {    // 로봇도 벨트와 같이 회전
                robot[i] = robot[i - 1];
            }
            robot[0] = false;

            robot[N - 1] = false;
            for (int i = N - 1; i > 0; i--) {   // 2. 로봇 이동가능하면 이동
                if (robot[i - 1] && !robot[i] && durability[i] >= 1) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    durability[i]--;
                }
            }

            if (durability[0] > 0) {     // 3. 올라가는 위치에 로봇 올리기
                robot[0] = true;
                durability[0]--;
            }

            cnt++;
        }

        return cnt;
    }

    public static boolean isOK() {
        int cnt = 0;

        for (int i = 0; i < durability.length; i++) {
            if (durability[i] == 0) {
                cnt++;
            }
            if (cnt >= K) {
                return false;
            }
        }
        return true;
    }
}