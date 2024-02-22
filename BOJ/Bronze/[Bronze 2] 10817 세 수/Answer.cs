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
        
            int[] input = Array.ConvertAll(reader.ReadLine().Split(), int.Parse);
        
            Array.Sort(input); 
        
            writer.WriteLine(input[1]);
        
            writer.Close();
            reader.Close();
        }

    }
}
