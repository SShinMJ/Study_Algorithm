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
        int end, endIdx;
        for (int i = 0; i < W-1;) {
            if(blocks[i] == 0)
                continue;
            end = 0; endIdx = 0;
            for (int j = i+1; j < W; j++) {
                if(blocks[i] <= blocks[j]) {
                    answer += (j-i-1) * blocks[i] - blockSum(i, j);
                    i = j;
                    break;
                }
                else if(j == W-1) {
                    if(end != 0) {
                        answer += (endIdx-i-1) * end - blockSum(i, endIdx);
                        i = endIdx;
                    } else {
                        if(blocks[j] > blocks[j-1]) {
                            answer += (j-i-1) * blocks[j] - blockSum(i, j);
                        }
                        System.out.println(answer);
                        return;
                    }
                }
                else if(blocks[j] > blocks[j+1] && end < blocks[j]) {
                    end = blocks[j];
                    endIdx = j;
                }
            }
        }

        System.out.println(answer);
    }

    public static int blockSum(int start, int end) {
        int sum = 0;
        for (int i = start+1; i < end; i++) {
            sum += blocks[i];
        }
        return sum;
    }
}