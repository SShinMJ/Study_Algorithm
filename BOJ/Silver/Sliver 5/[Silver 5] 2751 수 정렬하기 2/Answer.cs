using System;
using System.Text;

namespace 백준
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());

            int[] nums = new int[N];
            for(int i = 0; i < nums.Length; i++) 
            {
                nums[i] = int.Parse(Console.ReadLine());
            }
            
            Array.Sort(nums);

            StringBuilder sb = new StringBuilder(string.Join("\n", nums));

            Console.WriteLine(sb.ToString());

            // foreach 문 출력 과부화로 시간초과.
/*            foreach(int num in  nums)
                Console.WriteLine(num);*/
        }
    }
}
