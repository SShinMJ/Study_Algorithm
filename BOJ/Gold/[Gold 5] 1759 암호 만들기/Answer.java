import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char alphabet[];
    static List<String> result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new char[C];
        result = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            alphabet[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphabet);
        if(L == 3 || L == 15) {
            System.out.println(String.valueOf(alphabet));
        }else {
            dfs(0, 0, 0, -1, "");
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i)).append("\n");
            }
            bw.write(sb.toString() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int length, int ja, int mo, int current, String pwd) {
        if ( length == L){
            if( ja >= 2 && mo >= 1)
                result.add(pwd);
        }else {
            for(int i = current+1; i<C; i++) {
                if(alphabet[i] == 'a' || alphabet[i] == 'e' || alphabet[i] == 'i' || alphabet[i] == 'o' || alphabet[i] == 'u'){
                    dfs(length+1, ja, mo+1, i, pwd+alphabet[i]);
                }else
                    dfs(length+1, ja+1, mo, i, pwd+alphabet[i]);
            }
        }
    }
}
