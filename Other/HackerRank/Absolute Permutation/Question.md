# HackerRank 'Absolute Permutation'

url : https://www.hackerrank.com/challenges/absolute-permutation/problem?isFullScreen=true

<br>

## 문제
We define P to be a permutation of the first n natural numbers in the range [1, n]. Let pos[i] denote the value at position i in permutation P using 1-based indexing.

P is considered to be an absolute permutation if |pos[i]-i| = k holds true for every i ∈ [1, n].

Given n and k, print the lexicographically smallest absolute permutation P. If no absolute permutation exists, print -1.

<br><br>

## 예시
n = 4 <br>
k = 2 <br>
Create an array of elements from 1 to n, pos = [1, 2, 3, 4], Using  based indexing, create a permutation where every |pos[i] - i| = k. It can be rearranged to [3, 4, 1, 2] so that all of the absolute differences equal k = 2:
```
pos[i]  i   |pos[i] - i|
  3     1        2
  4     2        2
  1     3        2
  2     4        2
```

<br><br>

## 기능 설명
Complete the absolutePermutation function in the editor below.

absolutePermutation has the following parameter(s):

- int n: the upper bound of natural numbers to consider, inclusive
- int k: the absolute difference between each element's value and its index

<br><br>

## 입력
The first line contains an integer t, the number of queries.

Each of the next t lines contains 2 space-separated integers, n and k.

<br><br>

## 출력
- int[n]: the lexicographically smallest permutation, or  if there is none

## 예시
### 입력
```
STDIN   Function
-----   --------
3       t = 3 (number of queries)
2 1     n = 2, k = 1
3 0     n = 3, k = 0
3 2     n = 3, k = 2
```

### 츨력
```
2 1
1 2 3
-1
```

