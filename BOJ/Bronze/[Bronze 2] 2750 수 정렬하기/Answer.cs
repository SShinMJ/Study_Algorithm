using System;
using System.IO;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int n = Int32.Parse(Console.ReadLine());

            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
            {
                arr[i] = Int32.Parse(Console.ReadLine());
            }

            Array.Sort(arr);

            foreach (int i in arr)
            {
                Console.WriteLine(i);
            }

            Console.ReadLine();
        }
    }
}
