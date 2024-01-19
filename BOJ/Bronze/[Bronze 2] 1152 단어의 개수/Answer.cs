using System;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {            
            int answer = 0;
            
            // 입력된 문자의 앞뒤에 공백이 있을 수 있으니 공백을 제거한다.
            string s = Console.ReadLine().Trim();
            
            for (int i = 0; i < s.Length; i++)
            {
                // 공백이 존재한다면
                if (s[i] == ' ')
                    answer++;
            }

            // 만약 입력된 문자가 없다면 0을 출력
            if (s.Length == 0)
                Console.WriteLine(0);
            // 입력된 문자가 존재했다면, answer에 +1을 더해준다.
            // '띄어쓰기 개수 + 1' = '단어의 개수'이므로.
            else
                Console.WriteLine(answer+1);
        }
    }
}
