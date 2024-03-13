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

            int[,] grid = new int[9, 9];

            for (int i = 0; i < 9; i++)
            {
                string[] s = reader.ReadLine().Split();
                for (int j = 0; j < 9; j++)
                {
                    grid[i, j] = int.Parse(s[j]);
                }
            }

            int max = int.MinValue;
            int maxRow = 0;
            int maxCol = 0;

            for (int i = 0; i < 9; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    if (grid[i, j] > max)
                    {
                        max = grid[i, j];
                        maxRow = i + 1;
                        maxCol = j + 1;
                    }
                }
            }

            writer.WriteLine(max + "\n" + maxRow + " " + maxCol);

            writer.Close();
            reader.Close();
        }
    }
}