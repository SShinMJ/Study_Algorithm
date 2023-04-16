# HackerRank 'Bigger is Greater'

url : https://www.hackerrank.com/challenges/bigger-is-greater/problem?isFullScreen=true

<br>

## 문제
Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.

Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:

- It must be greater than the original word
- It must be the smallest word that meets the first condition

<br><br>

## 예시
containers = [[1, 4], [2, 3]]
David has n = 2 containers and 2 different types of balls, both of which are numbered from 0 to n - 1 = 1. The distribution of ball types per container are shown in the following diagram.

In a single operation, David can swap two balls located in different containers.

<br><br>

## 기능 설명
Complete the biggerIsGreater function in the editor below.

biggerIsGreater has the following parameter(s):

- string w: a word

<br><br>

## 입력
The first line of input contains T, the number of test cases.
Each of the next T lines contains w.

<br><br>

## 출력
- string: the smallest lexicographically higher string possible or no answer

## 예시
### 입력
```
5
ab
bb
hefg
dhck
dkhc
```

### 츨력
```
ba
no answer
hegf
dhkc
hcdk
```

