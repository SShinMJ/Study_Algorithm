import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] stalagmite = new int[H+1];
        int[] stalactites = new int[H+1];
        int destroyBlocks;
        for (int i = 1; i < N+1; i++) {
            destroyBlocks = Integer.parseInt(br.readLine());
            // 석순(아래)
            if(i % 2 != 0) {
                stalagmite[destroyBlocks]++;
            }
            // 종유석(위)
            else {
                stalactites[destroyBlocks]++;
            }
        }

        // 누적합.
        // 높이가 낮아질 수록 겹치는 부분이 많아지므로
        // 아래층의 장애물 수는 윗층 높이를 지나는 장애물 수에
        // 아래층 높이의 장애물 수를 더한 값이다.
        for(int i = H-1; i > 0; i--){
            stalagmite[i] += stalagmite[i+1];
            stalactites[i] += stalactites[i+1];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 1; i < H+1; i++){
            int brake = stalagmite[i] + stalactites[H-i+1];
            if(brake < min) {
                min = brake;
                count = 1;
            } else if(brake == min)
                count++;

        }

        System.out.println(min + " " + count);
    }
}