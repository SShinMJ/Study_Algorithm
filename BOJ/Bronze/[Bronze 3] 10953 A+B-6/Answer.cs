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

            int T = int.Parse(reader.ReadLine());

            while(T-- > 0)
            {
                string[] s = reader.ReadLine().Split(',');
                int n = int.Parse(s[0]);
                int m = int.Parse(s[1]);

                sb.Append(n+m + "\n");
            }

            writer.WriteLine(sb);

            writer.Close();
            reader.Close();
        }
    }
}