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

            int N = int.Parse(reader.ReadLine());

            for (int i = 1; i <= N; i++)
            {
                for (int j = 0; j < N - i; j++)
                    sb.Append(" ");
                for (int j = 0; j < (i - 1) * 2 + 1; j++)
                    sb.Append("*");
                sb.Append("\n");
            }
            for (int i = N - 1; i >= 1; i--)
            {
                for (int j = 0; j < N - i; j++)
                    sb.Append(" ");
                for (int j = 0; j < (i - 1) * 2 + 1; j++)
                    sb.Append("*");
                sb.Append("\n");
            }

            writer.WriteLine(sb);

            writer.Close();
            reader.Close();
        }
    }
}