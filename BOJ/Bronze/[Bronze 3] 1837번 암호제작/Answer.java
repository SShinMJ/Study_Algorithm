import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static char P[];
    static boolean[] isNotPrime;
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = st.nextToken().toCharArray();
        K = Integer.parseInt(st.nextToken());

        isNotPrime = new boolean[K];
        for (int i = 2; i < K; i++) {
            if(isNotPrime[i] == false){
                primes.add(i);
                for (int j = i*2; j < K; j+=i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int prime : primes) {
            if (prime >= K) {
                break;
            }
            if (checkIsBad(prime)) {
                System.out.println("BAD " + prime);
                return;
            }
        }
        System.out.println("GOOD");

    }

    static boolean checkIsBad(int x){
        int ret = 0;

        for (int i = 0; i < P.length; i++) {
            ret = (ret * 10 + (P[i] - '0')) % x;
        }

        if(ret == 0 ) {
            return true;
        }else
            return false;
    }
}
