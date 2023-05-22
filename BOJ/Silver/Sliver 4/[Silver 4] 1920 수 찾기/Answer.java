import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] A;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(key)).append('\n');
        }
        System.out.println(sb);
    }

    private static int binarySearch(int key) {
        int lo = 0;
        int hi = A.length;

        // lo가 hi랑 같아질 때 까지 반복
        while (lo < hi) {
            int mid = (lo + hi) / 2; // 중간위치를 구한다.

            if(A[mid] == key)
                return 1;
                // key 값이 중간 위치의 값보다 작거나 같을 경우
                // (중복 원소에 대해 왼쪽으로 탐색하도록 상계를 내린다.)
            else if (key <= A[mid]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }

        return 0;
    }
}