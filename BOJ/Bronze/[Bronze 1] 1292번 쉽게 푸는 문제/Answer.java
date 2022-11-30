import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int start, end;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        List<Integer> sequence = new ArrayList<>();
        for (int i = 1; i <= end; i++) {
            for (int j = 0; j < i; j++) {
                sequence.add(i);
            }
        }

        int answer = 0;
        for (int i = start-1; i < end; i++) {
            answer += sequence.get(i);
        }
        System.out.println(answer);
    }
}