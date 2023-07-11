using System;

namespace 백준
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            double[] scores = new double[N];

            double max = 0, sum = 0;
            string write = Console.ReadLine();
            for (int i = 0; i < N; i++)
            {
                scores[i] = double.Parse(write.Split()[i]);

                if (scores[i] > max)
                    max = scores[i];

                sum += scores[i];
            }

            Console.WriteLine(sum / max * 100 / N);
        }
    }
}
