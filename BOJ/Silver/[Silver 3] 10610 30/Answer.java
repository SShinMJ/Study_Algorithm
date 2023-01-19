import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int sum = 0;

        //  1) 0을 전부 제외(어차피 맨 오른쪽에 붙이면 되니까)
        //    -> 내림차순 정렬이 필요하지만, 간단하게 오름차순 정렬 후
        //       맨 끝 원소부터 0번 인덱스(첫 번째 원소) 까지 for문 탐색
        //  2) 0을 제외한 남은 숫자들을 전부 더했을 때, 값이 3의 배수인지 확인하기
        //    -> 3의 배수이고, 가장 첫 번째 원소(0번 인덱스) 의 값이 0이면 정답
        //  3) 0을 제외한 남은 숫자들 내림차순 정렬
        //  4) 뒤에 0 제외한 개수만큼 0 붙이기

        // 해당 숫자 재배치 시작
        char[] charArr = N.toCharArray();
        Arrays.sort(charArr);	// 오름차순 정렬
        int len = charArr.length;

        StringBuilder sb = new StringBuilder();
        // 오름차순 정렬이므로, 맨 끝 원소부터 반대로 탐색
        for(int i = len - 1; i >= 0; i--) {
            int num = charArr[i] - '0';
            sum += num;
            sb.append(num);
        }

        // 30의 배수인지 판단하기 위한 조건 생성
        // = 3의 배수, 가장 첫 번째 원소(0번 인덱스) 의 값이 0이라는 조건 불만족 시
        if(charArr[0] != '0' || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        // 위 조건을 만족한다면 정렬한 수가 무조건 가장 큰 30의 배수다.
        System.out.println(sb);
    }

}

// 참고 : https://maivve.tistory.com/289