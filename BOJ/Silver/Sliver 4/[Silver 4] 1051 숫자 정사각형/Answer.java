import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] seq = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < M; j++) {
                seq[i][j] = s.charAt(j);
            }
        }

        int max = 1;
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < M-1; j++) {
                for (int l = M-1; l > j; l--) {
                    if(N > i + l - j) {
                        if (seq[i][j] == seq[i][l] &&
                                seq[i][j] == seq[i + l - j][j] &&
                                seq[i][j] == seq[i + l - j][l]) {
                            max = Math.max(max, l - j + 1);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(max*max);
    }
}