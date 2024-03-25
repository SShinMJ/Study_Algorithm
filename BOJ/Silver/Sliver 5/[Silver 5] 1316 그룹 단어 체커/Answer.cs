using System;

namespace 백준
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            int N = int.Parse(input);

            string[] words = WordInputer(N);
            int countGroupWords = 0;

            for (int i = 0; i < words.Length; i++)
            {
                if (isGroupWord(words[i]))
                {
                    countGroupWords++;
                }
            }

            Console.WriteLine(countGroupWords);
        }

        // 입력받은 단어만큼 반복
        static string[] WordInputer(int N)
        {
            string[] words = new string[N];
            for (int i = 0; i < N; i++)
            {
                words[i] = Console.ReadLine();
            }
            return words;
        }

        //그룹단어인지 체크해주는 함수
        static bool isGroupWord(string word)
        {
            for (int i = 0; i < word.Length; i++)
            {
                for (int j = i; j < word.Length; j++)
                {
                    if (j - i > 1)
                    {
                        if (word[i] == word[j])
                        {
                            return false;
                        }
                    }

                    if (word[i] == word[j])
                    {
                        i += j - i;
                    }
                }
            }
            return true;
        }
    }
}