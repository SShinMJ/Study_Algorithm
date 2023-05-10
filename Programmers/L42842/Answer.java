class Solution {
    public int[] solution(int brown, int yellow) {
        int width = yellow+2, height = 3;

        for(int i = 1; i <= yellow/2; i++) {
            if(yellow % i != 0)
                continue;
            if(brown == ((yellow/i*2) + (i+2)*2)) {
                width = Math.max(yellow/i+2, i+2);
                height = Math.min(yellow/i+2, i+2);
            }
        }

        return new int[]{width, height};
    }
}