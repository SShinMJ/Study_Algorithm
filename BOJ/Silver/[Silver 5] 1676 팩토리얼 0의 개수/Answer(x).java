import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N < 5) {
            System.out.println(0);
            return;
        }

        int factorial = 1;
        for (int i = 2; i <= N; i++) {
            System.out.println(factorial + " * " + i);
            factorial *= i;
            while (factorial >= 10) {
                System.out.print(factorial + " ");
                if(factorial % 10 == 0)
                    factorial /= 10;
                else
                    factorial %= 10;
            }
            if(i % 25 == 0)
                factorial--;

            System.out.println();
        }

        System.out.println(factorial);
    }
}