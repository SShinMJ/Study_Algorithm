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
            StringBuilder sb = new StringBuilder();

            int N = int.Parse(reader.ReadLine());
            
            LinkedList<int> list = new LinkedList<int>();
            string[] input;
            string command;
            int num;
            for (int i = 0; i < N; i++)
            {
                input = reader.ReadLine().Split();
                command = input[0];

                if (command.Equals("push_front"))
                {
                    num = int.Parse(input[1]);
                    list.AddFirst(num);
                }
                else if (command.Equals("push_back"))
                {
                    num = int.Parse(input[1]);
                    list.AddLast(num);
                }
                else if (command.Equals("pop_front"))
                {
                    if (list.Count != 0)
                    {
                        sb.Append(list.First.Value + "\n");
                        list.RemoveFirst();
                    }
                    else
                        sb.Append("-1" + "\n");
                }
                else if (command.Equals("pop_back"))
                {
                    if (list.Count != 0)
                    {
                        sb.Append(list.Last.Value + "\n");
                        list.RemoveLast();
                    }
                    else
                        sb.Append("-1" + "\n");
                }
                else if (command.Equals("size"))
                {
                    sb.Append(list.Count() + "\n");
                }
                else if (command.Equals("empty"))
                {
                    if(list.Count() == 0)
                        sb.Append("1" + "\n");
                    else
                        sb.Append("0" + "\n");
                }
                else if (command.Equals("front"))
                {
                    if (list.Count != 0)
                        sb.Append(list.First.Value + "\n");
                    else
                        sb.Append("-1" + "\n");
                }
                else if (command.Equals("back"))
                {
                    if (list.Count != 0)
                        sb.Append(list.Last.Value + "\n");
                    else
                        sb.Append("-1" + "\n");
                }
                else
                {
                    sb.Append("Command Error" + "\n");
                }
            }
            

            writer.WriteLine(sb);

            writer.Close();
            reader.Close();
        }
    }
}