# 문제

![image](https://github.com/SShinMJ/Study_Algorithm/assets/82142527/c7755cef-7606-46af-bb90-b7d1e3fa5fdd)


# 풀이

1. 메모리 조건 확인 : X가 2^63 이므로 int 범위(2^32)를 벗어나므로 long으로 해야함을 확인!
2. 시간 확인 : N이 2^18으로 처리해야할 데이터 양이 많으므로, 단순 곱셈으로 NPOT 값을 구하면 안된다. 비트연산으로 구해야함을 확인!

```csharp
            // XOR연산 : ^
            int N = int.Parse(Console.ReadLine());

            long[] npotNums = new long[N];
            int num;
            long npot = 1;
            for (int i = 0; i < N; i++)
            {
                num = int.Parse(Console.ReadLine());

                while (npot < num)
                {
                    npot = npot << 2;
                }

                npotNums[i] = npot;
            }

            int answer = 0;
            foreach (int npotNum in npotNums)
            {
                answer = answer ^ npotpNum;
            }

            Console.WriteLine(answer);
```
