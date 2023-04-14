import java.io.*;
import java.math.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger answer = BigInteger.valueOf(1);

        for(int i = n; i > 0; i--) {
            answer = answer.multiply(BigInteger.valueOf(i));
        }

        System.out.println(answer);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}
