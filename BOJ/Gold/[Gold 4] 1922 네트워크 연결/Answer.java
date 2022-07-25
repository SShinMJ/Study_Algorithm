import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        graph = new int[M][3];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(graph, Comparator.comparingInt((int[] o) -> o[2]));

        int minTotal = 0;
        for (int i = 0; i < graph.length; i++) {
            if(find(graph[i][0]) != find(graph[i][1])) {
                minTotal += graph[i][2];
                union(graph[i][0], graph[i][1]);
            }
        }
        System.out.println(minTotal);

    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        parent[aRoot] = bRoot;
    }

    static int find(int num) {
        if(parent[num] == num) {
            return num;
        } else {
            return parent[num] = find(parent[num]);
        }
    }
}
