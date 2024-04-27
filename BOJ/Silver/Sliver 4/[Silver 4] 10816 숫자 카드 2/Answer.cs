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

            int N = int.Parse(reader.ReadLine());
            int[] A = new int[N];
            string[] input = reader.ReadLine().Split(' ');
            for (int i = 0; i < N; i++)
            {
                A[i] = int.Parse(input[i]);
            }

            Array.Sort(A);

            int M = int.Parse(reader.ReadLine());
            input = reader.ReadLine().Split(' ');
            for (int i = 0; i < M; i++)
            {
                sb.Append(Binary_search(A, int.Parse(input[i]), 0, N - 1) + " ");
            }

            writer.WriteLine(sb);

            writer.Close();
            reader.Close();
        }

        static int Binary_search(int[] array, int target, int start, int end)
        {
            int mid;
            int count = 0;
            int maxIndext = end;
            while(start <= end)
            {
                mid = (start + end) / 2;

                if (target == array[mid])
                {
                    while((mid >= start && mid <= end) && target == array[mid])
                    {
                        count++;

                        if (mid > maxIndext / 2)
                            mid++;
                        else
                            mid--;
                    }
                    break;
                }
                else if (target < array[mid])
                    end--;
                else
                    start++;
            }

            return count;
        }
    }
}