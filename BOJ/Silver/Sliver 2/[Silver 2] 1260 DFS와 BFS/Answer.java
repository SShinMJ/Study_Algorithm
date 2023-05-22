import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int node, line, start;
    static boolean[] check;
    static int[][] arr;
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start= Integer.parseInt(st.nextToken());

        arr = new int[node+1][node+1];
        check = new boolean[node+1];

        for(int i = 0 ; i < line ; i ++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            //간선들의 연결이 되어있는지 혹은 연결 되지 않았는 것을 판단할 때
            //인접행렬을 이용하거나, 혹은 인접리스트를 이용하는 것이 좋다.
            //뭐가 뭐에 연결된 지 안다면, 인접 행렬을 이용하는데,
            //인접 행렬은 꼭지점의 갯수가 적을때만 가능하다. (시간초과 가능성 때문)
            arr[a][b] = arr[b][a] =  1;
        }

        dfs(start);
        sb.append("\n");

        check = new boolean[node+1];
        bfs(start);

        System.out.println(sb);

    }

    public static void dfs(int start) {
        check[start] = true;  // 체크인
        sb.append(start + " ");

        for(int i = 0 ; i <= node ; i++) {  // 연결된 곳을 순회
            if(arr[start][i] == 1 && !check[i])  // 갈 수 있다면,
                dfs(i);  // 재귀
        }
    }

    public static void bfs(int start) {
        q.add(start);  // 시작 노드를 받아온다.
        check[start] = true;  // 체크인

        while(!q.isEmpty()) {  // 모두 돌 때까지 순회
            start = q.poll();  // 큐에서 꺼낸다.
            sb.append(start + " ");

            for(int i = 1 ; i <= node ; i++) {  // 연결된 곳을 순회
                if(arr[start][i] == 1 && !check[i]) {  // 갈 수 있다면,
                    q.add(i);  // 큐에 넣는다.
                    check[i] = true;  // 체크인
                }
            }
        }
    }
}

// 출처 및 설명 : https://infodon.tistory.com/96