using System;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {            
            int i_count = int.Parse(Console.ReadLine());

            while (i_count > 0)
            {
                string[] s_data = Console.ReadLine().Split();
                int i_a = int.Parse(s_data[0]);
                int i_b = int.Parse(s_data[1]);

                int result = i_a;

                for (int i = 1; i < i_b % 4 + 4; i++)
                    result = (result * i_a) % 10;

                if (result == 0)
                    result = 10;

                Console.WriteLine(result);

                i_count--;
            }
        }
    }
}
