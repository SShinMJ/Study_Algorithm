using System;
using System.IO;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            StreamWriter writer = new StreamWriter(Console.OpenStandardOutput());
            StreamReader reader = new StreamReader(Console.OpenStandardInput());

            int money = int.Parse(reader.ReadLine());
            money = 1000 - money;

            int sum = 0;
            sum += money / 500;
            money %= 500;
            sum += money / 100;
            money %= 100;
            sum += money / 50;
            money %= 50;
            sum += money / 10;
            money %= 10;
            sum += money / 5;
            money %= 5;
            sum += money;

            writer.Write(sum);

            writer.Close();
            reader.Close();
        }
    }
}