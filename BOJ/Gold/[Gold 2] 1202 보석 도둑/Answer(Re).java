import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static Jewelry[] jewelryList;
    static int bag[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        jewelryList = new Jewelry[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            jewelryList[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        bag = new int[K];
        for(int i = 0; i < K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        // 가방 무게 정렬
        Arrays.sort(bag);
        // 무게를 기준으로 오름차순으로 정렬
        Arrays.sort(jewelryList, Comparator.comparingInt(Jewelry::getWeight));

        // 가격 내림차순 정렬 힙(우선순위 큐)
        PriorityQueue<Jewelry> pq =new PriorityQueue(Comparator.comparingInt(Jewelry::getValue).reversed());

        int jIndex = 0;
        long result = 0;
        for (int i = 0; i < bag.length; i++){
            // jewelryList가 무게가 작은순으로 정렬되어 있으므로,
            // 현재 순서의 가방 무게보다 작다면 우선 순위 큐에 넣는다.
            while (jIndex < N && jewelryList[jIndex].weight <= bag[i]){
                // 이 때, 우선순위 큐에 들어간 Jewelry 객체는
                // 가치(가격)이 큰순으로 정렬된다.
                pq.add(jewelryList[jIndex++]);
            }
            // 따라서 큐에 담긴 Jewelry 객체가 있을 경우
            if(!pq.isEmpty()){
                // 가치(가격)이 가장 큰 값을 답변수에 담는다.
                result += pq.poll().value;
                // 가방은 크기가 작은 순으로 정렬되어 있으므로,
                // 다음 순서의 가방도 큐에 담긴 Jewelry 객체를 반드시 담을 수 있다.
                // 따라서 다음 순서의 가방에만 담길 수 있던 새 Jewelry 객체가 큐에 들어오고
                // 가치 순으로 정렬되어 있게 되므로 또 다시 큐에 가장 앞에 있는 값을 답에 더하면 된다.
            }
        }
        System.out.println(result);
    }

    static class Jewelry {
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
}