import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] dwarf = new int[9];
        int diff = -100;
        for(int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            dwarf[i] = Integer.parseInt(st.nextToken());
            diff += dwarf[i];
        }

        int temp;
        int notDwarf1 = 0, notDwarf2 = 0;
        for(int i = 0; i < dwarf.length; i++){
            for (int j = i+1; j < dwarf.length; j++) {
                if(dwarf[i] + dwarf[j] == diff){
                    notDwarf1 = dwarf[i];
                    notDwarf2 = dwarf[j];
                    diff = 0;
                    continue;
                }
                if(dwarf[i] > dwarf[j]){
                    temp = dwarf[i];
                    dwarf[i] = dwarf[j];
                    dwarf[j] = temp;
                }
            }
            if(dwarf[i] != notDwarf1 && dwarf[i] != notDwarf2)
                System.out.println(dwarf[i]);
        }
    }
}