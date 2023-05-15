import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int idx = 3;
        for(int i = 1; i < N; i++) {
            idx = idx * 2 - 1;
        }

        System.out.println(idx*idx);
    }
}