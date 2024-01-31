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
        
            int l = int.Parse(reader.ReadLine());
            string str = reader.ReadLine();
        
            long result = 0;
            long R = 1;
            long MOD = 1234567891;
        
            for (int i = 0; i < l; i++)
            {
                result += ((int)str[i] - 'a' + 1) * R;
        
                // 덧셈하는 과정에서 소수 M으로 나누어 줘야 값이 너무 커지지 않습니다.
                // (a + b) mod n = {(a mod n) + (b mod n)} mod n
                result %= MOD;
        
                R *= 31;
                R %= MOD;
            }
        
            writer.WriteLine(result);
        
            writer.Close();
            reader.Close();
        }
    }
}
