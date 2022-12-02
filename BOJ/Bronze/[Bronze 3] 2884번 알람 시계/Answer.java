import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(M < 45){
            if(H < 1)
                System.out.println(23 + " " + (M + 15));
            else
                System.out.println((H - 1) + " " + (M + 15));
        }
        else
            System.out.println(H + " " + (M - 45));
    }
}