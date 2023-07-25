using System;
using System.Collections.Generic;
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

            Stack<int> queue = new Stack<int>();
            int num;
            for(int i = 0; i < N; i++)
            {
                num = int.Parse(reader.ReadLine());
                if (num != 0)
                {
                    queue.Push(num);
                }
                else
                {
                    queue.Pop();
                }
            }

            int answer = 0;
            foreach(int i in queue)
            {
                answer += i;
            }

            writer.WriteLine(answer);

            writer.Close();
            reader.Close();
        }
    }
}
