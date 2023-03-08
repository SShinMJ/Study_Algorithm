import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int N;
        int[] zeroDp, oneDp;
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) {
                sb.append(1 + " " + 0 + "\n");
            } else if (N == 1) {
                sb.append(0 + " " + 1 + "\n");
            } else {
                zeroDp = new int[N+1];
                zeroDp[0] = 1;
                zeroDp[1] = 0;
                oneDp = new int[N+1];
                oneDp[0] = 0;
                oneDp[1] = 1;

                for (int n = 2; n <= N; n++) {
                    zeroDp[n] = zeroDp[n - 1] + zeroDp[n - 2];
                    oneDp[n] = oneDp[n - 1] + oneDp[n - 2];
                }

                sb.append(zeroDp[N] + " " + oneDp[N] + "\n");
            }
        }

        System.out.println(sb);
    }
}
