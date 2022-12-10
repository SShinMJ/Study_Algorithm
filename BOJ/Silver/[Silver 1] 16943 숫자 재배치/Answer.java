import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String A, B, C;
    static long a,b,c;
    static boolean[] isVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();
        C = "";

        a = Long.parseLong(A);
        b = Long.parseLong(B);
        c = -1;

        // 재배치 시, 사용된 수인지 확인
        isVisited = new boolean[A.length()];

        DFS();

        System.out.println(c);
    }

    private static void DFS() {
        // A를 재배치한 C가 완성 됐고,
        if(C.length() == A.length()){
            //그 C의 값이 B보다 작다면
            if(Long.parseLong(C) < b)
                // 구해진 C 중 최대값을 저장
                c = Math.max(c, Long.parseLong(C));
            return;
        }

        // 뒷 자리수부터 재배치하며 최대값을 구하도록 재귀
        for(int i = 0 ; i < A.length(); i++){
            if((C.length() == 0 && A.charAt(i) == '0') || isVisited[i])
                continue;
            isVisited[i] = true;
            C += A.charAt(i);
            // 가장 뒷 자리까지 배치될 대까지 재귀
            DFS();
            // 재배치된 C를 구한 후 해당 숫자를 사용하지 않는 경우도 구함.
            isVisited[i] = false;
            // 만들어진 C에서 해당 숫자를 사용하지 않음.
            C = C.substring(0, C.length()-1);
        }
    }
}

// 출처 : https://hyeyun.tistory.com/entry/%EB%B0%B1%EC%A4%80-BOJ-16943-%EC%88%AB%EC%9E%90-%EC%9E%AC%EB%B0%B0%EC%B9%98-%EC%9E%90%EB%B0%94-JAVA