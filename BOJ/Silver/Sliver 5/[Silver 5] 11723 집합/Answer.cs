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

            int M = int.Parse(reader.ReadLine());

            int s = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++)
            {
                String[] input = reader.ReadLine().Split(' ');

                switch (input[0])
                {
                    case "all":
                        s = (1 << 21) - 1;
                        break;
                    case "empty":
                        s = 0;
                        break;
                    default:
                        int x = int.Parse(input[1]);
                        switch (input[0])
                        {
                            case "add":
                                s |= (1 << x);
                                break;
                            case "remove":
                                s &= ~(1 << x);
                                break;
                            case "check":
                                sb.Append((s & (1 << x)) != 0 ? 1 : 0).Append('\n');
                                break;
                            case "toggle":
                                s ^= (1 << x);
                                break;
                        }
                        break;
                }
            }

            writer.WriteLine(sb);

            writer.Close();
            reader.Close();
        }
    }
}