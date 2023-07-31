using System;
using System.Collections.Generic;
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

            string[] s;
            Stack<int> stack = new Stack<int>();
            for(int i = 0; i < N; i++)
            {
                s = reader.ReadLine().Split();

                if (s[0].Equals("push"))
                {
                    stack.Push(int.Parse(s[1]));
                }
                else if (s[0].Equals("pop"))
                {
                    if (stack.Count != 0)
                        sb.Append(stack.Pop() + "\n");
                    else
                        sb.Append("-1\n");
                }
                else if (s[0].Equals("size"))
                {
                    sb.Append(stack.Count + "\n");
                }
                else if (s[0].Equals("empty"))
                {
                    if (stack.Count != 0)
                        sb.Append("0\n");
                    else
                        sb.Append("1\n");
                }
                else if (s[0].Equals("top"))
                {
                    if (stack.Count != 0)
                        sb.Append(stack.Peek() + "\n");
                    else
                        sb.Append("-1\n");
                }
                else
                {
                    sb.Append("Input Error");
                    break;
                }
            }


            writer.WriteLine(sb.ToString());

            writer.Close();
            reader.Close();
        }
    }
}
