import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, D;
    static List<int[]> list;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        int start, end, dis;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            dis = Integer.parseInt(st.nextToken());
            list.add(new int[] {start, end, dis});
        }
        // 시작, 도착지 기준으로 정렬
        Collections.sort(list, Comparator.comparingInt(o -> o[0]));

        result = Integer.MAX_VALUE;
        recur(0, 0, 0);
        System.out.println(result);
    }

    static void recur(int h, int end, int sum) {
        // N번째 지름길까지 탐색 완료한 경우(완전 탐색이 끝난 경우)
        if(h == N) {
            // 도착점을 넘어섰다면 이 경로는 답이 아님.
            if(end > D) {
                return;
            }
            // 마지막 지름길이 목적지에 도착하는 경우
            else if(end==D){
                result = Math.min(result, sum);
            }
            // 도착지에 도착하지 못했으므로
            else {
                // 도착지까지 남은 거리를 더한 값과 비교.
                result = Math.min(result, sum+D-end);
            }
            return;
        }

        // h번재 지름길을 가져와서
        int[] arr = list.get(h);
        // 출발점이 이전 지름길의 도착점보다 크거나 같다면
        if(arr[0] >= end) {
            // h번재 지름길을 이용한다. > 도착점 = arr[1](h번재 지름길의 도착점)
            // > 이동 거리 += 이전 도착지에서 h번째 지름길까지 이동한 거리 + h번째 지름길로 이동한 거리
            // 이 후 h+1번째 지름길을 탐색
            recur(h+1, arr[1], sum+arr[2]+arr[0]-end);
        }
        // h번째 지름길을 거치지 않고 이동하는 경우도 탐색.
        // 출발점이 이전 지름길의 도착점보다 크더라도 이후에 더 효율 높은 지름길이 있을 수 있다.
        recur(h+1, end, sum);
    }
}