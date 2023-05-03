import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] numsSort = nums.clone();
        Arrays.sort(numsSort);
        Map<Integer, Integer> numsMap = new HashMap();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if(!numsMap.containsKey(numsSort[i])) {
                numsMap.put(numsSort[i], count);
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(numsMap.get(nums[i]) + " ");
        }

        System.out.println(sb);
    }
}