# HackerRank 'Forming a Magic Square'

<br>

## 문제
An arcade game player wants to climb to the top of the leaderboard and track their ranking. The game uses Dense Ranking, so its leaderboard works like this:
- The player with the highest score is ranked number  on the leaderboard.
- Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.

<br><br>

## 예시
ranked = [100, 90, 90, 80]<br>
player = [70, 80, 105]<br>
The ranked players will have ranks 1, 2, 2, and 3, respectively. If the player's scores are 70, 80 and 105, their rankings after each game are 4<sup>th</st>, 3<sup>rd</st> and 1<sup>st</st>. Return [4, 3, 1].

<br><br>

## 기능 설명
Complete the climbingLeaderboard function in the editor below.

climbingLeaderboard has the following parameter(s):

- int ranked[n]: the leaderboard scores
- int player[m]: the player's scores

<br><br>

## 입력
The first line contains an integer n, the number of players on the leaderboard.

The next line contains n space-separated integers ranked[i], the leaderboard scores in decreasing order.

The next line contains an integer, m, the number games the player plays.

The last line contains m space-separated integers player[j], the game scores.

<br><br>

## 출력
int[m]: the player's rank after each new score


