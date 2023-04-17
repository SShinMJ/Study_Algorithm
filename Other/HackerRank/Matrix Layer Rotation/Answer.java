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
        int m = matrix.size();
        int n = matrix.get(0).size();
        // 1. 주어진 배열이 몇개의 cycle로 구성할 수 있는지 확인
        int cycle = Math.min(m, n) / 2;

        // 리스트가 여러개 필요하므로 이를 동적으로 제어하기 위해
        // 리스트 안에 리스트를 넣어둠
        List<ArrayList<Integer>> cycleList = new ArrayList<ArrayList<Integer>>();
        for(int c=0; c<cycle; c++) {
            ArrayList<Integer> temp = new ArrayList<>();
            cycleList.add(temp);
        }

        // 2. 각 cycle(테두리)을 각각의 리스트에 보관하여 한 줄로 표시
        // cycle 방향으로 집어 넣을 수 있도록(하우상좌)
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int c=0; c<cycle; c++) {
            // 바깥쪽 테두리(cycle)부터 보관 (반시계 방향 탐색)
            ArrayList<Integer> temp = cycleList.get(c);
            // 각 cycle(테두리)의 시작 지점
            int x = c;
            int y = c;

            // 시작 지점을 리스트에 먼저 넣어둔다.
            // (시작지점은 -1로 표시안해도 탐색에 지장x)
            temp.add(matrix.get(x).get(y));

            // 탐색하면서 리스트에 값 저장
            for(int d=0; d<dx.length; d++) {
                // 특정 방향의 끝지점 까지
                while(true) {
                    x = x + dx[d];
                    y = y + dy[d];
                    if(x < 0 || y < 0 || x >= m  || y >= n) {
                        // 이어서 탐색하기 위해 배열 벗어난 index 재조정
                        x = x - dx[d];
                        y = y - dy[d];
                        break;
                    }
                    // 한바퀴 돌면서 시작 지점에 돌아왔으면 stop
                    // (for문이 다 수행된 순간)
                    if(x == c && y == c) {
                        break;
                    }

                    // 제일 바깥쪽 테두리는 상관 없지만.
                    // 안쪽 테두리들은 바깥쪽 테두리를 침범하지 않으면서 탐색해야 한다.
                    // 즉 범위를 좁혀가야 하므로 탐색 표시를 음수(-1)로 표시
                    if(matrix.get(x).get(y) == -1) {
                        // 이어서 탐색하기 위해 배열 벗어난 index 재조정
                        x = x - dx[d];
                        y = y - dy[d];
                        break;
                    }
                    // 해당 값 저장
                    temp.add(matrix.get(x).get(y));
                    // 탐색 표시
                    matrix.get(x).set(y, -1);
                }
            }
        }

        // 3. r이 클 수 있기 때문에 각 테두리별로 회전 주기를 분석하여 맞춰준다.
        for(int i=0; i<cycleList.size(); i++) {
            ArrayList<Integer> temp = cycleList.get(i);
            // 해당 테두리 회전주기를 분석
            int rotation = r % temp.size();
            // 각 cycle(테두리) 회전 시작
            while(rotation-- > 0) {
                // 제일 뒤의 원소를 앞쪽으로 배치
                temp.add(0, temp.remove(temp.size()-1));
            }
        }

        // 4. 회전이 끝난 후 배열에 맞에 다시 재배치
        for(int c=0; c<cycle; c++) {
            // 바깥쪽 테두리(cycle)부터 재배치
            ArrayList<Integer> temp = cycleList.get(c);
            // 각 cycle(테두리)의 시작 지점
            int x = c;
            int y = c;

            // 시작 지점에 리스트의 제일 앞 원소부터 집어 넣는다.
            matrix.get(x).set(y, temp.remove(0));

            // 달팽이 모양으로 탐색
            for(int d=0; d<dx.length; d++) {
                // 특정 방향의 끝지점 까지
                while(true) {
                    x = x + dx[d];
                    y = y + dy[d];
                    if(x < 0 || y < 0 || x >= m  || y >= n) {
                        // 이어서 탐색하기 위해 배열 벗어난 index 재조정
                        x = x - dx[d];
                        y = y - dy[d];
                        break;
                    }
                    // 한바퀴 돌면서 시작 지점에 돌아왔으면 stop
                    // (for문이 다 수행된 순간)
                    if(x == c && y == c) {
                        break;
                    }

                    // 제일 바깥쪽 테두리는 상관 없지만.
                    // 안쪽 테두리들은 바깥쪽 테두리를 침범하지 않으면서 탐색해야 한다.
                    // 역으로 음수 여부를 판단하면서 탐색
                    if(matrix.get(x).get(y) != -1) {
                        // 이어서 탐색하기 위해 배열 벗어난 index 재조정
                        x = x - dx[d];
                        y = y - dy[d];
                        break;
                    }
                    matrix.get(x).set(y, temp.remove(0));
                }
            }
        }

        // 정답 출력
        for(int x=0; x<m; x++) {
            for(int y=0; y<n; y++) {
                System.out.print(matrix.get(x).get(y) +" ");
            }
            System.out.println();
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
