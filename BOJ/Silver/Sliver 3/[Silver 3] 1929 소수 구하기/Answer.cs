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
            StringBuilder sb = new StringBuilder();

            string[] s = reader.ReadLine().Split();
            int N = int.Parse(s[0]);
            int M = int.Parse(s[1]);

            for(int i = N; i <= M; i++)
            {
                if (Decimal(i))
                {
                    sb.Append(i + "\n");
                }
            }

            writer.WriteLine(sb.ToString());

            writer.Close();
            reader.Close();
        }

        static bool Decimal(int num)
        {
            for(int i = 2; i <= Math.Sqrt(num); i++)
            {
                if (num % i == 0)
                    return false;
            }

            return true;
        }
    }
}
