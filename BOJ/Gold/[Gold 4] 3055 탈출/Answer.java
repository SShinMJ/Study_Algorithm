import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static final int[] MX = {-1, 1, 0, 0};
    static final int[] MY = {0, 0, -1, 1};

    static int R, C;
    static char[][] map;
    static int[][] dp;
    static Queue<Point> queue;
    static boolean foundAnswer;
    static int answer;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        dp = new int[R][C];
        queue = new LinkedList<>();

        Point sp = null;
        for(int r = 0; r < R; r++){
            String line = sc.next();
            for (int c = 0; c < C; c++){
                map[r][c] = line.charAt(c);
                if(map[r][c] == '*'){
                    queue.add(new Point(r, c, '*'));
                }else if(map[r][c] == 'S'){
                    sp = new Point(r, c, 'S');
                }
            }
        }
        queue.add(sp);

        while (!queue.isEmpty()){
            Point p = queue.poll();
            if(p.type == 'D'){
                foundAnswer = true;
                answer = dp[p.y][p.x];
                break;
            }
            for (int i = 0; i < 4; i++){
                int ty = p.y + MY[i];
                int tx = p.x + MX[i];
                if(ty >= 0 && ty < R && tx >= 0 && tx < C){
                    if(p.type == 'S' || p.type == '.'){
                        if((map[ty][tx] == '.' || map[ty][tx] == 'D') && dp[ty][tx] == 0){
                            dp[ty][tx] = dp[p.y][p.x] + 1;
                            queue.add(new Point(ty, tx, map[ty][tx]));
                        }
                    }else if(p.type == '*'){
                        if(map[ty][tx] == '.' || map[ty][tx] == 'S') {
                            map[ty][tx] = '*';
                            queue.add(new Point(ty, tx, '*'));
                        }
                    }
                }
            }
        }
        if(foundAnswer){
            System.out.println(answer);
        }else
            System.out.println("KAKTUS");

    }
}

class Point {
    int y;
    int x;
    char type;

    public Point(int y, int x, char type){
        this.y = y;
        this.x = x;
        this.type = type;
    }
}
