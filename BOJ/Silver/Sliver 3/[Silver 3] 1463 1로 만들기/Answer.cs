using System;
using System.IO;

namespace BOJ
{
    internal class Program
    {
        static int N;
        static int[] dp;

        static void Main(string[] args)
        {
            StreamWriter writer = new StreamWriter(Console.OpenStandardOutput());
            StreamReader reader = new StreamReader(Console.OpenStandardInput());

            N = int.Parse(reader.ReadLine());

            dp = new int[N+1];
            dp[0] = dp[1] = 0;;

            writer.WriteLine(DP(N));

            writer.Close();
            reader.Close();
        }

        public static int DP(int n)
        {
            if(n > 1 && dp[n] == 0)
            {
                if( n % 6 == 0 )
                {
                    dp[n] = Math.Min(DP(n - 1), (Math.Min(DP(n / 3), DP(n / 2)))) + 1;
                }
                else if(n % 3 == 0 )
                {
                    dp[n] = Math.Min(DP(n-1), DP(n/3)) + 1;
                }
                else if (n % 2 == 0)
                {
                    dp[n] = Math.Min(DP(n - 1), DP(n / 2)) + 1;
                }
                else
                {
                    dp[n] = DP(n - 1) + 1;
                }
            }

            return dp[n];
        }
    }
}
