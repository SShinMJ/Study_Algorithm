import java.io.*;
import java.util.Scanner;

public class Main {
    static int N, K;
    static String words[];
    static boolean visted[];
    static int seleting_count = 0;
    static int answer;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        words = new String[N];
        visted = new boolean[26];
        visted['a' - 'a'] = true;
        visted['c' - 'a'] = true;
        visted['i' - 'a'] = true;
        visted['n' - 'a'] = true;
        visted['t' - 'a'] = true;

        for(int i = 0; i < N; i++){
            words[i] = sc.next().replaceAll("[antic]", "");
        }

        if(K < 5)
            System.out.println("0");
        else if(K == 26)
            System.out.println(N);
        else{
            seleting_count=5;
            answer = countWord();
            for(int i = 0; i < 26; i++) {
                if(visted[i]==false)
                    dfs(i);
            }
            System.out.println(answer);
        }

    }

    static void dfs(int index){
        visted[index] = true;
        seleting_count++;
        if(seleting_count == K){
            answer = Math.max(answer, countWord());
        }else{
            for(int i = index+1; i < 26; i++){
                if(visted[i] == false){
                    dfs(i);
                }
            }
        }
        visted[index] = false;
        seleting_count--;
    }

    static int countWord(){
        int count = 0;
        for (int n = 0; n < N; n++){
            boolean isPossible = true;
            String word = words[n];
            for(int i = 0; i < word.length(); i++){
                if(visted[word.charAt(i) - 'a'] == false) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible)
                count++;
        }

        return count;
    }
}
