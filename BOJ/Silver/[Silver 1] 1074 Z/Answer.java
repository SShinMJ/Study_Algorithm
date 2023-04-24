import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        N = (int) Math.pow(2, N);
        fourDivisions(N, r, c);
    }

    public static void fourDivisions(int n, int nowR, int nowC) {
        if(n == 1 || (nowR == 0 && nowC == 0)) {
            System.out.println(answer);
            System.exit(0);
        }

        while (n/2 >= nowR+1 && n/2 >= nowC+1) {
            if (n > nowR + 1 && n > nowC+1) {
                n /= 2;
            }
        }

        // 2번구역 > 1번 구역까지의 순서 합 + r,c까지 순서
        if(nowC+1 > n/2 && nowR+1 <= n/2) {
            answer += ((n/2) * (n/2));
            fourDivisions(n/2, nowR, nowC-(n/2));
        }
        // 3번구역 > 1,2번 순서합 + r,c까지 순서
        else if(nowR+1 > n/2 && nowC+1 <= n/2) {
            answer += 2 * ((n/2) * (n/2));
            fourDivisions(n/2, nowR-(n/2), nowC);
        }
        // 4번구역 > 1,2,3번 순서 합 + r,c까지 순서
        else {
            answer += 3 * ((n/2) * (n/2));
            fourDivisions(n/2, nowR-(n/2), nowC-(n/2));
        }
    }
}