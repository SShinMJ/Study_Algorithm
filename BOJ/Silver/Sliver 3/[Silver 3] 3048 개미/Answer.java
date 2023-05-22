import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int left, right, T;
    static char[] ant, dir;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        left = Integer.parseInt(st.nextToken());
        right = Integer.parseInt(st.nextToken());

        dir = new char[left+right];
        ant = new char[left+right];

        String str = br.readLine();
        for (int i = 0; i < left; i++) {
            ant[left-i-1] = str.charAt(i);
            dir[i] = 1;
        }

        str = br.readLine();
        for (int j = 0; j < right; j++) {
            ant[left+j] = str.charAt(j);
            dir[left+j] = 2;
        }

        T = Integer.parseInt(br.readLine());
        Move(T);
        for (int i = 0; i < ant.length; i++) {
            System.out.print(ant[i]);
        }
    }

    public static void Move(int t){
        if(t==0) return;
        else {
            for (int i = 0; i < t; i++) {
                for (int j=0; j < left+right-1; j++) {
                    if(dir[j] != 2 && dir[j] != dir[j+1]){
                        char tmp = ant[j];
                        ant[j]=ant[j+1];
                        ant[j+1]=tmp;

                        tmp = dir[j];
                        dir[j]=dir[j+1];
                        dir[j+1]=tmp;
                        j++;
                    }
                }
            }
        }
    }
}