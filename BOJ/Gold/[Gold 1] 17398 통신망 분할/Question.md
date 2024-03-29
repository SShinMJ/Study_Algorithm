# 백준 17398번 '통신망 분할'

## 제한
![image](https://user-images.githubusercontent.com/82142527/181660843-16413d76-6ae5-400f-8093-c11ea7fbf8f1.png)  
<br>
## 문제
BOJ의 인기스타, 방송인 권욱제는 통신 회사에 취업했다. 현재 이 통신 회사는 너무나 큰 통신망을 한 지사에서 관리하느라 큰 비용을 지불하고 있었다. 그래서 회사는 최근 IT의 트렌드 중 하나인 '탈중앙화'에 편승하여, 통신망을 분할하도록 결정했다. 그래서 욱제한테 통신망을 분할 할때 발생하는 비용을 분석하도록 지시했다.

현재 회사 망에는 1번부터 N번까지 총 N개의 통신 탑이 존재하며, 통신탑 간의 연결이 M개 존재한다. 이때 회사에서는 총 Q번 통신탑 간의 연결을 제거함으로써 하나의 통신망을 여러 개의 통신망으로 분리하려고 한다. 통신망이란, 통신탑의 연결을 통해 도달 가능한 통신탑들의 집합이다. 통신탑 간의 연결 관계를 제거할 때 드는 비용은 제거한 후 통신망이 두 개로 나누어진다면 나눠진 두 개의 통신망에 속한 통신탑들의 갯수의 곱이 되며, 나누어지지 않을 경우 0이다.  
  
![image](https://user-images.githubusercontent.com/82142527/181660868-6b98c9a5-1a4d-4156-afa7-de0daf88043f.png)  
  
그림 1을 예시로 할때, 연결 (3, 4)를 제거하면 {1, 2, 3}, {4, 5, 6}으로 분할 되며, 이때 발생하는 비용은 3 × 3 = 9가 된다. 대신 연결 (2, 3)을 제거하면, 망이 나눠지지 않았기에 비용은 0이 된다.

욱제는 회사의 요청에 따라 Q번의 제거를 통해 나오는 비용의 합을 구해야 한다. 하지만 욱제는 회사의 통신망을 이용해 방송하기 바쁘기 때문에 우리가 도와주자.

## 입력
첫 번째 줄에는 통신탑의 개수인 자연수 N, 통신탑 사이의 연결의 개수인 자연수 M, 통신망 연결 분할 횟수인 자연수 Q가 공백으로 구분되어 주어진다. (1 ≤ N ≤ 100,000, 1 ≤ M ≤ 100,000, 1 ≤ Q ≤ M)

두 번째 줄부터 M개의 줄에 걸쳐 두 개의 자연수 X, Y가 공백으로 구분되어 주어진다. 이는 X 통신탑과 Y 통신탑 사이에 연결이 있음을 뜻한다. (1 ≤ X, Y ≤ N, X ≠ Y)

중복된 연결은 주어지지 않으며, 모든 통신탑은 처음엔 하나의 통신망에 속한다. 조건에 의해 자기 자신과 연결이 있는 통신탑은 없다.

그 다음 줄부터 Q개의 줄에 걸쳐 제거될 연결의 번호인 자연수 A가 주어진다. 이는 A번째로 입력된 (X, Y)의 연결이 제거되었음을 의미한다. (1 ≤ A ≤ M)

이미 제거된 연결은 다시 제거되지 않으며, 제거는 입력 순서대로 진행된다.

## 출력
첫 번째 줄에 Q개의 연결을 순서대로 제거하는데 드는 비용의 합을 출력한다.

<br> 

### 예제 입력 1
```
4 4 3
1 2
2 3
3 4
1 4
4
2
3
```  
첫 번째로 제거되는 연결은 (1, 4)로, 통신망 {1, 2, 3, 4}가 분리되지 않아 비용이 0이다.

두 번째로 제거되는 연결은 (2, 3)으로, 통신망 {1, 2, 3, 4}가 {1, 2}와 {3, 4}로 분리되어 비용이 2 × 2 = 4이다.

세 번째로 제거되는 연결은 (3, 4)로, 통신망 {3, 4}가 {3}과 {4}로 분리되어 비용이 1 × 1 = 1이다.

결과적으로 총 비용은 0 + 4 + 1 = 5이다.
  
### 예제 출력 1 
```
5
```
