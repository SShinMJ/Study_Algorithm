import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, R;
    static Nominee[] nominees;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine());

        //학생을 나타내는 번호는 1부터 100까지의 자연수
        nominees = new Nominee[101];
        List<Nominee> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int r = 0; r < R; r++){
            int num = Integer.parseInt(st.nextToken());
            //처음 등록된 학생이라면, 새 객체 생성
            if(nominees[num] == null){
                nominees[num] = new Nominee(num, 0, 0, false);
            }
            //이미 액자에 등록된 후보라면 추천 수(count)만 +1
            if(nominees[num].isIn == true){
                nominees[num].count++;
            } else { // 액자에 없는 후보라면
                // 이미 액자가 다 차있다면
                if(list.size() == N){
                    //정렬하여
                    Collections.sort(list);
                    // 가장 추천 수가 작거나, 추천 수가 같다면 등록 시간이 오래된 후보를 제외한다.
                    list.get(0).isIn = false;
                    Nominee nominee = list.remove(0);
                }
                //그 후 새 후보를 추가한다.
                nominees[num].count = 1;
                nominees[num].isIn = true;
                nominees[num].timeStamp = r;  // r번째로 등록됨을 기록.
                list.add(nominees[num]);
            }
        }

        //비교 정렬 메소드 사용.
        Collections.sort(list, new Comparator<Nominee>() {
            @Override
            public int compare(Nominee o1, Nominee o2) {
                return Integer.compare(o1.num, o2.num);
            }
        });

        for(int n=0; n < list.size(); n++){
            if(n == N-1)
                System.out.print(list.get(n).num);
            else
                System.out.print(list.get(n).num + " ");
        }
    }
}

class Nominee implements Comparable<Nominee>{
    int num;        //학생 번호
    int count;      //추천 받은 수
    int timeStamp;  //액자에 등록된 시간
    boolean isIn;   //액자 등록 여부

    public Nominee(int num, int count, int timeStamp, boolean isIn) {
        this.num = num;
        this.count = count;
        this.timeStamp = timeStamp;
        this.isIn = isIn;
    }

    @Override
    public int compareTo(Nominee o) {
        //추천 수를 기준으로 비교
        int comp = Integer.compare(count, o.count);
        //추천 수가 같다면
        if(comp == 0){
            //등록된 시간이 더 오래된 것을 기준으로 비교
            return Integer.compare(timeStamp, o.timeStamp);
        } else {
            return comp;
        }
    }
}
