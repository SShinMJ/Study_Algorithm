# HackerRank 'Forming a Magic Square'

<br>

## 문제
Flatland is a country with a number of cities, some of which have space stations. Cities are numbered consecutively and each has a road of  length connecting it to the next city. It is not a circular route, so the first city doesn't connect with the last city. Determine the maximum distance from any city to its nearest space station.

<br><br>

## 예시
n = 3<br>
c = [1]<br>
There are n=3 cities and city 1 has a space station. They occur consecutively along a route. City 0 is 1-0=1 unit away and city 2 is 2-1=1 units away. City 1 is 0 units from its nearest space station as one is located there. The maximum distance is 1.

<br><br>

## 기능 설명
Complete the flatlandSpaceStations function in the editor below.

flatlandSpaceStations has the following parameter(s):

- int n: the number of cities
- int c[m]: the indices of cities with a space station

<br><br>

## 입력
The first line consists of two space-separated integers, n and m.
The second line contains m space-separated integers, the indices of each city that has a space-station. These values are unordered and distinct.

<br><br>

## 출력
int: the maximum distance any city is from a space station

<br><br>

## 제약
There will be at least 1 city with a space station.
No city has more than one space station.
