using System;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {            
            int t = int.Parse(ReadLine());
            int combo = 0;
            int score = 0;
            
            for (int i = 0; i < t; i++)
            {
                string s = ReadLine();

                for (int j = 0; j < s.Length; j++)
                {
                    // 만약 해당 글자가 O라면,
                    if (s[j] == 'O')
                    {
                        // 콤보를 증가시킴
                        ++combo;
                        // 스코어에 콤보를 더해줌.
                        score += combo;
                    }
                    else
                    {
                        // 콤보를 0으로 만든다.
                        combo = 0;
                    }
                }
                
                Console.WriteLine(score);
                
                // 다음번 반복을 위해서 콤보와 스코어를 0으로 바꿔줌
                combo = 0;
                score = 0;
        }
    }
}
