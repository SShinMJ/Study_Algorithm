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

            int T = int.Parse(reader.ReadLine());

            for (int K = 0; K < T; K++)
            {
                int k = int.Parse(reader.ReadLine()); //층
                int n = int.Parse(reader.ReadLine()); //호
                int person = 0;
                //4층에 3호를 구하고 싶으면 0층 1호를 (1,1)으로 기준점을 잡고 (3,4)를 구한다.
                int[,] room = new int[n, k + 1];

                for (int i = 0; i < n; i++) //0층 값 채우기
                {
                    room[i, 0] = i + 1;
                }
                for (int i = 1; i < k + 1; i++) //1호 값 채우기
                {
                    room[0, i] = 1;
                }

                // 해당 집의 정원은 왼쪽집의 정원과 아래층 정원의 합으로 구할 수 있다.
                for (int i = 1; i < k + 1; i++)
                {
                    for (int j = 1; j < n; j++)
                    {
                        room[j, i] = room[j, i - 1] + room[j - 1, i];
                    }
                }
                person += room[n - 1, k];
                writer.WriteLine(person);
            }

            writer.Close();
            reader.Close();
        }
    }
}