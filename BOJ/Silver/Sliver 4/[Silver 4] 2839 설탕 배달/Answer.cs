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

            int N = int.Parse(reader.ReadLine());

            // 5로 나눈 나머지가 0 또는 3의 배수라면 5로 나눈다.
            // 나눠지지 않는다면, 나누는 나머지가 3이 되도록 5로 나누는 값을 하나씩 줄인다?
            int divideIdx = N / 5;
            while (divideIdx > 0 && (N - divideIdx * 5) % 3 != 0)
            {
                divideIdx--;
            }

            // 정확히 나눠지지 않으면 -1 출력.
            if (divideIdx == 0 && N % 3 != 0)
                writer.WriteLine("-1");
            else
                writer.WriteLine((divideIdx + (N - divideIdx * 5) / 3).ToString());


            writer.Close();
            reader.Close();
        }
    }
}
