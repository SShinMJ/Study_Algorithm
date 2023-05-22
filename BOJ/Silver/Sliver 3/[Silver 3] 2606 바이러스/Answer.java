import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int computers, networks;
    static int[][] comNet;
    static boolean[] check;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        computers = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        networks = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        comNet = new int[computers+1][computers+1];
        check = new boolean[computers+1];
        int offset, target;
        for (int i = 0; i < networks; i++) {
            st = new StringTokenizer(br.readLine());
            offset = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());
            comNet[offset][target] = 1;
            comNet[target][offset] = 1;
        }

        findVirus(1);

        System.out.println(answer);
    }

    static void findVirus(int start) {
        check[start] = true;  // 체크인

        for(int i = 0 ; i <= computers ; i++) {  // 연결된 곳을 순회
            if(comNet[start][i] == 1 && !check[i]) {  // 갈 수 있다면,
                answer++;  // 1과 연결(감염)됐으므로 추가
                findVirus(i);  // 재귀
            }
        }
    }
}