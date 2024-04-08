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

            int[] input = Array.ConvertAll(Console.ReadLine().Split(' '), int.Parse);

            int x = input[0];
            int y = input[1];
            int w = input[2];
            int h = input[3];

            int[] NumArray = new int[] { x, y, w - x, h - y };

            int Min = NumArray[0];

            for (int i = 1; i < NumArray.Length; i++)
            {
                if (Min > NumArray[i])
                    Min = NumArray[i];
            }

            writer.WriteLine(Min);

            writer.Close();
            reader.Close();
        }
    }
}