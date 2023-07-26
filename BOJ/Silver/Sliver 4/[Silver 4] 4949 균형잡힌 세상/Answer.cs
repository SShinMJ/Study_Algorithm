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

            string[] sentence = reader.ReadLine().Split();
            char[] word;
            char c;
            bool check;
            Stack<char> stack;
            while (!sentence[0].Equals("."))
            {
                stack = new Stack<char>();
                check = true;
                for (int i = 0; i < sentence.Length; i++)
                {
                    word = sentence[i].ToCharArray();
                    for(int j = 0; j < word.Length; j++)
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
                                sb.Append("no\n");
                                check = false;
                                break;
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
                                sb.Append("no\n");
                                check = false;
                                break;
                            }
                            else
                            {
                                stack.Pop();
                            }
                        }
                    }

                    if (!check)
                        break;
                }

                if (check)
                    sb.Append("yes\n");

                sentence = reader.ReadLine().Split();
            }
            
            writer.WriteLine(sb.ToString());

            writer.Close();
            reader.Close();
        }
    }
}
