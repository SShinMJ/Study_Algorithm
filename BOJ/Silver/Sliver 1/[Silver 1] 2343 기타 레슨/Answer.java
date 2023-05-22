import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        // 순서대로 블루레이에 집어넣어야 하므로 정렬과정 X.

        st = new StringTokenizer(br.readLine(), " ");
        long max = 0;
        long min = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.max(min, arr[i]);
            max += arr[i];
        }

        // 최대값이 int 범위를 벗어날 수 있으므로
        // 모두 이분 탐색에 필요한 모든 변수들은 long 타입으로 잡는다.
        long mid;
        long count;
        long sum;

        while (min <= max) {
            // 중간값(mid)이 블루레이 최소 크기의 후보.
            mid = (max + min) / 2;

            count = 1;  // 레슨을 분리한 그룹의 수
            sum = 0;    // 한 블루레이당 레슨 길이의 합

            // 한 블루레이당 레슨 길이의 합이 mid보다 작도록 레슨을 그룹으로 분리
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if (sum > mid) {
                    sum = arr[i];
                    count++;
                }
            }

            // 레슨을 분리한 그룹의 수가 M보다 크다면
            // (총 필요한 블루레이 개수가 M보다 크다면)
            if (count > M)
                min = mid + 1;
                // 레슨을 분리한 그룹의 수가 M보다 작거나 같다면
            else
                max = mid - 1;
        }

        System.out.println(min);
    }
}