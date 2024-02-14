using System;

namespace 백준
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());
            int start = num;
            int count = 0;
 
            while (true)
            {
                int a = num / 10;
                int b = num % 10;
                num = (b * 10) + (a + b) % 10;
                count++;
                if (num == start)
                    break;
            }
            
            Console.WriteLine(count);
        }
    }
}
