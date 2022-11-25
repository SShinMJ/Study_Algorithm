import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int headCount = 0;
        int max = 0;
        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            headCount -= Integer.parseInt(st.nextToken());
            headCount += Integer.parseInt(st.nextToken());
            if(headCount > max)
                max = headCount;
        }
        System.out.println(max);
    }
}