# 문제4
자연수가 중복 없이 들어있는 배열이 있습니다. 이 배열에서 합이 K의 배수가 되도록 서로 다른 숫자 세개를 고르는 방법은 몇 가지인지 세려고 합니다.

자연수가 들어있는 배열 arr가 매개변수로 주어질 때, 이 배열에서 합이 K의 배수가 되도록 서로 다른 숫자 세개를 고르는 방법의 가짓수를 return 하도록 solution 메소드를 완성해주세요.

---
### 매개변수 설명
자연수가 들어있는 배열 arr가 solution 메소드의 매개변수로 주어집니다.
* arr의 길이는 3 이상 100 이하입니다.
* arr에는 1 이상 1,000 이하의 자연수가 중복 없이 들어있습니다.
* K는 1 이상 10 이하의 자연수입니다.

---
### return 값 설명
배열에서 합이 K의 배수가 되도록 서로 다른 숫자 세개를 고르는 방법의 가짓수를 return 해주세요.
* 그러한 방법이 없다면 0을 return 하면 됩니다.

---
### 예시

| arr             | K | return |
|-----------------|---|--------|
| [1, 2, 3, 4, 5] | 3 | 4      |

#### 예시 설명

다음과 같이 4가지 방법이 있습니다.

* 1 + 2 + 3 = 6
* 1 + 3 + 5 = 9
* 2 + 3 + 4 = 9
* 3 + 4 + 5 = 12
