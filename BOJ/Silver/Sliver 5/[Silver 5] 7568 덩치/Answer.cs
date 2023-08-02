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

            string[] bodyInfo;
            int[] height = new int[N];
            int[] weight = new int[N];
            for (int i = 0; i < N; i++)
            {
                bodyInfo = reader.ReadLine().Split();
                height[i] = int.Parse(bodyInfo[0]);
                weight[i] = int.Parse(bodyInfo[1]);
            }

          // 부르트포스(완전탐색)
            int cnt = 0;
            for (int i = 0; i < N; i++)
            {
                cnt = 0;
                for (int j = 0; j < N; j++)
                {
                    if (height[i] < height[j] && weight[i] < weight[j])
                    {
                        cnt++;
                    }
                }
               sb.Append((cnt + 1) + " ");
            }

            writer.WriteLine(sb.ToString());

            writer.Close();
            reader.Close();
        }
    }
}
