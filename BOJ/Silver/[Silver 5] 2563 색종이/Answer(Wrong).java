import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int[][] square;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        square = new int[T][2];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            square[i][0] = Integer.parseInt(st.nextToken());
            square[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = 100;
        for (int i = 1; i < T; i++) {
            answer += 100;
            int xStart = square[i][0], xEnd = square[i][0]+10;
            int yStart = square[i][1], yEnd = square[i][1]+10;
            int xPreStart, xPreEnd, yPreStart, yPreEnd;
            // 여러장 중복으로 겹치는 부분이 계속 뺄셈됨.
            for (int j = 0; j < i; j++) {
                xPreStart = square[j][0]; xPreEnd = square[j][0] + 10;
                yPreStart = square[j][1]; yPreEnd = square[j][1] + 10;
                if((xPreStart <= xStart) && (xPreEnd > xStart)) {
                    if((yPreStart <= yStart) && (yPreEnd > yStart)) {
                        answer -= (xPreEnd - xStart) * (yPreEnd - yStart);
                    } else {
                        answer -= (xPreEnd - xStart) * (yEnd - yPreStart);
                    }
                } else if ((xPreStart < xEnd) && (xPreEnd >= xEnd)) {
                    if((yPreStart <= yStart) && (yPreEnd > yStart)) {
                        answer -= (xEnd - xPreEnd) * (yPreEnd - yStart);
                    } else {
                        answer -= (xEnd - xPreEnd) * (yEnd - yPreStart);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}