import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nums;
    static boolean visited[];
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        visited = new boolean [N];
        sb = new StringBuilder();
        selectSequence(M, "", 0);

        // 서로 다른 String의 가지수는 HashSet 등을 사용하면 쉽게 파악할 수 있다.
        System.out.println(sb);
    }

    public static void selectSequence(int remain, String sequence, int frontNum) {
        // 수열의 길이가 M이라면
        if(remain == 0) {
            // 줄을 띄우고 리턴
            sb.append(sequence + "\n");
            return;
        }

        int beforeNum = 0;
        for(int i = 0; i < N; i++) {
            // 아직 뽑지 않았으며, 이전 수열 가장 뒷자리가 같지 않고,
            // 앞의 수보다 클 경우에만.
            if(!visited[i] && beforeNum != nums[i] && frontNum <= nums[i]) {
                // 한 장을 뽑고
                visited[i] = true;
                // 중복을 막기 위해 저장.
                beforeNum = nums[i];
                // 그 다음 번호부터 하나씩 뽑는다
                selectSequence(remain-1, sequence + nums[i] + " ", nums[i]);

                // 그 카드를 나중에 뽑기 위해해
                // 상위 함수로 돌아가서 뽑은 흔적을 지워준다
                visited[i] = false;
            }
        }

    }
}