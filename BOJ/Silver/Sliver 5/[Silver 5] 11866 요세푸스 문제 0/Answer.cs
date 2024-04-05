using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
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
            sb.Append("<");

            string[] input = reader.ReadLine().Split(' ');
            int num = int.Parse(input[0]);
            int distance = int.Parse(input[1]);
            Queue<int> solders = new Queue<int>(Enumerable.Range(1, num));
            int count = 0;

            while(solders.Count > 1)
            {
                count++;
                if(count == distance)
                {
                    sb.Append(string.Format("{0}, ", solders.Dequeue()));
                    count = 0;
                }
                else
                {
                    solders.Enqueue(solders.Dequeue());

                }
            }
            sb.Append(string.Format("{0}>", solders.Dequeue()));

            writer.WriteLine(sb);

            writer.Close();
            reader.Close();
        }
    }
}