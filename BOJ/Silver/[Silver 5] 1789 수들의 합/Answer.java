import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long S;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Long.parseLong(st.nextToken());

        long answer = 0;
        long sum = 0;

        for (int i = 1; i <= S; i++) {
            sum += i;
            if(sum <= S) {
                answer++;
                if(S - sum < i+1)
                    break;
            }
        }

        System.out.println(answer);
    }
}