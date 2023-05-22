import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long X, Y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        long z = 100 * Y / X;

        if( z >= 99 ) {
            System.out.println(-1);
        } else {
            long start = 0;
            long end = X;

            while (start < end){
                long mid = (start + end) / 2;
                long newRate = 100 * (Y + mid) / (X + mid);
                if(newRate == z){
                    start = mid+1;
                }
                else {
                    end = mid;
                }
            }
            System.out.println(end);
        }
    }
}
