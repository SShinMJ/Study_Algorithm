# HackerRank 'Forming a Magic Square'

<br>

## 문제
We define a magic square to be an nxn matrix of distinct positive integers from 1 to n^2 where the sum of any row, column, or diagonal of length  is always equal to the same number: the magic constant.

You will be given a 3x3 matrix s of integers in the inclusive range [1, 9]. We can convert any digit  to any other digit a in the range [1, 9] at cost of [a-b]. Given s, convert it into a magic square at minimal cost. Print this cost on a new line.

Note: The resulting magic square must contain distinct integers in the inclusive range [1, 9].

<br><br>

## 예시
s = [[5, 3, 4], [1, 5, 8], [6, 4, 2]]

The matrix looks like this:
```
5 3 4
1 5 8
6 4 2
```

We can convert it to the following magic square:
```
8 3 4
1 5 9
6 7 2
```

This took three replacements at a cost of
|5-8| + |8-9| + |4-7| = 7

<br><br>

## 기능 설명
Function Description

Complete the formingMagicSquare function in the editor below.

formingMagicSquare has the following parameter(s):

int s[3][3]: a 3x3 array of integers

<br><br>

## 입력
Each of the 3 lines contains three space-separated integers of row s[i].

<br><br>

## 출력
int: the minimal total cost of converting the input square to a magic square

<br><br>

## 제약
s[i][j] ∈ [1,9]
