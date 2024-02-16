using System;
using System.IO;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int numM = int.Parse(Console.ReadLine());
            int numN = int.Parse(Console.ReadLine());
            
            int max = 0;
            int min = 0;
            
            for(int index = numM; index <= numN; index++) 
            {
                if(IsPrime(index)) 
                {
                    if(min == 0) min = index;
                    max += index;
                }
            }
            
            if(min == 0) 
            {
                Console.WriteLine(-1);
            } 
            else 
            {
                Console.WriteLine(max + "\n" + min);
            }
        }
	
        public static bool IsPrime(int num) 
        {
            if(num == 1) return false;
            
            for(int index = 2; index <= num / 2; index++)
                if(num % index == 0) 
                    return false;

            return true;
        }
    }
}
