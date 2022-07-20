import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    static int N, M, K;
    static long[] nums, tree;
    
    static int S;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

       nums = new long[N];
       for(int i = 0; i < N; i++){
           nums[i] = Long.parseLong(br.readLine());
       }

        S = 1;
        while (S < N){
            S *= 2;
        }
        tree = new long[S*2]; 
        initBU();

       for(int i = N+2; i <= N+M+K+1; i++){
           st = new StringTokenizer(br.readLine());
           if(Integer.parseInt(st.nextToken()) == 1){
               int b = Integer.parseInt(st.nextToken());
               long c = Long.parseLong(st.nextToken());
               updateBU(b, c);

           } else {
               int b = Integer.parseInt(st.nextToken());
               int c = Integer.parseInt(st.nextToken());

               System.out.println(queryBU(b, c));
           }
       }

    }

    static void initBU() {
        for(int i = 0; i < N; i++){
            tree[S+i] = nums[i];
        }
        for( int i = S-1; i > 0; i--){
            tree[i] = tree[i*2] +  tree[i *2 + 1];
        }
    }

    static long queryBU(int queryLeft, int queryRight){
        int left = S + queryLeft - 1;
        int right = S + queryRight -1;
        long sum = 0;
        while (left <= right){
            if(left % 2 == 1) {
                sum += tree[left++]; 
            }
            if(right % 2 == 0) { 
                sum += tree[right--]; 
            }
            left /= 2;
            right /= 2;

        }
        return sum;
    }

    static void updateBU(int target, long value){
        int node = S + target - 1;
        tree[node] = value;
        node /= 2; 
        while (node > 0) {
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
            node /= 2;
        }
    }

}
