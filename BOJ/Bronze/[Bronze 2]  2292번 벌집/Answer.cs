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

            int answer = 1;
            int current = 1;
            int multiCnt = 0;
            while (true)
            {
                if (N == 1)
                    break;
                
                if(N > current && N <= current + 6*multiCnt)
                    break;
                else
                {
                    current = current + 6 * multiCnt;
                    multiCnt++;
                    answer++;
                }
            }

            writer.WriteLine(answer);

            writer.Close();
            reader.Close();
        }
    }
}
