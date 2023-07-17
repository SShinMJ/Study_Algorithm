# 문제

![image](https://github.com/SShinMJ/Study_Algorithm/assets/82142527/c7755cef-7606-46af-bb90-b7d1e3fa5fdd)


# 풀이

```csharp
            // XOR연산 : ^
            int N = int.Parse(Console.ReadLine());

            int[] nopNums = new int[N];
            int num;
            int nop = 1;
            for (int i = 0; i < N; i++)
            {
                num = int.Parse(Console.ReadLine());

                while(nop < num)
                {
                    nop *= 2;
                }

                nopNums[i] = nop;
            }

            int answer = 0;
            foreach (int nopNum in nopNums)
            {
                answer = answer ^ nopNum;
            }

            Console.WriteLine(answer);
```
