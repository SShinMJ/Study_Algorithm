import java.io.*;
import java.util.*;

public class Main {
    // n번 교환 후 최대상금 (정수 내림차순 만들기)
    // dfs 탐색으로 max 값 저장 후 출력
    public static int[] arr;
    public static int max;
    public static int cnt;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String n = st.nextToken();
            int length = n.length(); // 정수문자열길이
            cnt = Integer.parseInt(st.nextToken()); // 교환횟수
            //시간 단축!! 숫자길이보다 cnt이 크다면 문자열길이만큼만!
            if(cnt>length) {
                cnt = length;
            }

            arr = new int[length];

            for(int i=0;i<length;i++){
                arr[i] = Integer.parseInt(String.valueOf(n.charAt(i)));
            }
            max = 0;
            //dfs 탐색시작
            dfs(0, 0, length); //자리위치 index, 현재바꾼횟수, 총 숫자길이

            sb.append("#").append(test_case).append(" "+ max+"\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int index, int cur, int len){
        if( cur == cnt) { //바꾼 횟수가 주어진 횟수와 같다면
            String s ="";
            for( int i: arr){
                s += Integer.toString(i);
            }
            // 맥스 저장 후 리턴
            max = Math.max(max,Integer.parseInt(s));
            return;
        }

        // 횟수 남았으면 정렬 dfs 계속 진행
        for(int i=index;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                dfs(i, cur+1,len);

                //다음 케이스를 위해 돌려놓기
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
    }
}