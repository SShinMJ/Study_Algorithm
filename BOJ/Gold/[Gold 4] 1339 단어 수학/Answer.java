import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 그리디 알고리즘
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String word;
        int[] alphabet = new int[26];
        for (int i = 0; i < N; i++) {
            word = br.readLine();
            int count = 1;
            for (int j = word.length()-1; j >= 0; j--) {
                // 알파벳 문자열을 자릿 수 대로 10의 자리를 곱하여 저장한다.
                // 나온 값을 26개의 int형 배열을 생성하여 넣어준다.
                alphabet[word.charAt(j) - 'A'] += count;
                count *= 10;
            }
        }

        // 정렬
        Arrays.sort(alphabet);

        int answer = 0;
        int mulitplyNum = 9;
        // 가장 자릿수가 높은 알파벳이 뒤에 있으므로 뒤에서부터 9~0을 곱해준다.
        for (int i = alphabet.length-1; i >= 0; i--) {
            if(alphabet[i] != 0) {
                answer += alphabet[i] * mulitplyNum;
                mulitplyNum--;
            }
        }

        System.out.println(answer);
    }

    // 추가설명
    // GCF는 총 3자리이다. 따라서 100부터 시작한다.
    //100G, 10C, 1F
    //
    //ACDEB는 총 5자리이다. 따라서 10000부터 시작한다.
    //10000A, 1000C, 100D, 10E, 1B
    //
    //GCF의 값과 ACDEB의 값을 더해보자.
    //10000A, 1B, 1010C, 100D, 10E, 1F, 100G 이 나오게 된다.
}