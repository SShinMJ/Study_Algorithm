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
            StringBuilder sb = new StringBuilder();

            string[] croatian = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

            string input = reader.ReadLine();
            int sum = 0;
            int answer = 0;
            for (int i = 0; i < croatian.Length; i++)
            {
                if (input.Contains(croatian[i]))
                {
                    // 1. 특정 문자를 전부 없애고 그 결과값인 문자열의 Length를 구한다
                    // 2. 얻어진 값을 원래 초기에 입력된 문자열의 Length에서 빼준다.
                    // 사라진 총 길이를 알 수 있다.
                    sum = input.Length - input.Replace(croatian[i], "").Length;
                    input = input.Replace(croatian[i], "_");
                    // 3. 없애려고했던 특정 문자의 길이로 나누면, 해당 단어가 총 몇개였는 지 알 수 있다.
                    answer += sum / croatian[i].Length;
                }
            }
            input = input.Replace("_", "");
            answer += input.Length;

            writer.WriteLine(answer);

            writer.Close();
            reader.Close();
        }
    }
}