# HackerRank 'Organizing Containers of Balls'

<br>

## 문제
David has several containers, each with a number of balls in it. He has just enough containers to sort each type of ball he has into its own container. David wants to sort the balls using his sort method.

David wants to perform some number of swap operations such that:

- Each container contains only balls of the same type.
- No two balls of the same type are located in different containers.

<br><br>

## 예시
containers = [[1, 4], [2, 3]]
David has n = 2 containers and 2 different types of balls, both of which are numbered from 0 to n - 1 = 1. The distribution of ball types per container are shown in the following diagram.

In a single operation, David can swap two balls located in different containers.

<br><br>

## 기능 설명
Complete the organizingContainers function in the editor below.

organizingContainers has the following parameter(s):

- int containter[n][m]: a two dimensional array of integers that represent the number of balls of each color in each container

<br><br>

## 입력
The first line contains an integer , the number of queries.

Each of the next q  sets of lines is as follows:

1. The first line contains an integer n, the number of containers (rows) and ball types (columns).
2. Each of the next n lines contains  space-separated integers describing row containers[i].

<br><br>

## 출력
- string: either Possible or Impossible

## 예시
### 입력
```
2
2
1 1
1 1
2
0 2
1 1
```

### 츨력
```
Possible
Impossible
```

