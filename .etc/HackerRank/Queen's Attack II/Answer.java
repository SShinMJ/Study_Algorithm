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
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    static int calc_delta(int r1, int c1, int r2, int c2) {
        int delta_r;
        int delta_c;

        delta_r = r2 - r1;
        delta_c = c2 - c1;

        if (delta_r == 0 || delta_c == 0) {
            return 0;
        }

        if (Math.abs(delta_r) - Math.abs(delta_c) == 0) {
            return 1;
        }

        return 2;
    }

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        int[] distanceX = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] distanceY = {0, 1, 1, 1, 0, -1, -1, -1};

        // 입력받은 모든 obstacle들을 검사하면 시간초과 발생하므로
        // Queen이 지나가는 경로에 있는 장애물만 리스트에 담는다.
        List<List<Integer>> nObstacles = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int delta = calc_delta(r_q, c_q, obstacles.get(i).get(0), obstacles.get(i).get(1));
            if (delta == 0 || delta == 1) {
                nObstacles.add(Arrays.asList(obstacles.get(i).get(0), obstacles.get(i).get(1)));
            }
        }

        int nowX, nowY;
        int answer = 0;
        for (int i = 0; i < 8; i++) {
            nowX = r_q-1;
            nowY = c_q-1;
            while (true) {
                nowX += distanceX[i];
                nowY += distanceY[i];

                if(nowX < 0 || nowY < 0 || nowX >= n || nowY >= n || nObstacles.contains(Arrays.asList(nowX+1, nowY+1)))
                    break;

                // 장애물이 없는 경우
                answer++;
            }
        }

        return answer;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
