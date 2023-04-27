import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 문자열 탐색에서는 HashMap이 가장 효율이 좋다!
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> pokemon = new HashMap<>();
        String[] pokemonArr = new String[N + 1];
        String name;
        for (int i = 1; i <= N; i++) {
            name = br.readLine();
            pokemon.put(name, i);
            pokemonArr[i] = name;
        }

        String s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            s = br.readLine();
            if(s.charAt(0)-'A' > 0) {
                sb.append(pokemon.get(s) + "\n");
            } else {
                s.replace("\n", "");
                sb.append(pokemonArr[Integer.parseInt(s)] + "\n");
            }
        }

        System.out.println(sb);
    }
}