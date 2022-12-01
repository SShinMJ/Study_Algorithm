import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int yut; int count;
        for (int i = 0; i < 3; i++) {
            count = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                yut = Integer.parseInt(st.nextToken());
                if(yut == 0)
                    count++;
            }
            switch (count) {
                case 0: System.out.println("E"); break;
                case 1: System.out.println("A"); break;
                case 2: System.out.println("B"); break;
                case 3: System.out.println("C"); break;
                case 4: System.out.println("D"); break;
            }
        }
    }
}