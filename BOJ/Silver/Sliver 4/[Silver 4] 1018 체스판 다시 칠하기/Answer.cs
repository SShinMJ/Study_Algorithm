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

            string[] input = reader.ReadLine().Split(' ');
            int n = int.Parse(input[0]);
            int m = int.Parse(input[1]);

            var board = new string[n];
            for (int i = 0; i < n; i++)
                board[i] = reader.ReadLine();

            int res = 64;
            for (int i = 0; i <= n - 8; i++) // 8*8만큼의 체스판을 구한다.
            {                                // (왼쪽 상단의 좌표를 변경하면서 바꿔야할 문자 개수의 최소값을 업데이트)
                for (int j = 0; j <= m - 8; j++)
                {
                    int case1 = 0, case2 = 0;
                    for (int k = i; k < i + 8; k++)
                    {
                        for (int l = j; l < j + 8; l++) // 8*8의 체스판을 돌면서
                        {
                            // W와 B가 와야할 자리에 다른 문자가 오면 1+
                            // 왼쪽 상단이 W냐 B냐에 따라 달라지므로 둘 다 카운트             
                            if ((k + l) % 2 == 0)
                            {
                                if (board[k][l] != 'W') case1++;
                                if (board[k][l] != 'B') case2++;
                            }
                            else
                            {
                                if (board[k][l] != 'B') case1++;
                                if (board[k][l] != 'W') case2++;
                            }
                        }
                    }

                    // 각 경우의 최소값으로 업데이트.
                    res = Math.Min(res, Math.Min(case1, case2));
                }
            }

            writer.WriteLine(res);

            writer.Close();
            reader.Close();
        }
    }
}
