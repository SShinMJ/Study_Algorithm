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

            int answer = 1;
            for(int i = 2; i < N; i++)
            {
                answer *= i;
            }

            writer.WriteLine(answer);

            writer.Close();
            reader.Close();
        }
    }
}
