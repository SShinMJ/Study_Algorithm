import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean isUpper = false;
        int[] nums = new int[8];
        nums[0] = Integer.parseInt(st.nextToken());
        if(nums[0] == 1)
            isUpper = true;
        else if(nums[0] != 8) {
            System.out.println("mixed");
            return;
        }

        for(int i = 1; i < 8; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if(isUpper) {
                if(nums[i] - nums[i-1] != 1) {
                    System.out.println("mixed");
                    return;
                }
            } else {
                if(nums[i-1] - nums[i] != 1) {
                    System.out.println("mixed");
                    return;
                }
            }
        }


        if(isUpper) {
            System.out.println("ascending");
        } else {
            System.out.println("descending");
        }
    }
}