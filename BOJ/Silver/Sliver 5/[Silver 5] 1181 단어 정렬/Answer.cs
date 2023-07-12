using System;
using System.Collections.Generic;
using System.Linq;

namespace 백준
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());

            List<string> words = new List<string>();


            for (int i = 0; i < N; i++)
            {
                string word = Console.ReadLine();
                words.Add(word.ToLower());
            }

            // Distinct() : 중복 데이터 삭제
            words = words.Distinct().ToList();

            // 사전 순 정렬
            words.Sort();

            // 문자열 길이 순 정렬
            words = words.OrderBy(x => x.Length).ToList();

            foreach (string ans in words)
            {
                Console.WriteLine(ans);
            }
        }
    }
}
