import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static LinkedList<Integer>[] adjList;
    static boolean visited[];
    static int hackedNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 정점의 개수
        M = Integer.parseInt(st.nextToken());  // 간선의 개수

        // N의 수가 크므로 인접행렬보단 인접리스트로 구현하는 것이 좋다.
        adjList = new LinkedList[N + 1];
        visited = new boolean[N + 1];    // 방문 여부를 검사할 배열
        for (int i = 0; i <= N; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        // 두 정점 사이에 여러 개의 간선이 있을 수 있다.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            // adjList[v1].add(v2); 방향이 있는 문제(v2가 해킹되면 v1도 해킹할 수 있다)
            adjList[v2].add(v1);
        }

        int result = 0;
        String answer = "";
        for (int i = 1; i <= N; i++) {
            if(adjList[i].isEmpty())
                continue;

            hackedNum = 1;
            visited = new boolean[N + 1]; // 방문 초기화

            dfs_list(i);

            if(result < hackedNum) {
                result = hackedNum;
                answer = String.valueOf(i);
            } else if(result == hackedNum) {
                answer += " " + i;
            }
        }

        System.out.println(answer);
    }

    // DFS - 인접리스트 - 재귀로 구현
    public static void dfs_list(int start) {
        visited[start] = true; // 체크인

        Iterator<Integer> iter = adjList[start].listIterator(); // 정점 인접리스트 순회
        while (iter.hasNext()) {  // 읽어올 요소가 없을 때까지
            int next = iter.next();  // 다음 데이터를 반환
            if (!visited[next]) {  // 방문하지 않은 정점이라면
                hackedNum++;
                dfs_list(next); // 다시 DFS
            }
        }
    }
}