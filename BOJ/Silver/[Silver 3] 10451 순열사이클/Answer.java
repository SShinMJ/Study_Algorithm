import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N;
    static int[] permutation;
    static boolean[] check;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            answer = 0;
            N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            permutation = new int[N+1];
            check = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                permutation[j] = Integer.parseInt(st.nextToken());
                check[j] = false;
            }

            // 순열 내 모든 수의 사이클을 확인
            for (int j = 1; j < N+1; j++) {
                if(!check[j]) // 순열 사이클에 사용되지 않은 수만
                    dfs(j);  // 새로운 순열 사이클을 만드는 데 사용되도록 한다.
            }

            System.out.println(answer);
        }
    }

    public static void dfs(int target) {
        // 목적지인지 확인
        if(check[target]) {  // 이미 지나온 수 이므로
            answer++;  // 하나의 순열 사이클이 완성된 것이다.
            return;
        }

        // 체크인
        check[target] = true;
        // 목적지가 아니므로 다음 루트로 이동
        dfs(permutation[target]);
    }
}