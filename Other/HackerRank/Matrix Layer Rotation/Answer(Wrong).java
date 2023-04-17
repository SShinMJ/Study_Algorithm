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
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        // Write your code here
        int[][] oriMatrix1 = matrix.toArray(new int[matrix.size()][matrix.get(0).size()]);
        int[][] rotMatrix2 = new int[matrix.size()][matrix.get(0).size()];

        int count = -1;
        while (count++ < r) {
            // 윗변
            for (int i = 0; i < matrix.size()/2; i++) {
                rotMatrix2[i+1][i] = oriMatrix1[i][i];
            }
            for (int i = 0; i < matrix.size()/2; i++) {
                for (int j = i; j < matrix.get(0).size()-i; j++) {
                    rotMatrix2[i][j] = oriMatrix1[i][j + 1];
                }
                rotMatrix2[i][matrix.get(0).size()-i-1] = oriMatrix1[i+1][matrix.size()-i-1];
            }
            // 왼쪽
            for (int i = matrix.size()-1; i >= matrix.size()/2; i--) {
                rotMatrix2[i][matrix.size()-i] = oriMatrix1[i][matrix.size()-i-1];
            }
            for (int j = 0; j < matrix.get(0).size()/2; j++) {
                for (int i = j+2; i < matrix.size()-j; i++) {
                    rotMatrix2[i][j] = oriMatrix1[i-1][j];
                }
            }
            // 아래
            for (int i = matrix.size()-1; i >= matrix.size()/2; i--) {
                rotMatrix2[i-1][i] = oriMatrix1[i][i];
            }
            for (int i = matrix.size()/2; i >= matrix.size()-1; i++) {
                for (int j = matrix.size()-i+1; j < matrix.get(0).size()-i; j++) {
                    rotMatrix2[i][j] = oriMatrix1[i][j + 1];
                }
                rotMatrix2[i-1][matrix.size()-i-1] = oriMatrix1[i][matrix.size()-i-1];
            }

            // 오른쪽
            for (int j = matrix.size()/2; j >= matrix.get(0).size()-1; j++) {
                for (int i = matrix.size()-i+1; i < matrix.size()-j; i++) {
                    rotMatrix2[i][j] = oriMatrix1[i-1][j];
                }
            }
        }
    }
}
    }

            }

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
