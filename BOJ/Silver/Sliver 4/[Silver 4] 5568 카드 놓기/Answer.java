import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static int N, K;
    public static String card[];
    public static boolean visited[];
    public static HashSet<String> hs = new HashSet<String>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        // 완전탐색을 진행하여 모든 경우를 보면서
        // +k개의 문자가 합쳐진 경우 HashSet을 이용해 서로 다른 조합을 파악하면 된다.
        // 완전탐색은 재귀로 진행 시 편리하다.
        // 또한 하나의 카드를 여러번 사용할 수 없으므로, 방문배열을 두어 사용한 카드를 체크해줘야 한다.

        // 서로다른 수의 나열만 파악하면 되므로 그냥 String으로 받는다.
        card = new String[N];
        for (int i = 0; i < N; i++) {
            card[i] = br.readLine();
        }

        visited = new boolean [N];
        selectCard(K, "");

        // 서로 다른 String의 가지수는 HashSet 등을 사용하면 쉽게 파악할 수 있다.
        System.out.println(hs.size());
    }

    public static void selectCard(int remain, String k) {
        // 전부 다 뽑았으면
        if(remain == 0) {
            // HashSet에 넣고 함수를 종료
            hs.add(k);
            return;
        }
        for(int i = 0; i < N; i++) {
            // 아직 뽑지 않았으면
            if(!visited[i]) {
                // 한 장을 뽑고
                visited[i] = true;
                // 그 다음 번호부터 하나씩 뽑는다
                selectCard(remain-1, k + card[i]);

                // 그 카드를 나중에 뽑기 위해해
                // 상위 함수로 돌아가서 뽑은 흔적을 지워준다
                visited[i] = false;
            }
        }

    }
}

// 출처 : https://velog.io/@phjppo0918/%EB%B0%B1%EC%A4%80-5568-%EC%B9%B4%EB%93%9C-%EB%86%93%EA%B8%B0-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-JAVA