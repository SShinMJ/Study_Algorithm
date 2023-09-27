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

            int N = int.Parse(reader.ReadLine());

            List<List<string>> list = new List<List<string>>();
            string[] user;
            for (int i = 0; i < N; i++)
            {
                user = reader.ReadLine().Split();
                list.Add(new List<string> { user[0], user[1] });
            }

            IOrderedEnumerable<List<string>> sortList = list.OrderBy(x => Int32.Parse(x[1])).ThenBy(x => Int32.Parse(x[0]));

            foreach(List<string> list2 in sortList)
            {
                writer.WriteLine(list2[0] + " " + list2[1]);
            }

            writer.Close();
            reader.Close();
        }
    }
}
