import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int smallNum = Integer.parseInt(st.nextToken());
        int largeNum = Integer.parseInt(st.nextToken());
        if(smallNum > largeNum) {
            int temp = smallNum;
            smallNum = largeNum;
            largeNum = temp;
        }

        int gcd = 0;
        int lcm = 0;
        for (int i = 1; i <= smallNum; i++) {
            if(smallNum % i == 0 && largeNum % i == 0) {
                gcd = i;
                lcm = i * (smallNum / i) * (largeNum / i);
            }
        }

        System.out.println(gcd + "\n" + lcm);
    }
}g