import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();
        int lastIdx = chars.length - 1;
        int minVal = Integer.MAX_VALUE;
        int minIdx = Integer.MAX_VALUE;
        int turningPoint = 0;
        String result = w;
        // 일단 맨 끝 알파벳에서 for 문 돌려서 줄어드는 구간을 찾는다.
        for (int i = lastIdx; i > 0; i--) {
            if (chars[i] > chars[i - 1]) {
                turningPoint = i - 1;
                // 큰 수 중에 가장 작은 수를 찾는다.
                for (int k = i; k <= lastIdx; k++) {
                    if (chars[turningPoint] < chars[k] && minVal > chars[k]) {
                        minVal = chars[k];
                        minIdx = k;
                    }
                }
                // 두 수를 스위칭
                swap(chars, turningPoint, minIdx);
                // 바꾼 위치부터 정렬(큰 수 중 가장 작은 수를 만들기 위함)
                Arrays.sort(chars, turningPoint + 1, lastIdx + 1);
                result = new String(chars);
                break;
            }

        }

        return w.equals(result) ? "no answer" : result;
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
