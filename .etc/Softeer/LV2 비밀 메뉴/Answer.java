import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] secretTicket = new int[M];
        for(int i = 0; i < M; i++) {
            secretTicket[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] input = new int[N];
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            if(input[i] == secretTicket[0] && i < N-M+1) {
                for(int j = 1; j < M; j++) {
                    if(input[i+j] != secretTicket[j])
                        break;
                    if(j == M-1) {
                        System.out.println("secret");
                        return;
                    }
                }
            }
        }

        System.out.println("normal");
        return;
    }
}