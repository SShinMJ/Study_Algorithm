import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int[] edgeCount;
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<Integer>());
        }
        edgeCount = new int[N+1];

        for (int i = 1; i < M+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            edgeCount[b]++;
        }

        for (int i = 1; i < edgeCount.length; i++) {
            if (edgeCount[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int nodeNo = q.poll();

            sb.append(nodeNo + " ");

            List<Integer> list = graph.get(nodeNo);

            for (int i = 0; i < list.size(); i++) {
                edgeCount[list.get(i)]--;
                if (edgeCount[list.get(i)] == 0) {
                    q.offer(list.get(i));
                }
            }
        }
        System.out.println(sb);
    }
}
