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
     * Complete the 'almostSorted' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void almostSorted(List<Integer> arr) {
        // 오름차순으로 정렬된 리스트 만들어놓기 (비교용)
        List<Integer> aList = new ArrayList<>();
        aList.addAll(arr);
        Collections.sort(aList);

        // 처음부터 정렬되어 있는지 확인
        if(arr.equals(aList)) {
            System.out.println("yes");
            return;
        }

        // ##### SWAP으로 구성할 수 있는지 확인 #####
        boolean isSwap = true;
        for(int i=1; i<arr.size(); i++) {
            // 문제가되는 지점(spot)을 찾는다. (i-1번째가 문제가 되는 원소)
            if(arr.get(i-1) > arr.get(i)) {

                // 먼저 문제가 되는 지점과 바로 다음 원소를 일단 swap 해본다.
                // 예시) 1 2 4 3 5 6  >> 4와 3을 swap 하면 끝
                Swap(i-1, i, arr);
                if(arr.equals(aList)) {
                    // 답을 출력할 때는 시작 인덱스를 1부터 했던 걸로
                    i++;
                    System.out.println("yes");
                    System.out.println("swap " + (i-1) +" " + i);
                    return;
                }else {
                    // swap 했는데 완전히 정렬되지 않았다면
                    // 다른 지점에서 교환할 수 있는 곳이 있는지 원상복구
                    // 아직 swap 여지는 남아 있다.
                    Swap(i-1, i, arr);
                }

                // 최적의 swap 위치를 찾는다. (바로 옆 원소가 아니 지점에서 교환하면 되는지 확인)
                // 예시) 1 2 50 9 10 49 3 >> 50과 3을 바꿔야 한다.
                for(int j=i+1; j<arr.size(); j++) {
                    // 발견되지 않는다면 바꿀 원소가 없다.
                    if(arr.get(j-1) > arr.get(j)) {
                        Swap(i-1, j, arr);

                        if(arr.equals(aList)) {
                            // 답을 출력할 때는 인덱스를 1부터 했던 걸로 인덱스 조정해서 출력
                            i++; j++;
                            System.out.println("yes");
                            System.out.println("swap " + (i-1) +" " + j);
                            return;
                        }else {
                            // 한번 swap 시도했는데 완전히 정렬되지 않았다면
                            // 더 이상 탐색해봤자 swap으로는 정렬 시킬 수 없다.
                            Swap(i-1, j, arr); // 다시 제자리로 reverse 탐색을 위함
                            isSwap = false; // 더 이상의 swap 탐색은 하지 않겠다.
                            break;
                        }
                    }
                }
            }
            // 한번의 swap으로 해결되지 않는다면 탐색 종료
            if(!isSwap) break;
        }

        // ##### REVERSE로 구성할 수 있는지 확인 #####
        // reverse 단계까지 왔다면 적어도 원소가 3개 이상일 때 고려해야 한다.
        // 2 지점이 문제였다면 위쪽의 swap에서 filter 되었을 것이므로.
        boolean isReverse = true;
        for(int i=1; i<arr.size(); i++) {
            // 문제가 되는 부분의 시작지점(spot)을 찾는다. (i-1번째가 문제가 되는 원소)
            if(arr.get(i-1) > arr.get(i)) {
                // 어디까지 뒤집어볼지 부분의 끝지점을 탐색
                // 예시) 1 5 4 3 2 6 >> 5를 찾은 상태이고 End Point '2'를 찾아야 한다.
                for(int j=i+1; j<arr.size(); j++) {
                    // 내림차순이었다가 오름차순이 되는 지점(End Point)을 찾아서 reverse
                    if(arr.get(j-1) < arr.get(j)) {
                        // 해당 구간 뒤집기
                        Reverse(i-1, j-1, arr);
                        if(arr.equals(aList)) {
                            // 답을 출력할 때는 인덱스를 1부터 했던 걸로
                            i++; j++;
                            System.out.println("yes");
                            System.out.println("reverse " + (i-1) +" " + (j-1));
                            return;
                        }else {
                            // Reverse 했는데 완전히 정렬되지 않았다면
                            // Reverse로 정렬 시킬 수 없다.
                            // 굳이 원상복구 시킬 필요 없이 다른 방도가 없다.
                            isReverse = false;
                            break;
                        }
                    }
                }
            }
            // 한번의 Reverse으로 해결되지 않는다면 탐색 종료
            if(!isReverse) break;
        }

        // ##### swap, reverse로 해결되지 않을 때
        System.out.println("no");
    }

    private static void Swap(int x, int y, List<Integer> arr) {
        int temp = arr.get(x);
        arr.set(x, arr.get(y));
        arr.set(y, temp);
    }

    private static void Reverse(int x, int y, List<Integer> arr) {
        while(x < y) {
            int temp = arr.get(x);
            arr.set(x, arr.get(y));
            arr.set(y, temp);
            x++; y--;
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.almostSorted(arr);

        bufferedReader.close();
    }
}
