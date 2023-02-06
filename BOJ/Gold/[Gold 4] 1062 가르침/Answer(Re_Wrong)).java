import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//시뮬레이션(구현)
public class Main {
    static int N, K;
    static String[] words;
    static boolean[] checked;
    static List<Character> character;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken())-5;

        if(K < 0) {
            System.out.println(0);
            return;
        }

        words = new String[N];
        checked = new boolean[N];
        String word;
        for (int i = 0; i < N; i++) {
            word = br.readLine().replaceAll("anta", "").replaceAll("tica", "");
            words[i] = word.replace("a", "")
                    .replace("n", "")
                    .replace("t", "")
                    .replace("i", "")
                    .replace("c", "");
            System.out.println(words[i]);
        }

        answer = 0;
        character = new ArrayList<>();
        backTracking();
        System.out.println(answer);
    }

    public static void backTracking() {
        for (int i = 0; i < N; i++) {
            if(checked[i])
                continue;
            for (int j = 0; j < character.size(); j++) {
                if (words[i] == "") {
                    answer++;
                    checked[i] = true;
                    break;
                }
                words[i].replace(character.get(j), '');
            }
            if(!checked[i]) {
                character.add(words[i].replace(words[i].charAt(0), ''));
                backTracking();
            }
        }
    }
}