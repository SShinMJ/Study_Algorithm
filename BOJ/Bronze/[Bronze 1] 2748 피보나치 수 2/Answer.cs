using System;

namespace 백준
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string s = Console.ReadLine();
            
            int n = int.Parse(s);
            long[] f = new long[n+1];
            
            f[1] = 1;
            for(int i = 2; i <= n; i++)
            {
                f[i] = f[i-1] + f[i-2];
            }
            
            Console.Write(f[n]);
        }
    }
}
