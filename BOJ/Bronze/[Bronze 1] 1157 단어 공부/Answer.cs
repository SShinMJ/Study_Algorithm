using System;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string inputStr = Console.ReadLine().ToUpper();
            int[] intArray = new int[91];

            for (int i = 0; i < inputStr.Length; i++)
                intArray[inputStr[i]]++;

            int max = 0;
            char c = '?';
            for (int i = 'A'; i <= 'Z'; i++)
            {
                if (intArray[i] > max)
                {
                    max = intArray[i];
                    c = (char)i;
                }
                else if (intArray[i] == max)
                    c = '?';
            }
            Console.WriteLine(c);
        }
    }
}
