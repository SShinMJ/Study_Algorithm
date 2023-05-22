import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String num = "";
        int answer = 0;
        boolean minus = false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '+') {
                if(minus)
                    answer -= Integer.parseInt(num);
                else
                    answer += Integer.parseInt(num);
                num = "";
            }
            else if(s.charAt(i) == '-') {
                if(minus) {
                    answer -= Integer.parseInt(num);
                }
                else {
                    minus = true;
                    answer += Integer.parseInt(num);
                }
                num = "";
            }
            else {
                num += s.charAt(i);
                if(i == s.length()-1) {
                    if(minus)
                        answer -= Integer.parseInt(num);
                    else
                        answer += Integer.parseInt(num);
                }
            }
        }

        System.out.println(answer);
    }
}