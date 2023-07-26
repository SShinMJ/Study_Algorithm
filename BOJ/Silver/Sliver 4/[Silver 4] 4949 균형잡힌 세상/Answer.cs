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

            String s;

            while (true)
            {
                s = reader.ReadLine();

                if (s.Equals("."))
                {
                    break;
                }

                sb.Append(Solve(s)).Append('\n');
            }

            writer.WriteLine(sb.ToString());

            writer.Close();
            reader.Close();
        }

        public static String Solve(String s)
        {
            Stack<Char> stack = new Stack<Char>();
            char[] word;
            char c;

            for (int i = 0; i < s.Length; i++)
            {
                word = s.ToCharArray();

                for (int j = 0; j < word.Length; j++)
                {
                    c = word[j];


                    if (c == '(' || c == '[')
                    {
                        stack.Push(c);
                    }

                    else if (c == ')')
                    {
                        if (stack.Count == 0 || stack.Peek() != '(')
                        {
                            return "no";
                        }
                        else
                        {
                            stack.Pop();
                        }
                    }

                    else if (c == ']')
                    {
                        if (stack.Count == 0 || stack.Peek() != '[')
                        {
                            return "no";
                        }
                        else
                        {
                            stack.Pop();
                        }
                    }
                }
            }

            if (stack.Count == 0)
            {
                return "yes";
            }
            else
            {
                return "no";
            }
        }
    }
}
