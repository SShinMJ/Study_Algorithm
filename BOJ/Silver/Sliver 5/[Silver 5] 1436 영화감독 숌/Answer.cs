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

            int N = int.Parse(reader.ReadLine());

            int numCnt = 665;
            int ansCnt = 0;
            while(N != ansCnt)
            {
                numCnt++;
                if (numCnt.ToString().Contains("666"))
                {
                    ansCnt++;
                }
            }

            writer.WriteLine(numCnt);

            writer.Close();
            reader.Close();
        }
    }
}
