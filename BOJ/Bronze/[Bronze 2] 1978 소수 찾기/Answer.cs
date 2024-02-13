using System;
using System.IO;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());                                             
            int[] arrayNum = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);     
            int counting = 0;                                                        
            
            for (int i = 0; i < N; i++)
            {
                bool isPrime = true;        
                if (arrayNum[i] == 1) continue; 

                for (int j = 2; j <= arrayNum[i] / 2; j++)
                {
                    if (arrayNum[i] % j == 0)
                    {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime)
                    counting++;
            }

            Console.WriteLine(counting);
        }
    }
}
