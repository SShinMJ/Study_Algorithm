using System;
using System.IO;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            StreamWriter writer = new StreamWriter(Console.OpenStandardOutput());
            StreamReader reader = new StreamReader(Console.OpenStandardInput());

            int N = int.Parse(reader.ReadLine());
            int[] NArr = new int[N];
            NArr = Array.ConvertAll(reader.ReadLine().Split(' '), int.Parse);
            Array.Sort(NArr); //이진 탐색은 정렬된 배열에서만 사용할 수 있음

            int M = int.Parse(reader.ReadLine());
            int[] MArr = new int[N];
            MArr = Array.ConvertAll(reader.ReadLine().Split(' '), int.Parse);

            // 이진 탐색
            for (int i = 0; i < M; i++)
            {
                int lo = 0;
                int hi = NArr.Length - 1;
                bool isIn = false;

                while (lo <= hi)
                {
                    int mid = (lo + hi) / 2;
                    int goal = NArr[mid]; // 항상 숫자카드의 중간값을 확인

                    if (goal == MArr[i]) // 숫자카드 배열의 중간값을 확인하면서 정수 M배열과 동일한 카드가 있는지 확인
                    {
                        isIn = true;
                        break;
                    }

                    if (goal > MArr[i]) // 숫자카드 배열의 중간값이 찾는 수보다 크면
                    {
                        hi = mid - 1;
                    }
                    else // 숫자카드 배열의 중간값이 찾는 수보다 작다면(같으면 찾는 수가 있다는 뜻)
                    {
                        lo = mid + 1;
                    }
                } 
                // 목표값(MArr[i])과 lo 혹은 hi의 값을 비교하여 lo를 mid + 1로, hi는 mid - 1로 움직여 
                //해당 인덱스에 저장된 값과 NArr[mid](중간값)을 비교하다보면 찾는 값이 배열에 속해 있을 것이며 결국 NArr[mid]와 MArr[i]의 값이 같아져 isIn이 true가 되고
                //찾는 값이 배열에 속해있지 않다면 lo값이 hi값보다 커지게되어 inIn이 false인 채로 반복문이 종료된다.

                if (isIn) writer.Write("{0} ", 1);
                else writer.Write("{0} ", 0);
            }

            writer.Close();
            reader.Close();
        }
    }
}
