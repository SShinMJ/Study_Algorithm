import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int N;
        StringTokenizer st;
        Map<String, Integer> map;
        String category;

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            map = new HashMap<String, Integer>();
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                category = st.nextToken();
                if(map.containsKey(category))
                    map.put(category, (map.get(category)+1));
                else
                    map.put(category, 1);
            }

            int answer = 1;
            for (String key : map.keySet()) {
                // '이 종류의 옷을 안 입는 경우'까지 총 3가지.
                answer *= (map.get(key)+1);
            }
            // 모든 종류의 옷을 입지 않는 경우 하나를 빼줘야한다.
            sb.append(answer-1 + "\n");
        }
        System.out.println(sb);
    }
}