import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long gcd = gcd(Math.max(A, B), Math.min(A, B));

        // 실제 수를 구할 필요 없이,
        // 두 수의 자릿수(입력받은 값)의 최대 공약수만큼 1을 반복하면 되는 문제.
        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= gcd; i++) sb.append("1");

        System.out.println(sb);
    }

    //gcd(a,b) == gcd(b,r) == gcd(b,a % b), stop when a % b == 0
    static long gcd(long a, long b){
        while(b!=0){
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}

// 참고 : https://pangsblog.tistory.com/61