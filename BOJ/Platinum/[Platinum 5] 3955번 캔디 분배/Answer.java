import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, A, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            EGResult result = extendedGcd(A, B);
            if (result.r != 1) {
                System.out.println("IMPOSSIBLE");
            } else {
                long x0 = result.s;
                long y0 = result.t;
                
                long kFromY = (long) Math.ceil((double) y0 / (double) A) - 1;
                long kFromX = (long) Math.ceil((double) -x0 / (double) B) - 1;
                long k = Math.min(kFromY, kFromX);
                long kLimitFromY = (long) Math.ceil((y0 - 1e9) / (double) A);
                if (kLimitFromY <= k) {
                    System.out.println(y0 - A * k);
                } else {
                    System.out.println("IMPOSSIBLE");
                }
            }
        }
    }

    static EGResult extendedGcd(long a, long b) {
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;
        while (r1 != 0) {
            long q = r0 / r1;

            temp = r0 - q * r1;
            r0 = r1;
            r1 = temp;

            temp = s0 - q * s1;
            s0 = s1;
            s1 = temp;

            temp = t0 - q * t1;
            t0 = t1;
            t1 = temp;
        }
        return new EGResult(s0, t0, r0);
    }
}

class EGResult {
    long s;
    long t;
    long r;

    public EGResult(long s, long t, long r) {
        super();
        this.s = s;
        this.t = t;
        this.r = r;
    }

    @Override
    public String toString() {
        return "ExtendedGcdResult [s=" + s + ", t=" + t + ", gcd=" + r + "]";
    }

}
