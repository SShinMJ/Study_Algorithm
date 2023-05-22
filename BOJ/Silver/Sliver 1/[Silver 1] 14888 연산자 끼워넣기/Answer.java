import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//DFS(백트래킹) 구현
public class Main {
    static int N;
    static int[] nums;
    static int[] operator;

    static int MAX = Integer.MIN_VALUE;	// 최댓값
    static int MIN = Integer.MAX_VALUE;	// 최솟값

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nums[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int num, int idx) {
        if(N == idx){
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i <4; i++) {
            // 연산자 개수가 1개 이상인 경우
            if(operator[i] > 0) {
                // 해당 연산자를 1 감소시킨다.
                operator[i]--;

                switch (i) {
                    case 0: dfs(num + nums[idx], idx+1); break;
                    case 1: dfs(num - nums[idx], idx+1); break;
                    case 2: dfs(num * nums[idx], idx+1); break;
                    case 3: dfs(num / nums[idx], idx+1); break;
                }

                // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
                operator[i]++;
            }
        }
    }
}