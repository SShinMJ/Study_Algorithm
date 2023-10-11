using System;
using System.IO;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            StreamWriter writer = new StreamWriter(Console.OpenStandardOutput());
            StreamReader reader = new StreamReader(Console.OpenStandardInput());

            bool[] nums = new bool[10001];

            int index;
            for(int i = 1; i < 10000; i++)
            {
                index = SelfNumber(i);
                if(index < 10001)
                    nums[index] = true;
            }

            for(int i = 1; i < nums.Length; i++)
            {
                if (!nums[i])
                    System.Console.WriteLine(i);
            }
        }

        static int SelfNumber(int i)
        {
            int sum = i;
            while(i / 10 > 0)
            {
                sum += i % 10;
                i /= 10;
            }
            return sum + i;
        }
    }
}
