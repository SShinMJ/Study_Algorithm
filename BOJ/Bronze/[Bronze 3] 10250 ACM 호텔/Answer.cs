using System;
using System.IO;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            StreamReader reader = new StreamReader(Console.OpenStandardInput());
            StringBuilder sb = new StringBuilder();

            int T = int.Parse(reader.ReadLine());

            int H, W, N;
            int h, w;
            string[] input;
            for (int i = 0; i < T; i++)
            {
                input = reader.ReadLine().Split();
                H = int.Parse(input[0]);
                W = int.Parse(input[1]);
                N = int.Parse(input[2]);

                h = N % H;
                w = N / H + 1;

                if(h == 0)
                {
                    h = H;
                    w--;
                }

                if (w < 10)
                    sb.Append(h + "0" + w + "\n");
                else
                    sb.Append(h + "" + w + "\n");
            }

            Console.WriteLine(sb);

            reader.Close();
        }
    }
}