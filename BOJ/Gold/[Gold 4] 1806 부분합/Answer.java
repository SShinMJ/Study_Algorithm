import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        int[] sum = new int[N+1];
        sum[0] = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());

            if (i != 0)
                sum[i+1] = sum[i] + nums[i];
            else
                sum[i+1] = nums[i];
        }

        int start = 0;
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= N;) {
            if(sum[i] - sum[start] >= S) {
                answer = Math.min(answer, i-start);
                start++;
            } else {
                i++;
            }
        }

        if(answer != Integer.MAX_VALUE)
            System.out.println(answer);
        else
            System.out.println(0);
    }
}