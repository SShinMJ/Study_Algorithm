import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static int visit_order[];
    static ArrayList<Integer> adj[];
    static boolean ans[];
    static int ansCnt;
    static int num;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[V + 1];
        visit_order = new int[V + 1];
        ans = new boolean[V + 1];

        for(int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i = 1; i <= V; i++) {
            if(visit_order[i] == 0) {
                dfs(0, i, true);
            }
        }

        for(int i = 1; i <= V; i++) {
            if(ans[i]) ansCnt++;
        }
        System.out.println(ansCnt);

        for(int i = 1; i <= V; i++) {
            if(ans[i]) {
                System.out.print(i + " ");
            }
        }

    }

    private static int dfs(int parent, int cur, boolean isRoot) {
        if(visit_order[cur] != 0) return 0;
        int min_visit_order = 10010;
        int chlcnt = 0;

        num++;
        visit_order[cur] = num;
        
        for(int i = 0; i < adj[cur].size(); i++) {
            int nxt = adj[cur].get(i);

            if(nxt == parent) continue;

            if(visit_order[nxt] != 0) {
                if(visit_order[nxt] < min_visit_order) {
                    min_visit_order = visit_order[nxt];
                }
            }else {	
                int tmp = dfs(cur, nxt, false);
                min_visit_order = Math.min(min_visit_order, tmp);

                if(isRoot != true && tmp >= visit_order[cur]) {
                    ans[cur] = true;
                }
                chlcnt++;
            }
        }

        if(adj[cur].size() == 1) {
            return visit_order[cur];
        }

        if(isRoot) {
            if(chlcnt >= 2) {
                ans[cur] = true;
            }
        }

        return Math.min(min_visit_order, visit_order[cur]);
    }
}
