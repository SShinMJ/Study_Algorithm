import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] friends;
    static boolean[] check;
    static boolean[] isInvite;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        M = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        friends = new int[N +1][N +1];
        check = new boolean[N +1];
        isInvite = new boolean[N +1];
        int offset, target;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            offset = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());
            friends[offset][target] = 1;
            friends[target][offset] = 1;
        }

        dfs(1, 1);

        System.out.println(answer);
    }

    static void dfs(int start, int count) {
        if(count > 2)
            return;

        check[start] = true;

        for(int i = 0; i <= N; i++) {
            if(friends[start][i] == 1 && !check[i]) {
                if(!isInvite[i]) {
                    answer++;
                    isInvite[i] = true;
                }
                dfs(i, count+1);
            }
        }
    }
}