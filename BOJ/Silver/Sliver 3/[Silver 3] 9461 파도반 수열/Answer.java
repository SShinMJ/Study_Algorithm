import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] nList = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            nList[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, nList[i]);
        }

        StringBuilder sb = new StringBuilder();
        Long[] sequence = new Long[max+1]; // 주의 : 담기는 값이 int 범위 벗어날 수 있음!
        for (int i = 1; i < max+1; i++) {
            if(i < 4)
                sequence[i] = Long.valueOf(1);
            else if(i < 6)
                sequence[i] = Long.valueOf(2);
            else
                sequence[i] = sequence[i-1] + sequence[i-5];
        }

        for (int i = 0; i < T; i++) {
            sb.append(sequence[nList[i]] + "\n");
        }

        System.out.println(sb);
    }
}