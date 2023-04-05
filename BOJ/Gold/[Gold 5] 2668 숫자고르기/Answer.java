import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static boolean[] selected;
    static boolean[] checked;
    static List<Integer> answerList;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N+1];
        selected = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        answerList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            checked = new boolean[N+1];
            if(!selected[i]) {
                if(simulation(i, i)) {
                    check(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count + "\n");
        answerList.sort(Comparator.naturalOrder());
        for (int i = 0; i < answerList.size(); i++) {
            sb.append(answerList.get(i) + "\n");
        }

        System.out.println(sb);
    }

    public static boolean simulation(int idx, int num) {
        checked[idx] = true;
        if(nums[idx] == num) {
            return true;
        }

        if(idx == nums[idx]) {
            check(idx);
            return false;
        }

        if(!selected[nums[idx]] && !checked[nums[idx]]) {
            if(simulation(nums[idx], num)) {
                check(nums[idx]);
                return true;
            }
        }

        return false;
    }

    public static void check(int idx) {
        selected[idx] = true;
        answerList.add(idx);
        count++;
    }
}