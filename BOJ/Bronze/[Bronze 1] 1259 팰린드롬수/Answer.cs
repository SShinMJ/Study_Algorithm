using System;
using System.Text;

namespace 백준
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string input;
            bool pass;
            StringBuilder strBuilder = new StringBuilder();
            while (true)
            {
                pass = true;
                input = Console.ReadLine();

                if (input.Equals("0"))
                    break;

                for(int i = 0; i < input.Length; i++)
                {
                    if (input[i] != input[input.Length - i - 1])
                    {
                        pass = false;
                        break;
                    }
                }

                if(pass)
                    strBuilder.Append("yes\n");
                else
                    strBuilder.Append("no\n");

            }

            Console.WriteLine(strBuilder.ToString());
        }
    }
}
