using System;
using System.IO;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            StreamWriter writer = new StreamWriter(Console.OpenStandardOutput());
            StreamReader reader = new StreamReader(Console.OpenStandardInput());
        
            string word = reader.ReadLine();

            string[] dial = new string[] { "2ABC", "3DEF", "4GHI", "5JKL", "6MNO", "7PQRS", "8TUV", "9WXYZ"};

            int rusult = 0;
            
            foreach(var w in word)
            {
                foreach(string a in dial)
                {
                    if(a.Contains(w.ToString()))
                    {
                        result += int.Parse(a[0].ToString()) + 1;
                    }
                }
            }
        
            writer.WriteLine(rusult);
        
            writer.Close();
            reader.Close();
        }

    }
}
