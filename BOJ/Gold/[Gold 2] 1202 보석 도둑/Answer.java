import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static Jewelry[] jewelryList;
    static int bag[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewelryList = new Jewelry[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            jewelryList[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        bag = new int[K];
        for(int i = 0; i < K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);
        Arrays.sort(jewelryList, Comparator.comparingInt(Jewelry::getWeight));
        PriorityQueue<Jewelry> pq =new PriorityQueue<Jewelry>(Comparator.comparingInt(Jewelry::getValue).reversed()); // 가격 내림차순 정렬 힙

        int jIndex = 0;
        long result = 0;
        for (int i = 0; i < bag.length; i++){
            while (jIndex < N && jewelryList[jIndex].weight <= bag[i]){
                pq.add(jewelryList[jIndex++]);
            }
            if(!pq.isEmpty()){
                result += pq.poll().value;
            }
        }
        System.out.println(result);

    }
}

class Jewelry {
    int weight;
    int value;

    public Jewelry(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}
