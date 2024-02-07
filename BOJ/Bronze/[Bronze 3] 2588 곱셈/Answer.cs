using System;
using System.IO;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string a = Console.ReadLine();
            string b = Console.ReadLine();
 
            Console.WriteLine(int.Parse(a) * (int)Char.GetNumericValue(b[2]));
            Console.WriteLine(int.Parse(a) * (int)Char.GetNumericValue(b[1]));
            Console.WriteLine(int.Parse(a) * (int)Char.GetNumericValue(b[0]));
            Console.WriteLine(int.Parse(a) * int.Parse(b));
        }
    }
}
