import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int tree_length[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree_length = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int n = 0; n < N; n++) {
            tree_length[n] = Integer.parseInt(st.nextToken());
            max = Math.max(tree_length[n], max);
        }

        long start = 0, end = max, mid = end/2, answer = 0;
        while (true){
            mid = (start + end) / 2;
            long sum = calc(mid);

            if (sum == M) {
                answer = mid;
                break;
            }
            else if (sum < M){
                end = mid-1;
            }
            else {
                answer = mid;
                start = mid+1;
            }

            if(start > end)
                break;
        }
        System.out.println(answer);
    }

    static long calc(long value){
        long result = 0;
        for(int i = 0; i < tree_length.length; i++){
            int tree = tree_length[i];
            if(tree > value){
                result += tree-value;
            }
        }
        return result;
    }
}
