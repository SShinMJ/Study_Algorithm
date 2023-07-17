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

            char[] data;
            int check;
            for (int i = 0; i < N; i++)
            {
                check = 0;
                data = reader.ReadLine().ToCharArray();
                for (int j = 0; j < data.Length; j++)
                {
                    if (data[j] == '(')
                    {
                        check++;
                    }
                    else if (data[j] == ')')
                    {
                        check--;
                        if (check < 0)
                        {
                            break;
                        }
                    }
                }
                if(check == 0)
                {
                    sb.Append("YES\n");
                }
                else
                {
                    sb.Append("NO\n");
                }
            }

            writer.WriteLine(sb.ToString());

            writer.Close();
            reader.Close();
        }
    }
}
