# HackerRank 'Queen's Attack II'

Link : https://www.hackerrank.com/challenges/queens-attack-2/problem?isFullScreen=true
<br>

## 문제
You will be given a square chess board with one queen and a number of obstacles placed on it. Determine how many squares the queen can attack.

A queen is standing on anYou will be given a square chess board with one queen and a number of obstacles placed on it. Determine how many squares the queen can attack.

A queen is standing on an nxn chessboard. The chess board's rows are numbered from 1 to n, going from bottom to top. Its columns are numbered from 1 to n, going from left to right. Each square is referenced by a tuple, (r, c), describing the row, , and column, , where the square is located.

The queen is standing at position (r<sub>q</sub>, c<sub>q</sub>). In a single move, she can attack any square in any of the eight directions (left, right, up, down, and the four diagonals). In the diagram below, the green circles denote all the cells the queen can attack from : (4, 4)

<br><br>

## 기능 설명
Complete the queensAttack function in the editor below.

queensAttack has the following parameters:
- int n: the number of rows and columns in the board
- nt k: the number of obstacles on the board
- int r_q: the row number of the queen's position
- int c_q: the column number of the queen's position
- int obstacles[k][2]: each element is an array of  integers, the row and column of an obstacle

<br><br>

## 입력
The first line contains two space-separated integers  and , the length of the board's sides and the number of obstacles.
The next line contains two space-separated integers  and , the queen's row and column position.
Each of the next  lines contains two space-separated integers  and , the row and column position of .

<br><br>

## 출력
- int: the number of squares the queen can attack

<br><br>

## 예시
#### 입력
```
4 0
4 4
```
#### 출력
```
9
```