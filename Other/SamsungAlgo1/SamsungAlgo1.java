import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SamsungAlgo1 {
    static int N, M, D;
    static int grass[], oilCount[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int roop = Integer.parseInt(br.readLine());
        for(int i=0; i < roop; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            int count = 0;
            grass = new int[N*M];
            for(int j=1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=1; k <= M; k++) {
                    grass[count] = Integer.parseInt(st.nextToken());
                    count++;
                }
            }

            oilCount = new int[D];
            st = new StringTokenizer(br.readLine());
            for(int l=0; l<=D-1; l++){
                oilCount[l] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            int day = 1;
            int k = 0;
            int pin = 0;
            Arrays.sort(grass);
            for(int m=0; m<oilCount.length; m++){
                for(int j=0; j<N*M; j++){
                    grass[j] += 1;
                }
                pin += k;
                if(N*M >= pin+oilCount[m]){
                    int roop_start = N*M-pin;
                    k = oilCount[m];
                    for(int n=1; n<=k; n++){
                        answer += day * (grass[roop_start-n]-1);
                        grass[roop_start-n] = 1;
                    }
                } else {
                    int roop_before = N*M-pin;
                    int roop_after = N*M-oilCount[m]+roop_before-1;
                    k = oilCount[m];
                    for(int j=roop_before-1; j>=0; j--){
                        answer += day * (grass[j]-1);
                        grass[j] = 1;
                    }
                    for(int j=N*M-1; j>roop_after; j--){
                        pin = -roop_before;
                        answer += day * (grass[j]-1);
                        grass[j] = 1;
                    }
                }
                day++;
            }
            sb.append("#" + (i+1) + " " + answer).append("\n");
        }

        bw.write(sb.toString() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
