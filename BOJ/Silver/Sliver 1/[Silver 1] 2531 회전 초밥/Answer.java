import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, D, K, C;
    static int[] dishs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dishs = new int[N];
        for (int i = 0; i < N; i++) {
            dishs[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> selectDishs = new ArrayList();
        int count = 0;
        int answer = 0;
        for (int i = 0; i < N+K; i++) {
            if(i >= N) {
                if(!selectDishs.contains(dishs[i-N]))
                    count++;
                selectDishs.add(dishs[i-N]);
            } else {
                if(!selectDishs.contains(dishs[i]))
                    count++;
                selectDishs.add(dishs[i]);
            }

            if(selectDishs.size() == K) {
                if(count >= answer) {
                    answer = count;
                    if (!selectDishs.contains(C)) {
                        answer++;
                        if (answer == K + 1)
                            break;
                    }
                }

                int dish = selectDishs.get(0);
                selectDishs.remove(0);
                if(!selectDishs.contains(dish))
                    count--;
            }
        }

        System.out.println(answer);
    }
}