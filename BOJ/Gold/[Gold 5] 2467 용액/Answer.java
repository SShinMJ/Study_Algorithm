import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] solution;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        solution = new int[N];
        for(int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        int min = 0, max = 0, now = 0;
        int charValue = Integer.MAX_VALUE;
        String answer = "";
        int i = 0, j = N-1;
        while (i < j) {
            min = Math.min(solution[i], solution[j]);
            max = Math.max(solution[i], solution[j]);
            now = Math.abs(min+max);

            if(now < charValue) {
                charValue = now;
                answer = min + " " + max;
            }
            if(i+1 < j) {
                if(now < Math.abs(solution[i+1]+solution[j]))
                    j--;
                else
                    i++;
            } else
                break;
        }

        System.out.println(answer);
    }
}