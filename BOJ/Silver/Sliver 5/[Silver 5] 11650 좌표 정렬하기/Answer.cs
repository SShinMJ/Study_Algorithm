using System;

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

            string[] coord;
            List<(int, int)> coords = new List<(int, int)>();
            for (int i = 0; i < N; i++)
            {
                coord = reader.ReadLine().Split();
                coords.Add((int.Parse(coord[0]), int.Parse(coord[1])));
            }

            // C# 문법 LINQ(OrderBy)로 정렬
            var sortYUsers = coords.OrderBy(y => y.Item2).ToList();
            var sortUsers = sortYUsers.OrderBy(x => x.Item1).ToList();

            for (int i = 0; i < N; i++)
                writer.WriteLine($"{sortUsers[i].Item1} {sortUsers[i].Item2}");

            writer.Close();
            reader.Close();
        }
    }
}
