using System;
using System.IO;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string [] str = Console.ReadLine().Split(' ');
            int A = int.Parse(str[0]);
            int B = int.Parse(str[1]);
            int C = int.Parse(Console.ReadLine());

            B += C;

            while (B >= 60)
            {
                A++;
                B -= 60;
            }

            if(A >= 24)
            {
                A -= 24;
            }

            Console.WriteLine(A + " " + B); 
        }
    }
}
