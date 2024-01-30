using System;
using System.IO;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int input = int.Parse(Console.ReadLine());
            bool check = false;

            for(int i = 0; i < input; i++)
            {
                int buff = i;
                int answer = i;

                while(buff > 0)
                {
                    answer += buff % 10;
                    buff /= 10;
                }

                if(answer == input)
                {
                    Console.WriteLine(i);
                    check = true;
                    break;
                }
            }
            
            if(!check)
            {
                Console.WriteLine("0");
            }
        }
    }
}
