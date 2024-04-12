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

            StringBuilder sb;
            List<int> arr;
            while (true)
            {
                int num = int.Parse(reader.ReadLine());
                if (num == -1)
                    break;

                arr = new List<int>();
                sb = new StringBuilder();
                for (int i = 1; i < num; i++)
                {
                    if (num % i == 0)
                    {
                        arr.Add(i);
                        if (i == arr.First())
                        {
                            sb.Append($"{num} = {i}");
                        }
                        else
                        {
                            sb.Append($" + {i}");
                        }
                    }
                }
                int sum = arr.Sum();
                if (sum == num)a
                {
                    Console.WriteLine(sb);
                }
                else
                {
                    Console.WriteLine($"{num} is NOT perfect.");
                }
            }

            writer.Close();
            reader.Close();
        }
    }
}