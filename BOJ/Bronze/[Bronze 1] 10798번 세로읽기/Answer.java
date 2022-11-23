import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] ch = new char[5][15];

        for(int i = 0; i < 5; i++){
            String str = new StringTokenizer(br.readLine()).nextToken();
            for(int j = 0; j < str.length(); j++){
                ch[i][j]=str.charAt(j);
            }
        }
        for(int i = 0 ; i < 15 ; i ++) {
            for(int j = 0 ; j < 5 ; j ++) {
                if(ch[j][i]==' ' || ch[j][i]=='\0')
                    continue;

                System.out.print(ch[j][i]);
            }
        }
    }
}
