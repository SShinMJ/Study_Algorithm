import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[] king = new char[2], stone = new char[2];
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        king[0] = s.charAt(0);
        king[1] = s.charAt(1);
        s = st.nextToken();
        stone[0] = s.charAt(0);
        stone[1] = s.charAt(1);
        N = Integer.parseInt(st.nextToken());

        while(N-- > 0) {
            move(new StringTokenizer(br.readLine()).nextToken());
        }
        System.out.println(String.valueOf(king) + "\n" + String.valueOf(stone));
    }

    static void move(String s) {
        if(s.equals("R")) {
            if(king[0] != 'H') {
                king[0]++;
                if (isEquals()){
                    if(stone[0] != 'H'){
                        stone[0]++;
                    } else {
                        king[0]--;
                    }
                }
            }
        } else if (s.equals("L")) {
            if(king[0] != 'A') {
                king[0]--;
                if (isEquals()){
                    if(stone[0] != 'A'){
                        stone[0]--;
                    } else king[0]++;
                }
            }
        } else if (s.equals("B")) {
            if(king[1] != '1') {
                king[1]--;
                if (isEquals()){
                    if(stone[1] != '1'){
                        stone[1]--;
                    } else king[1]++;
                }
            }
        } else if (s.equals("T")) {
            if(king[1] != '8') {
                king[1]++;
                if (isEquals()){
                    if(stone[1] != '8'){
                        stone[1]++;
                    } else king[1]--;
                }
            }
        } else if (s.equals("RT")) {
            if(king[0] != 'H' && king[1] != '8') {
                king[0]++;
                king[1]++;
                if (isEquals()) {
                    if(stone[0] != 'H' && stone[1] != '8') {
                        stone[0]++;
                        stone[1]++;
                    } else {
                        king[0]--;
                        king[1]--;
                    }
                }
            }
        } else if (s.equals("LT")) {
            if(king[0] != 'A' && king[1] != '8') {
                king[0]--;
                king[1]++;
                if (isEquals()) {
                    if (stone[0] != 'A' && stone[1] != '8') {
                        stone[0]--;
                        stone[1]++;
                    } else {
                        king[0]++;
                        king[1]--;
                    }
                }
            }
        } else if (s.equals("RB")) {
            if(king[0] != 'H' && king[1] != '1') {
                king[0]++;
                king[1]--;
                if (isEquals()) {
                    if (stone[0] != 'H' && stone[1] != '1') {
                        stone[0]++;
                        stone[1]--;
                    } else {
                        king[0]--;
                        king[1]++;
                    }
                }
            }
        } else {
            if(king[0] != 'A' && king[1] != '1') {
                king[0]--;
                king[1]--;
                if (isEquals()) {
                    if (stone[0] != 'A' && stone[1] != '1') {
                        stone[0]--;
                        stone[1]--;
                    } else {
                        king[0]++;
                        king[1]++;
                    }
                }
            }
        }
    }

    static boolean isEquals() {
        if(king[0] == stone[0] && king[1] == stone[1])
            return true;
        else
            return false;
    }
}