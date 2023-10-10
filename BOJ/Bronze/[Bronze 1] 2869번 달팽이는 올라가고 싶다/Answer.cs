using System;
using System.IO

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            StreamWriter writer = new StreamWriter(Console.OpenStandardOutput());
            StreamReader reader = new StreamReader(Console.OpenStandardInput());

            int[] nums = reader.ReadLine().Split().Select(s => Int32.Parse(s)).ToArray();

            int answer = 0;
            nums[2] = nums[2] - nums[0];
            if (nums[2] > 0)
            {
                answer = nums[2] / (nums[0] - nums[1]);
                if (nums[2] % (nums[0] - nums[1]) != 0)
                    answer++;
            }
            answer++;

            System.Console.WriteLine(answer);
            writer.Close();
            reader.Close();
        }
    }
}
