using System;
using System.IO;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string[] octalToBinary = {"000", "001", "010", "011", "100", "101", "110", "111" };
            string[] octalToBinaryFirst = { "", "1", "10", "11", "100", "101", "110", "111" };

            StreamWriter writer = new StreamWriter(Console.OpenStandardOutput());
            StreamReader reader = new StreamReader(Console.OpenStandardInput());
            StringBuilder sb = new StringBuilder();

            char[] num = reader.ReadLine().ToCharArray();
            for(int i = 0; i < num.Length; i++)
            {
                if(i == 0)
                {
                    sb.Append(octalToBinaryFirst[num[i] - '0']);
                }
                else
                    sb.Append(octalToBinary[num[i]-'0']);
            }

            if (sb.Length == 0)
                writer.Write("0");
            else
                writer.Write(sb);

            writer.Close();
            reader.Close();
        }
    }
}