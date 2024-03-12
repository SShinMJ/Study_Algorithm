using System;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());

            Console.WriteLine(Fibonacci(N));
        }

        static int Fibonacci(int num)
        {
            if (num <= 1)
                return num;

            return Fibonacci(num - 1) + Fibonacci(num - 2);
        }
    }
}