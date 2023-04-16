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
        if(w.length() == 1)
            return "no answer";

        char[] chars = new char[w.length()];
        for (int i = 0; i < w.length(); i++) {
            chars[i] = w.charAt(i);
        }
        char temp;
        int tempIdx;
        String answer = "";
        // 1. 가장 끝자리보다 작은 문자가 있는 지 확인
        for (int i = chars.length-2; i >= 0; i--) {
            // 2-1. 있다면 그 문자와 끝자리를 스위칭
            if(chars[i] < chars[chars.length-1]) {
                temp = chars[i];
                chars[i] = chars[chars.length-1];
                chars[chars.length-1] = temp;
                char[] sortChars = new char[chars.length-i-1];
                for (int j = i+1; j < chars.length; j++) {
                    sortChars[j-i-1] = chars[j];
                }
                Arrays.sort(sortChars);
                for (int j = 0; j < i+1; j++) {
                    answer += chars[j];
                }
                for(char c : sortChars)
                    answer += c;
                return answer;
            }
        }

        // 2-2-1. 없다면
        // 가장 첫자리 문자보다 가장 큰 문자중 가장 작은 자리 찾기
        tempIdx = 0;
        for (int j = 1; j < chars.length; j++) {
            if(chars[0] < chars[j]) {
                if(tempIdx == 0 || chars[tempIdx] > chars[j])
                    tempIdx = j;
            }
        }

        // 있다면 스위칭 후 뒤에는 오름차순 정렬
        if(tempIdx != 0) {
            temp = chars[tempIdx];
            chars[tempIdx] = 'A';
            Arrays.sort(chars);
            chars[0] = temp;

            for (int j = 0; j < chars.length; j++) {
                answer += chars[j];
            }
        }
        // 첫자리 문자보다 큰 문자가 없다면 no answer
        else
            answer = "no answer";

        return answer;
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
