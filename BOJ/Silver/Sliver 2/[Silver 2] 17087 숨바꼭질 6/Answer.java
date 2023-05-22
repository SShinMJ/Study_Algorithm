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
        int[] brother = new int[N];
        for (int i = 0; i < N; i++) {
            brother[i] = Math.abs(S - Integer.parseInt(st.nextToken()));
        }

        int gcd = brother[0];
        if(N > 1) {
            gcd = gcd(brother[0], brother[1]);
            if (N > 2) {
                for (int i = 2; i < N; i++) {
                    gcd = gcd(gcd, brother[i]);
                }
            }
        }

        System.out.println(gcd);
    }

    //gcd(a,b) == gcd(b,r) == gcd(b,a % b), stop when a % b == 0
    static int gcd(int a, int b){
        while(b!=0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}