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

            int[] month = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            int sum = 0;

            string day = Console.ReadLine();
            string[] monthDay = day.Split();
            int mon = int.Parse(monthDay[0]);
            int d = int.Parse(monthDay[1]);

            for (int i = 0; i < mon - 1; i++)
            {
                sum = sum + month[i];
            }
            sum = sum + d;

            switch (sum % 7)
            {
                case 1:
                    writer.WriteLine("MON");
                    break;
                case 2:
                    writer.WriteLine("TUE");
                    break;
                case 3:
                    writer.WriteLine("WED");
                    break;
                case 4:
                    writer.WriteLine("THU");
                    break;
                case 5:
                    writer.WriteLine("FRI");
                    break;
                case 6:
                    writer.WriteLine("SAT");
                    break;
                default:
                    writer.WriteLine("SUN");
                    break;
            }

            writer.Close();
            reader.Close();
        }
    }
}