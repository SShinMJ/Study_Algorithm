using System;
using System.IO;

namespace BOJ
{
    internal class Program
    {
      static void Main(string[] args)
        {
            StreamWriter writer = new StreamWriter(Console.OpenStandardOutput());
            StreamReader reader = new StreamReader(Console.OpenStandardInput());

            int N = int.Parse(reader.ReadLine());

            if(N < 100)
            {
                Console.WriteLine(N);
                return;
            }

            int first, second, third;
            int answer = 99;
            for(int i = 100; i <= N; i++)
            {
                first = i / 100;
                second = i / 10 % 10;
                third = i % 10;

                if (first - second == second - third)
                    answer++;
            }

            System.Console.WriteLine(answer);
        }
    }
}
