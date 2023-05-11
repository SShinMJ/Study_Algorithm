class Solution {
    static int answer = 0;
    static int[][] dungeonList;
    static boolean[] checked;

    public int solution(int k, int[][] dungeons) {
        dungeonList = dungeons;
        checked = new boolean[dungeons.length];

        dfs(k, 0);

        return answer;
    }

    public static void dfs(int k, int count) {
        for(int i = 0; i < dungeonList.length; i++) {
            if(!checked[i] && k >= dungeonList[i][0]) {
                checked[i] = true;
                dfs(k - dungeonList[i][1], count+1);
                checked[i] = false;
            }
        }

        answer = Math.max(answer, count);
    }
}