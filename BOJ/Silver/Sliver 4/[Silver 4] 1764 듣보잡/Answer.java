import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> list = new HashSet<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        String s;
        int count = 0;
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            s = br.readLine();
            if(list.contains(s)) {
                count++;
                ls.add(s);
            }
        }

        Collections.sort(ls);

        System.out.println(count);
        for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i));
        }
    }
}