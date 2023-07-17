using System;

namespace 백준
{
    internal class Program
    {
        static void Main(string[] args)
        {
            StreamWriter writer = new StreamWriter(Console.OpenStandardOutput());
            StreamReader reader = new StreamReader(Console.OpenStandardInput());

            int N = int.Parse(reader.ReadLine());

            string[] user;

            List<(int, string)> users = new List<(int, string)>();
            for (int i = 0; i < N; i++)
            {
                user = reader.ReadLine().Split();
                users.Add((int.Parse(user[0]), user[1]));
            }

            /* 
            // Dictionary는 key의 중복을 허용하지 않는다. 
            // Value를 리스트로 하여 사용할 수 있지만, 해당 문제에선x.
            Dictionary<int, string> dict = new Dictionary<int, string>();

            // Key 목록을 List로 변환
            List<int> list = dict.Keys.ToList();

            // list 정렬
            list.Sort();

            Dictionary<int, string> sortDict = new Dictionary<int, string>();
            // 정렬된 Dictionary 객체 구현
            foreach (var key in list)
            {
                sortDict.Add(key, dict[key]);
            }
            */

            // C# 문법 LINQ(OrderBy)로 정렬
            var sortUsers = users.OrderBy(x => x.Item1).ToList();

            for (int i = 0; i < N; i++)
                writer.WriteLine($"{sortUsers[i].Item1} {sortUsers[i].Item2}");

            writer.Close();
            reader.Close();
        }
    }
}
