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

            int sum;
            for(int i = 0; i < 3; i++)
            {
                string[] s = reader.ReadLine().Split(' ');
                sum = int.Parse(s[0]) + int.Parse(s[1]) + int.Parse(s[2]) + int.Parse(s[3]);

                if (sum == 0)
                    sb.Append("D\n");
                else if (sum == 3)
                    sb.Append("A\n");
                else if (sum == 2)
                    sb.Append("B\n");
                else if (sum == 1)
                    sb.Append("C\n");
                else if (sum == 4)
                    sb.Append("E\n");
            }

            writer.WriteLine(sb);

            writer.Close();
            reader.Close();
        }
    }
}