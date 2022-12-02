import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int[][] trafficLight;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        trafficLight = new int[N+1][3];
        trafficLight[0][0] = 0;
        trafficLight[0][1] = 0;
        trafficLight[0][2] = 0;
        int distance = 0, time = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            trafficLight[i][0] = Integer.parseInt(st.nextToken());
            trafficLight[i][1] = Integer.parseInt(st.nextToken());
            trafficLight[i][2] = Integer.parseInt(st.nextToken());

            distance = trafficLight[i][0];
            time += (trafficLight[i][0] - trafficLight[i-1][0]);
            if(time < trafficLight[i][1])
                time += trafficLight[i][1] - time;
            else {
                int waitTime = (trafficLight[i][1] + trafficLight[i][2]) % time;
                if (trafficLight[i][1] > waitTime) {
                    time += trafficLight[i][1] - waitTime;
                }
            }
        }
        if(distance != L)
            time += L - distance;

        System.out.println(time);
    }
}