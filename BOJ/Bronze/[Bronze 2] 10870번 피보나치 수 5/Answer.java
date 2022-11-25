import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int prev1 = 1;
        int prev2 = 0;
        int temp;
        for(int i = 2; i < N; i++) {
            temp = prev1;
            prev1 += prev2;
            prev2 = temp;
        }
        if(N>0)
            System.out.println(prev1 + prev2);
        else
            System.out.println(0);
    }
}