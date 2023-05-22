import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int num, count = 0;
        boolean isDecimal;
        for (int i = 0; i < N; i++) {
            isDecimal = true;
            num = Integer.parseInt(st.nextToken());
            if(num != 1){
                for (int j = 2; j < num; j++) {
                    if(num % j == 0) {
                        isDecimal = false;
                        break;
                    }
                }
                if(isDecimal)
                    count++;
            }
        }
        System.out.println(count);
    }
}