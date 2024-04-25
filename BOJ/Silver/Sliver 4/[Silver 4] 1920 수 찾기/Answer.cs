using System;
using System.IO;
using System.Security.Cryptography;
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

            int N = int.Parse(reader.ReadLine());
            long[] A = new long[N];
            string[] input = reader.ReadLine().Split(' ');
            for (int i = 0; i < N; i++)
            {
                A[i] = long.Parse(input[i]);
            }

            int M = int.Parse(reader.ReadLine());
            long[] B = new long[M];
            input = reader.ReadLine().Split(' ');
            for (int i = 0; i < M; i++)
            {
                B[i] = long.Parse(input[i]);
            }

            Array.Sort(A);

            for (int i = 0; i < M; i++)
            {
                sb.Append(Binary_search(A, B[i], 0, N-1) + "\n");
            }

            writer.WriteLine(sb.ToString());

            writer.Close();
            reader.Close();
        }

        public static int Binary_search(long[] array, long target, int start, int end)
        {
            int mid;
            while (start <= end)
            {
                mid = (start + end) / 2;

                if (array[mid] == target)
                    return 1;
                else if (array[mid] > target)
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            return 0;
        }
    }
}