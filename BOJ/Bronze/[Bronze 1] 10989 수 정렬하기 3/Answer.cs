using System;
using System.IO

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            StreamWriter writer = new StreamWriter(Console.OpenStandardOutput());
            StreamReader reader = new StreamReader(Console.OpenStandardInput());
            StringBuilder sb = new StringBuilder();

            int count = int.Parse(reader.ReadLine());
            int[] list = new int[count];
 
            for (int i = 0; i < count; i++)
            {
                list[int.Parse(reader.ReadLine())]++;
            }
            for (int i = 0; i <= 10000; i++)
            {
                if (list[i] != 0)
                {
                    for (int j = 0; j < list[i]; j++)
                    {
                        sb.Append(i + "\n");
                    }
                }
            }
        
            writer.WriteLine(sb);
        
            writer.Close();
            reader.Close();
        }
    }
}
