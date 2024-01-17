using System;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {            
            int count = 0;

            int A = int.Parse(Console.ReadLine());
            int B = int.Parse(Console.ReadLine());
            int C = int.Parse(Console.ReadLine());

            int num = A * B * C;=
            char[] pieceNum = num.ToString().ToCharArray();

            for (int i = 0; i < 10; i++) 
            {
                for (int j = 0; j < pieceNum.Length; j++) 
                {
                    if (pieceNum[j].ToString() == i.ToString()) 
                        count++;
                }
                Console.WriteLine(count);
                count = 0;
            }
        }
    }
}
