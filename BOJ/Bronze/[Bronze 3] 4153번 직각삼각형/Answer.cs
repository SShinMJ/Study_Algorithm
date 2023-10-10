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
            StringBuilder sb = new StringBuilder();

            string testCase;
            string[] testCases;
            double[] nums;
            while (true)
            {
                testCase = reader.ReadLine();
                if (testCase.Equals("0 0 0"))
                    break;

                testCases = testCase.Split();
                nums = new double[testCases.Length];
                for (int i = 0 ; i < testCases.Length; i++)
                {
                    nums[i] = Int32.Parse(testCases[i]);
                    nums[i] = Math.Pow(nums[i], 2);
                }

                swap(ref nums);

                if ((nums[0] + nums[1]) == nums[2])
                    sb.Append("right\n");
                else
                    sb.Append("wrong\n");
            }

            System.Console.WriteLine(sb.ToString());
            writer.Close();
            reader.Close();
        }

        static void swap(ref double[] nums)
        {
            double temp;
            for(int i = 0; i < nums.Length-1; i++)
            {
                if (nums[i] > nums[i + 1])
                {
                    temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i+1] = temp;
                }
            }
        }
    }
}
