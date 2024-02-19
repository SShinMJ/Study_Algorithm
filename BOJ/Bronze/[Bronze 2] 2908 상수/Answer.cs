using System;
using System.IO;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split();
            int[] a = Array.ConvertAll(s, int.Parse);

            int num1= 0;
            int num2 = 0;

            while (a[0] > 0)
            {
                num1 += a[0] % 10;
                num1 *= 10;
                a[0] /= 10;
            }
            
            while (a[1] > 0)
            {
                num2 += a[1] % 10;
                num2 *= 10;
                a[1] /= 10;
            }

            Console.WriteLine(num1 >= num2 ? num1/10 : num2/10);
        }

    }
}
