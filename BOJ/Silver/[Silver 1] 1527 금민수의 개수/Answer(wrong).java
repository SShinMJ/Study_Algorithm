import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long answer = 0;
        boolean isCorrect;
        //무식하게 범위 내 수가 4or7로 이루어졌는 지 확인함. 메모리 초과.
        for (long num = N; num <= M; num++) {
            isCorrect = false;
            int[] arrNum = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < arrNum.length; i++) {
                if(arrNum[i] != 4 && arrNum[i] != 7)
                    break;
                if(i+1 == arrNum.length)
                    isCorrect = true;
            }
            if(isCorrect)
                answer++;
        }

        System.out.println(answer);
    }
}