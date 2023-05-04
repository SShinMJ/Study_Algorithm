import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 정렬이 가능한 Map > TreeMap
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int k = Integer.parseInt(br.readLine());
            // TreeMap은 이진 트리를 기반으로 오름차순으로 정렬된 형태로 저장
            // 따라서 firstKey()와 lastKey()는 O(logN) 만큼 밖에 소요되지 않는다
            TreeMap<Integer, Integer> que = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                String[] input = br.readLine().split(" ");
                char ch = input[0].charAt(0);
                int n = Integer.parseInt(input[1]);

                if (ch == 'I') {
                    // 숫자와 해당 숫자가 저장된 갯수를 저장
                    que.put(n, que.getOrDefault(n, 0) + 1);
                } else {
                    if (que.size() == 0)
                        continue;

                    int num = n == 1 ? que.lastKey() : que.firstKey();
                    if (que.put(num, que.get(num) - 1) == 1)
                        que.remove(num);
                }
            }

            System.out.println(que.size() == 0 ? "EMPTY" : que.lastKey() + " " + que.firstKey());
        }
    }
}