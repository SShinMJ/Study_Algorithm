using System;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split();
            int a = int.Parse(s[0]);
            int b = int.Parse(s[1]);

            Console.WriteLine(GCD(a, b));
            Console.Write(LCM(a, b));

            int LCM(int a, int b)
            {
                int result = (a * b) / GCD(a, b);
                
                return result;
            }

            int GCD(int a, int b)
            {
                while(b != 0)
                {
                    int temp = b;
                    b = a % b;
                    a = temp;
                }

                return a;
            }
        }
    }
}
