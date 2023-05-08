class Solution {
    public String solution(String s) {
        String[] strArr = s.split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < strArr.length; i++) {
            min = Math.min(min, Integer.parseInt(strArr[i]));
            max = Math.max(max, Integer.parseInt(strArr[i]));
        }

        return(min + " " + max);
    }
}