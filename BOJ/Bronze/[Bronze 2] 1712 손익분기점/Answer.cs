using System;
using System.IO;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split()
            long a = long.Parse(s[0]); 
            long b = long.Parse(s[1]); 
            long c = long.Parse(s[2]); 
            
            if (b >= c)
            {
                Console.WriteLine(-1);
            }
            else
            {
                if (a / (c - b) < 0)
                {
                    Console.WriteLine(-1);
                }
                else
                {
                    Console.WriteLine(a / (c - b) + 1);
                }
            }
        }
    }
}
