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

            string[] inputs = reader.ReadLine().Split(' ');
            int[] nums = new int[N];
            for (int i = 0; i < N; i++)
            {
                nums[i] = int.Parse(inputs[i]);
            }

            Array.Sort(nums);

            writer.WriteLine(nums[0] + " " + nums[nums.Length-1]);

            writer.Close();
            reader.Close();
        }
    }
}