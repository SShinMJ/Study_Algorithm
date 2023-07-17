using System;

namespace 백준
{
    internal class Program
    {
        static int[] cards;
        static int N, M;
        static int max;

        static void Main(string[] args)
        {
            string nums = Console.ReadLine();
            N = int.Parse(nums.Split()[0]);
            M = int.Parse(nums.Split()[1]);

            nums = Console.ReadLine();
            cards = new int[N];
            for (int i = 0; i < N; i++)
            {
                cards[i] = int.Parse(nums.Split()[i]);
            }

            Dfs(0, 0, 0);

            Console.WriteLine(max);
        }

        public static void Dfs(int sum, int idx, int count)
        {
            if (sum > M)
                return;
            else if (count == 3)
            {
                max = Math.Max(max, sum);
                return;
            }

            for (int i = idx+1; i < N; i++)
            {
                if (count < 3)
                {
                    Dfs(sum + cards[i], i, count + 1);
                }
            }

            return;
        }
    }
}
