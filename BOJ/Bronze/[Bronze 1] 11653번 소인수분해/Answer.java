import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num =  Integer.parseInt(br.readLine());

        boolean[] isNotPrime = new boolean[num+1];
        for (int i = 2; i <= num; i++) {
            if(isNotPrime[i] == false){
                for (int j = i*2; j < num; j+=i) {
                    isNotPrime[j] = true;
                }

                while (num % i == 0) {
                    System.out.println(i);
                    num /= i;
                }
            }

            if(num == 1)
                break;
            else if(num < i && !isNotPrime[num]) {
                System.out.println(num);
                break;
            }
        }
    }
}