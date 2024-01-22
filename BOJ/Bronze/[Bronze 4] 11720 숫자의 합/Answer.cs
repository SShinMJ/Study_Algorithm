using System;
using System.IO;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            StreamReader reader = new StreamReader(Console.OpenStandardInput());

            int N = int.Parse(reader.ReadLine());

            int sum = 0;
            string numString = reader.ReadLine();
            for (int i = 0; i < N; i++)
            {
                sum += int.Parse(numString[i].ToString());
            }

            Console.WriteLine(sum);

            reader.Close();
        }
    }
}