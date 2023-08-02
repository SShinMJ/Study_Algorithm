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

            string[] lanLine = reader.ReadLine().Split();
            int K = int.Parse(lanLine[0]);
            int N = int.Parse(lanLine[1]);

            int[] lines = new int[K];
            int standard = 0;
            for(int i = 0; i < K; i++)
            {
                lines[i] = int.Parse(reader.ReadLine());
                standard += lines[i];
            }
            standard /= N;

            int count;
            int maxLine = 0;
            while(true)
            {
                count = 0;
                for(int i = 0; i < K; i++)
                {
                    count += (lines[i] / standard);
                }

                Console.WriteLine(standard + ", " + count + ", " + maxLine);

                if (count == N)
                {
                    if (maxLine < standard)
                        maxLine = standard;
                    else
                        break;
                }

                if (count >= N)
                    standard = standard * 2;
                else
                    standard = standard / 2 - 1;
            }

            writer.WriteLine(maxLine);

            writer.Close();
            reader.Close();
        }
    }
}
