import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coinValue = new int[N];
        int maxDivide = N-1;
        for (int i = 0; i < N; i++) {
            coinValue[i] = Integer.parseInt(br.readLine());
            if(K / coinValue[i] == 0) {
                maxDivide = i - 1;
                break;
            }
        }

        int answer = 0;
        for (int i = maxDivide; i >= 0; i--) {
            answer += K / coinValue[i];
            K %= coinValue[i];
        }

        System.out.println(answer);
    }
}