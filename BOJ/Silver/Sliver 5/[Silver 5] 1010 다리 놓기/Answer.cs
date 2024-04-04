using System;
using System.IO;

namespace BOJ
{
    internal class Program
    {
        // 최대 값이 –±5.0 × 10^−324 ~ ±1.7 × 10^308 인 long을 사용
        static long[,] result = new long[30, 30];

        static void Main(string[] args)
        {
            StreamWriter writer = new StreamWriter(Console.OpenStandardOutput());
            StreamReader reader = new StreamReader(Console.OpenStandardInput());

            int T = int.Parse(reader.ReadLine());

            // nCr을 미리 계산
            Combination();

            while (T > 0)
            {
                //  테스트 케이스 정수 a, b
                string[] s_data = Console.ReadLine().Split();

                int i_n = int.Parse(s_data[0]);
                int i_r = int.Parse(s_data[1]);

                // 계산된 nCr 호출
                writer.WriteLine(result[i_r, i_n]);

                T--;
            }

            writer.Close();
            reader.Close();
        }

        // nCr 함수
        public static void Combination()
        {
            for (int i = 1; i < 30; i++)
            {
                result[i, i] = 1;
                result[i, 1] = i;
            }

            for (int i = 2; i < 30; i++)
                for (int j = 2; j < 30; j++)
                    if (i > j)
                        result[i, j] = result[i - 1, j - 1] + result[i - 1, j];
        }
    }
}