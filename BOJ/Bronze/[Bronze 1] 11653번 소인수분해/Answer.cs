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

            for (int i = 2; i < N + 1; i++)
            {
                while (N % i == 0)
                {
                    writer.WriteLine(i);
                    N /= i;
                }
            }

            writer.Close();
            reader.Close();
        }
    }
}