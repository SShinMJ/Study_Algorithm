# 문제1
정수로 이루어진 두 배열 arrA와 arrB가 주어질 때, arrA를 회전해 arrB로 만들 수 있는지 알아보려 합니다. 배열의 회전이란 모든 원소를 오른쪽으로 한 칸씩 이동시키고, 마지막 원소는 배열의 맨 앞에 넣는 것을 말합니다.  

 ![rotation.png](https://grepp-programmers.s3.amazonaws.com/files/ybm/50aabfa035/b041b68c-8e36-4f50-9b3f-2e097cd872a3.png)  

이를 위해 다음과 같이 프로그램 구조를 작성했습니다.

~~~
1. arrA와 arrB의 길이가 다르면 false를 return 합니다.
2. 두 배열의 구성 성분이 달라 회전했을 때 같아질 가능성이 없다면 false를 return 합니다.
3. arrA 배열을 두 번 이어 붙여 길이가 2배인 배열로 만듭니다.
4. arrA의 부분 배열 중 arrB와 같은 배열이 있으면 true를, 그렇지 않으면 false를 return 합니다.
~~~

두 배열 arrA와 arrB가 매개변수로 주어질 때, arrA를 회전해 arrB로 만들 수 있으면 true를, 그렇지 않으면 false를 return 하도록 solution 메소드를 작성하려 합니다. 위 구조를 참고하여 코드가 올바르게 동작할 수 있도록 빈칸에 주어진 func_a, func_b, func_c 메소드와 매개변수를 알맞게 채워주세요.

---
### 매개변수 설명
두 배열 arrA와 arrB가 solution 메소드의 매개변수로 주어집니다.
* arrA의 길이는 1 이상 1,000 이하입니다.
* arrA의 원소는 0 이상 1,000 이하의 정수입니다.
* arrB의 길이는 1 이상 1,000 이하입니다.
* arrB의 원소는 0 이상 1,000 이하의 정수입니다.

---
### return 값 설명
arrA를 회전해 arrB로 만들 수 있으면 true를, 그렇지 않으면 false를 return 해주세요.

---
### 예시

| arrA         | arrB          | return |
|--------------|---------------|--------|
| [1, 2, 3, 4] | [3, 4, 1, 2]  | true   |
| [1, 2, 3, 4] | [1, 4, 2, 3]  | false  |

#### 예시 설명
예시 #1  
arrA 배열을 오른쪽으로 2칸 회전하면 arrB와 같아집니다.

예시 #2  
arrA 배열은 회전해도 arrB와 같아질 수 없습니다.