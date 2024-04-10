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

            while (true)
            {
                string input = reader.ReadLine();
                if (string.IsNullOrEmpty(input))
                    break;
                writer.WriteLine(input);
            }

            writer.Close();
            reader.Close();
        }
    }
}