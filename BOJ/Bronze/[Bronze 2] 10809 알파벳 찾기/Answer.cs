using System;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {            
            // 아스키 코드 알파벳 소문자 : 97 ~122
            string s = Console.ReadLine();
            for (int i = 97; i < 123; i++)
            {
                if (s.Contains(Convert.ToChar(i)))
                {
                    Console.Write(s.IndexOf(Convert.ToChar(i)));
                    Console.Write(" ");
                }
                else
                {
                    Console.Write("-1");
                    Console.Write(" ");
                }
            }
        }
    }
}
