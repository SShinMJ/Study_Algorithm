import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시뮬레이션(구현)
public class Main {
    static int H, W;
    static int[] blocks;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        blocks = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 1; i < W - 1; i++) {
            int current = blocks[i]; //현재 벽 높이
            int leftMax = current; //왼쪽 벽 최대높이
            int rightMax = current; //오른쪽 벽 최대높이
            for (int k = i - 1; k >= 0; k--) { //왼쪽 최대벽 높이 탐색
                if (blocks[k] > current) {
                    leftMax = Math.max(leftMax, blocks[k]);
                }
            }
            for (int k = i + 1; k < W; k++) { //오른쪽 최대벽 높이 탐색
                if (blocks[k] > current) {
                    rightMax = Math.max(rightMax, blocks[k]);
                }
            }
            if (Math.min(leftMax, rightMax) > current) { // 현재 벽보다 높은 벽이 양쪽에 있는 경우
                answer += (Math.min(leftMax, rightMax) - blocks[i]);
            }
        }
        System.out.println(answer);
    }
}