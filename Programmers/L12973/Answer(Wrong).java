class Solution
{
    public int solution(String s)
    {

        for(int i = 1; i < s.length(); i++) {
            while(s.charAt(i-1) == s.charAt(i)) {
                s = s.substring(0, i-1) + s.substring(i+1, s.length());
                if(s.length() == 0)
                    return 1;
                if(i > s.length())
                    return 0;
                i = i != 1 ? i - 1 : i;
            }
        }

        return 0;
    }
}