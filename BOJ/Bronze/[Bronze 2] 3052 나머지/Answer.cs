using System;
using System.Text;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {            
            // 입력받을 숫자를 담기 위한 리스트 numbers 선언
            List<int> numbers = new List<int>();

            // 정답을 저장할 리스트 answer 선언
            List<int> answer = new List<int>();

            // 한줄에 숫자 하나씩 10번 입력되므로 for으로 입력받는다
            for(int i=0; i<10; i++)
            {
                // 숫자 입력받아서 곧장 42로 나눈 나머지를 numbers에 넣기
                numbers.Add(int.Parse(ReadLine()) % 42);
            }

            // numbers에 저장된 나머지 중에서 같은 숫자가 몇 개인지 세기
            // 첫번째 for문은 0부터 전체길이 -1만큼, 두번째 for문은 1부터 끝까지 돌려서 엇갈리게 만든다.
            for (int i=0; i < numbers.Count-1; i++)
            {
                for (int j=i+1; j<numbers.Count; j++)
                {
                    // 두개를 비교했는데 동일한 값이라면 다음 루프로 넘어감
                    if (numbers[i] == numbers[j])
                    {
                        continue;
                    }
                    else // 동일한 값이 아니라면
                    {
                        // answer 리스트에 해당 값이 포함되어있는지 검사함
                        if (!answer.Contains(numbers[i]))
                        {
                            answer.Add(numbers[i]);
                        }
                    }
                }
            }
            // 위 과정이 끝나면 중복되지 않는 나머지들만 answer에 저장됨
            // 그러나 마지막 숫자는 검사에 빠져있으므로 마지막 숫자만 따로 검사함
            if (!answer.Contains(numbers[^1]))
            {
                answer.Add(numbers[^1]);
            }

            // answer 리스트의 총 개수를 출력하면 끝
            Console.WriteLine(answer.Count);
        }
    }
}
