import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] costList;
    static int cost, minCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        costList = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            costList[i][0] = Integer.parseInt(st.nextToken());
            costList[i][1] = Integer.parseInt(st.nextToken());
            costList[i][2] = Integer.parseInt(st.nextToken());
        }

        minCost = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            cost = 0;
            dfs(0,i);
        }

        System.out.println(minCost);
    }

    public static void dfs(int start, int color) {
        cost += costList[start][color];

        if(start == N-1) {
            minCost = Math.min(minCost, cost);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if(color != i) {
                if(minCost < cost+costList[start+1][i])
                    continue;
                dfs(start + 1, i);
                cost -= costList[start+1][i];
            }
        }
    }
}