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

            int[] stairs = new int[N+1];
            for (int i = 1; i <= N; i++)
            {
                stairs[i] = int.Parse(reader.ReadLine());
            }

            int[] dp = new int[N+1];
            dp[0] = 0;
            dp[1] = stairs[1];
            if(N > 1)
            {
                dp[2] = dp[1] + stairs[2];
                for (int i = 3; i < N + 1; i++)
                    dp[i] = Math.Max(dp[i - 2], (dp[i - 3] + stairs[i - 1])) + stairs[i];
            }

            writer.WriteLine(dp[N]);

            writer.Close();
            reader.Close();
        }
    }
}
