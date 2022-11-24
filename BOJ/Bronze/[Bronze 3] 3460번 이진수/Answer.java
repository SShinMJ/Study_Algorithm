import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        int number;
        String Bin;
        for(int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            number = Integer.parseInt(st.nextToken());
            // 이진수의 값으로의 치환은 toBinaryStirng()함수를 이용하면 문자열로 간단하게 출력할 수 있다.
            Bin = Integer.toBinaryString(number);

            for (int j = Bin.length() - 1; j >= 0; j--) {
                if (Bin.charAt(j) == '1') {
                    System.out.print(Bin.length() - j - 1 + " ");
                }
            }
            System.out.println();
        }
    }
}