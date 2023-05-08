class Solution{
    int[][] pane;
    int dx[] = {0, 1, 0, -1};
    int dy[] = {1, 0, -1, 0};
    boolean inRange(int i, int j, int n){
        return 0 <= i && i < n && 0 <= j && j < n;
    }
    public int solution(int n){
        pane = new int[n][n];
        int ci = 0;
        int cj = 0;
        int num = 1;
        //n*n 이차원 배열에 소용돌이 수 규칙대로 값 넣기
        while(inRange(ci, cj, n) && pㅁane[ci][cj] == 0){
            //x>y / y>x로 방향을 바꾸어 값 넣기
            for(int k = 0; k < 4; k++){
                if(!inRange(ci, cj, n) || pane[ci][cj] != 0) break;
                //x>y>x>y 순으로 돌기
                while(true){
                    //1씩 더하며 저장
                    pane[ci][cj] = num++;
                    int ni = ci + dy[k];
                    int nj = cj + dx[k];
                    //x/y 축이 다 채워졌으면 더 가지 않고 그 자리에서 다른 방향으로 이동.
                    //바깥 테두리 한바퀴를 돌았으면 안쪽 테두리 돌기
                    if(!inRange(ni, nj, n) || pane[ni][nj] != 0){
                        ci += dy[(k + 1) % 4];
                        cj += dx[(k + 1) % 4];
                        break;
                    }
                    ci = ni;
                    cj = nj;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) ans += pane[i][i];
        return ans;
    }
}
