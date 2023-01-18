import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        long onlyone;

        while((input = br.readLine()) != null && !input.isEmpty()) {
            int n = Integer.parseInt(input);

            System.out.println(computeAnswer(n));
        }
    }

    // 1로 이루어진 수가 너무 커지면 안된다!
    // 따라서 나머지가 남는 패턴을 파악해본다.
    private static int computeAnswer(int n) {
        int multiplyer = 1;
        int count = 1;

        // 전 케이스의 x % num의 값이
        // 다음 케이스에서 이 값에다가 x 10 +1 한 후
        // num으로 나눈다는 것을 계속 반복하므로
        // 이를 이용하여 계산되는 값을 줄인다.
        while (multiplyer % n != 0) {
            multiplyer = (multiplyer * 10 + 1) % n;
            count++;
        }

        return count;
    }
}

// 참고 : https://velog.io/@qwe916/%EB%B0%B1%EC%A4%80-4375