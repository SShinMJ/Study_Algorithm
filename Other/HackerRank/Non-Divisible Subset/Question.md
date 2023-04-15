# HackerRank 'Forming a Magic Square'

<br>

## 문제
Given a set of distinct integers, print the size of a maximal subset of S where the sum of any 2 numbers in S' is not evenly divisible by k.

<br><br>

## 예시
S = [19, 10, 12, 10, 24, 25, 22], k = 4
One of the arrays that can be created is S'[0] = [10, 12, 25].  Another is S'[1] = [19, 22, 24]. After testing all permutations, the maximum length solution array has 3 elements.

<br><br>

## 기능 설명
Complete the nonDivisibleSubset function in the editor below.

nonDivisibleSubset has the following parameter(s):

- int S[n]: an array of integers
- int k: the divisor

<br><br>

## 입력
The first line contains 2 space-separated integers, n and k, the number of values in S and the non factor.
The second line contains n space-separated integers, each an S[i], the unique values of the set.

<br><br>

## 출력
- int: the length of the longest subset of  meeting the criteria

<br><br>

## 예시
#### 입력
```
STDIN    Function
-----    --------
4 3      S[] size n = 4, k = 3
1 7 2 4  S = [1, 7, 2, 4]
```
#### 출력
```
3
```