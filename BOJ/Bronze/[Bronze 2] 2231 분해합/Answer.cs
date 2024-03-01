using System;
using System.IO;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            StreamWriter writer = new StreamWriter(Console.OpenStandardOutput());
            StreamReader reader = new StreamReader(Console.OpenStandardInput());

            int N = int.Parse(reader.ReadLine());

            int sum = 0;
            for (int i = 1; i <= N; i++)
            {
                if (i == N)
                {
                    writer.WriteLine(0);
                }

                if (DecompositionSum(i) == N)
                {
                    writer.WriteLine(i);
                    break;
                }
            }

            writer.Close();
            reader.Close();
        }

        static int DecompositionSum(int num)
        {
            int sum = num;
            while (num > 0)
            {
                sum += num % 10;
                num /= 10;
            }

            return sum;
        }
    }
}