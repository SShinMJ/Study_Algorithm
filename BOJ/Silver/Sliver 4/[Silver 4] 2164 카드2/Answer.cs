using System;

namespace 백준
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());

            Queue<int> nums = new Queue<int>();
            for(int i = 0; i < N; i++)
            {
                nums.Enqueue(i+1);
            }

            while(nums.Count > 1)
            {
                nums.Dequeue();
                if (nums.Count > 1)
                    nums.Enqueue(nums.Dequeue());
            }

            Console.WriteLine(nums.Peek());
        }
    }
}
