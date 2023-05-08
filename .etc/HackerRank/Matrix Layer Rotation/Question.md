# HackerRank 'Matrix Layer Rotation'

<br>

## 문제
You are given a 2D matrix of dimension m x n and a positive integer r. You have to rotate the matrix r times and print the resultant matrix. Rotation should be in anti-clockwise direction.

Rotation of a 4x5 matrix is represented by the following figure. Note that in one rotation, you have to shift elements by one step only.

It is guaranteed that the minimum of m and n will be even.

As an example rotate the Start matrix by 2:

```
  Start         First           Second
     1 2 3 4       2  3  4  5      3  4  5  6
    12 1 2 5  ->   1  2  3  6 ->   2  3  4  7
    11 4 3 6      12  1  4  7      1  2  1  8
    10 9 8 7      11 10  9  8     12 11 10  9
```

<br><br>

## 기능 설명
Complete the matrixRotation function in the editor below.

matrixRotation has the following parameter(s):

- int matrix[m][n]: a 2D array of integers
- int r: the rotation factor

<br><br>

## 입력
The first line contains three space separated integers, m, n, and r, the number of rows and columns in matrix, and the required rotation.
The next m lines contain n space-separated integers representing the elements of a row of matrix.

<br><br>

## 출력
It should print the resultant 2D integer array and return nothing. Print each row on a separate line as space-separated integers.

<br><br>

## 예시
#### 입력
```
STDIN        Function
-----        --------
4 4 2        rows m = 4, columns n = 4, rotation factor r = 2
1 2 3 4      matrix = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
5 6 7 8
9 10 11 12
13 14 15 16
```
#### 출력
```
3 4 8 12
2 11 10 16
1 7 6 15
5 9 13 14
```