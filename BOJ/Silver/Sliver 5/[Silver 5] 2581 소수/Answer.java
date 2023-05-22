import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        if(M == 1)
            M += 1;

        int sum = 0, minDecimal = 0;
        boolean isDecimal;
        for (int i = M; i <= N; i++) {
            isDecimal = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    isDecimal = false;
                    break;
                }
            }
            if(isDecimal){
                if(minDecimal == 0)
                    minDecimal = i;
                sum += i;
            }
        }
        if(sum == 0)
            System.out.println("-1");
        else
            System.out.println(sum + "\n" + minDecimal);
    }
}