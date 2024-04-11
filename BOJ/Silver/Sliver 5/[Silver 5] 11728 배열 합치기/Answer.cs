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

            string[] input = reader.ReadLine().Split(' ');
            int sizeA = int.Parse(input[0]);
            int sizeB = int.Parse(input[1]);

            input = reader.ReadLine().Split(' ');
            int[] arrA = new int[sizeA];
            for(int i = 0; i < sizeA; i++)
            {
                arrA[i] = int.Parse(input[i]);
            }

            input = reader.ReadLine().Split(' ');
            int[] arrb = new int[sizeB];
            for (int i = 0; i < sizeB; i++)
            {
                arrb[i] = int.Parse(input[i]);
            }


            int cntA = 0, cntB = 0;
            while (cntA < sizeA || cntB < sizeB)
            {
                if (cntA >= sizeA)
                {
                    sb.Append(arrb[cntB] + " ");
                    cntB++;
                }
                else if (cntB >= sizeB)
                {
                    sb.Append(arrA[cntA] + " ");
                    cntA++;
                }
                else if (arrA[cntA] <= arrb[cntB])
                {
                    sb.Append(arrA[cntA] + " ");
                    cntA++;
                }
                else if (arrA[cntA] > arrb[cntB])
                {
                    sb.Append(arrb[cntB] + " ");
                    cntB++;
                }
            }

            writer.WriteLine(sb);

            writer.Close();
            reader.Close();
        }
    }
}