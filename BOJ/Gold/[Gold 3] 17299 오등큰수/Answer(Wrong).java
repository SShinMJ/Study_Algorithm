import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간초과
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        int[] numCount = new int[1000001];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());

            numCount[nums[i]]++;
        }

        StringBuilder sb = new StringBuilder();
        int num = 0;
        String answer = "-1";
        for (int i = 0; i < N; i++) {
            if(i == N-1) {
                sb.append("-1");
            }
            else if(num != nums[i]) {
                for (int j = i+1; j < N; j++) {
                    if(numCount[nums[j]] > numCount[nums[i]]) {
                        answer = String.valueOf(nums[j]);
                        sb.append(answer + " ");
                        break;
                    }
                    if(j == N-1) {
                        answer = "-1";
                        sb.append(answer + " ");
                    }
                }
            } else {
                sb.append(answer + " ");
            }
        }

        System.out.println(sb);
    }
}