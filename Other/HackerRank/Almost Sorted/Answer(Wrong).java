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

    // 테케 7, 8 실패, 테케 20 시간초과
    public static void almostSorted(List<Integer> arr) {
        List<List<Integer>> changeNum = new ArrayList<>();
        // 한 번 흝으며 swap으로 해결되는 지 확인
        for (int i = 0; i < arr.size()-1; i++) {
            if(arr.get(i) > arr.get(i+1)) {
                if(i == arr.size()-2 ||
                        (i == 0 && arr.get(i) < arr.get(i+2)) ||
                        (i == arr.size()-2 && arr.get(i+1) > arr.get(i-1)) ||
                        (arr.get(i+1) > arr.get(i-1) && arr.get(i) < arr.get(i+2))) {
                    changeNum.add(Arrays.asList(i, i+1));
                    break;
                }
                for (int j = i+2; j < arr.size(); j++) {
                    if(arr.get(j) < arr.get(i+1) && arr.get(i) > arr.get(j-1) &&
                            (j != arr.size()-1 ? arr.get(i) < arr.get(j+1) : true)) {
                        changeNum.add(Arrays.asList(i, j));

                        // 1. swap할 것이 여러가지인 경우
                        if(changeNum.size() > 1) {
                            // reverse(구간 내 차순 변경)으로 해결되는 지 확인
                            Integer x = changeNum.get(0).get(0);
                            Integer y = changeNum.get(0).get(1);
                            for (int k = x; k < y; k++) {
                                // 해결되지 않는 경우 (no 출력)
                                if(!(arr.get(k) > arr.get(k+1))){
                                    System.out.println("no");
                                    System.exit(0);
                                }
                            }
                            // 해결되는 경우 (yes와 reverse 구간 출력)
                            System.out.println("yes\nreverse " + (x+1) + " " + (y+1));
                            System.exit(0);
                        }
                    }
                }
                if(changeNum.size() == 0){
                    System.out.println("no");
                    System.exit(0);
                }
            }
        }

        // 2. swap 할 것이 하나 있는 경우 (yes와 두 위치 출력)
        if(changeNum.size() == 1)
            System.out.println("yes\nswap " + (changeNum.get(0).get(0)+1) + " " + (changeNum.get(0).get(1)+1));

            // 3. swap 할 것이 없는 경우 (yes만 출력)
        else if(changeNum.size() == 0)
            System.out.println("yes");
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 4, 3, 5, 6));

        Result.almostSorted(arr);
    }
}
