using System;
using System.IO;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static bool[] prime;
        
        static void Main(string[] args)
        {
            StreamWriter writer = new StreamWriter(Console.OpenStandardOutput());
            StreamReader reader = new StreamReader(Console.OpenStandardInput());
            StringBuilder sb = new StringBuilder();

            string[] s = reader.ReadLine().Split();
            int N = int.Parse(s[0]);
            int M = int.Parse(s[1]);

            prime = new bool[M+1];
            prime[0] = prime[1] = true;
            Decimal();

            for(int i = N; i <= M; i++)
            {
                if (!prime[i])
                {
                    sb.Append(i + "\n");
                }
            }

            writer.WriteLine(sb.ToString());

            writer.Close();
            reader.Close();
        }

        static void Decimal()
        {
            // 특정 수의 배수에 해당하는 수를 모두 지운다.
            for (int i = 2; i <= Math.Sqrt(prime.Length); i++)
            {
                if (prime[i])
                {
                    continue;
                }

                // 이미 지워진 숫자가 아니라면, 그 배수부터 출발하여, 가능한 모든 숫자 지우기
                for (int j = i * i; j < prime.Length; j += i)
                {
                    prime[j] = true;
                }
            }
        }
    }
}
