import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =  Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> set = new ArrayList<>();
        String category;
        int answer = 0;

        for (int j = 0; j < N; j++) {
            set.add(br.readLine());
        }

        for (int j = 0; j < M; j++) {
            category = br.readLine();

            if(set.contains(category))
                answer++;
        }

        System.out.println(answer);
    }
}