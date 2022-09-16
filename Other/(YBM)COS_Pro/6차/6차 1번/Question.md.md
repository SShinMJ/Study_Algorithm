# 문제1
n x n 크기 격자 모양 정원에 칸마다 핀 꽃 또는 피지 않은 꽃을 심었습니다. 이 정원의 꽃이 모두 피는 데 며칠이 걸리는지 알고 싶습니다. 핀 꽃은 하루가 지나면 앞, 뒤, 양옆 네 방향에 있는 꽃을 피웁니다. 
정원 크기 n과 현재 정원의 상태를 담은 2차원 배열 garden이 주어졌을 때, 모든 꽃이 피는데 며칠이 걸리는지 return 하도록 solution 메소드를 작성해주세요.

---
### 매개변수 설명
정원 크기 n과 현재 정원 상태를 담은 2차원 배열 garden이 solution 메소드의 매개변수로 주어집니다.
* 정원 크기 n은 1보다 크고 100 보다 작거나 같은 자연수입니다.
* 정원 상태를 담은 2차원 배열 garden의 원소는 0 또는 1 입니다.
* 이미 핀 꽃은 1로 아직 피지 않은 꽃은 0으로 표현합니다.
* 정원에 최소 꽃 한 개는 피어 있습니다.

---
### return 값 설명
꽃이 모두 피는데 며칠이 걸리는지 return 합니다.

---
### 예시

| n | garden                        	| return |
|---|-----------------------------------|--------|
| 3 | [[0, 0, 0], [0, 1, 0], [0, 0, 0]] | 2  	|
| 2 | [[1, 1], [1, 1]]              	| 0  	|

#### 예시 설명
예시 #1  
첫 날 정원은 아래와 같습니다.
  ![ex1-1.jpg](https://grepp-programmers.s3.amazonaws.com/files/ybm/37bda7d9f3/31e62cd8-a1f4-4b48-bc9f-77760bab6d95.jpg)  

1일이 지난 정원의 상태는 아래와 같습니다.
  ![ex1-2.jpg](https://grepp-programmers.s3.amazonaws.com/files/ybm/ecc95dcb73/92fc1442-9e02-4cc9-9283-a268e5b17c95.jpg)  

2일이 지난 정원의 상태는 아래와 같습니다.
  ![ex1-3.jpg](https://grepp-programmers.s3.amazonaws.com/files/ybm/d5956891e7/e51e8c3b-2658-46f5-a339-7dba4f2e5aa1.jpg)  

따라서, 2일이 지나면 정원의 모든 꽃이 핍니다.

예시 #2  
첫 날 화단의 상태는 아래와 같습니다.
  ![ex2-1.jpg](https://grepp-programmers.s3.amazonaws.com/files/ybm/9911040aaf/db95217b-f1b7-4ab3-b932-d15133431346.jpg)  

따라서, 0일이 지나면 정원의 모든 꽃이 핍니다.