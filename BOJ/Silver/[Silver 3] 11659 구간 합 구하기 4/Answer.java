import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int num;
        int[] cumulativeSum = new int[N];
        cumulativeSum[0] = Integer.parseInt(st.nextToken());
        for (int k = 1; k < N; k++) {
            num = Integer.parseInt(st.nextToken());
            cumulativeSum[k] = cumulativeSum[k-1] + num;
        }

        StringBuilder sb = new StringBuilder();
        int i, j;
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken())-1;
            j = Integer.parseInt(st.nextToken())-1;

            if(i != 0)
                sb.append(cumulativeSum[j]-cumulativeSum[i-1] + "\n");
            else
                sb.append(cumulativeSum[j] + "\n");
        }

        System.out.println(sb);
    }
}