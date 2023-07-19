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

            string[] input = reader.ReadLine().Split(' ');
            int N = int.Parse(input[0]);
            int K = int.Parse(input[1]);

            int[] coins = new int[N];
            for (int i = 0; i < N; i++)
            {
                coins[i] = int.Parse(reader.ReadLine());
            }

            int answer = 0;
            for(int i = N-1; i >= 0; i--)
            {
                answer += K / coins[i];
                K = K % coins[i];
            }

            writer.WriteLine(answer);

            writer.Close();
            reader.Close();
        }
    }
}
