import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isNotprimeFactor = new boolean[1000001];
        for (int i = 2; i <= 1000000; i++) {
            if (!isNotprimeFactor[i]) {
                for (int j = i*2; j <= 1000000; j += i) {
                    if (!isNotprimeFactor[j]) {
                        isNotprimeFactor[j] = true;
                    }
                }
            }
        }

        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0)
                return;

            for (int i = 2; i < N; i++) {
                if(!isNotprimeFactor[i] && !isNotprimeFactor[N-i]) {
                    System.out.println(N + " = " + i + " + " + (N-i));
                    break;
                }
            }
        }
    }
}