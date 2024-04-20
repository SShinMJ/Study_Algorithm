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

            int avg = 0;
            int[] arrNum = new int[5];
            for(int i = 0; i < 5; i++)
            {
                arrNum[i] = int.Parse(reader.ReadLine());
                avg += arrNum[i];
            }

            Array.Sort(arrNum);

            writer.Write(avg/5 + "\n" + arrNum[2]);

            writer.Close();
            reader.Close();
        }
    }
}