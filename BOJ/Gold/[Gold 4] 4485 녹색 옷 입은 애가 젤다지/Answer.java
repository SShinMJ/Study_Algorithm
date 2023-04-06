import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] nums;
    static int[][] dijk; // 최소비용을 저장
    static int[] directionX = {1, 0, -1, 0};
    static int[] directionY = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0)
                break;

            nums = new int[N][N];
            dijk = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    nums[i][j] = Integer.parseInt(st.nextToken());
                    dijk[i][j] = Integer.MAX_VALUE;
                }
            }

            count++; // 반복 횟수 증가

            sb.append("Problem " + count + ": " + dijkstra() + "\n");
        }

        System.out.println(sb);
        br.close();
    }

    // 좌표와 가중치 class
    static class point implements Comparable<point> {

        int row, col, cost;

        public point(int row, int col, int cost) {
            super();
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public int compareTo(point o) {
            return this.cost - o.cost; // 오름차순 정렬 ( return 값이 양수일때 자리바꿈 )
        }

    }

    // 범위 검사
    static boolean isValid(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N)
            return false;
        return true;
    }

    public static int dijkstra() {
        PriorityQueue<point> pq = new PriorityQueue<point>();
        dijk[0][0] = nums[0][0]; // 초기 값
        pq.offer(new point(0, 0, nums[0][0])); // 시작 좌표

        while (!pq.isEmpty()) {
            point p = pq.poll();

            // 사방탐색
            for (int k = 0; k < 4; k++) {
                int nextRow = p.row + directionX[k];
                int nextCol = p.col + directionY[k];

                // 범위 검사
                if (isValid(nextRow, nextCol)) {
                    if (dijk[nextRow][nextCol] > dijk[p.row][p.col] + nums[nextRow][nextCol]) { // 기존의 가중치보다 작은 경우
                        dijk[nextRow][nextCol] = dijk[p.row][p.col] + nums[nextRow][nextCol]; // 가중치를 교환
                        pq.offer(new point(nextRow, nextCol, dijk[nextRow][nextCol])); // 큐에 추가
                    }
                }
            }
        }
        return dijk[N - 1][N - 1];
    }
}