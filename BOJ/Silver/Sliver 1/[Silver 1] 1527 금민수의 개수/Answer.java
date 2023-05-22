import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        // 4와 7로만 이뤄진 숫자를 구하는 알고리즘 문제
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(long num) {
        // dfs가 0으로 시작하므로 숫자 범위가 맞는지 계산을 해줘야한다
        if(num > B)
            return; // 재귀이므로 종료조건 중요
        if(num >= A)
            answer++;

        // 이 부분이 중요 , 4와 7만 들어가게 dfs를 만든다
        dfs(num*10+4);
        dfs(num*10+7);
    }
}

// 출처 : https://jisu-shin.github.io/2021/03/05/Boj-1527/