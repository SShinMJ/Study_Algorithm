# Deque(덱/데크)
Deque는 Double-ended queue의 줄임말이다.
큐는 단방향 자료구조다. 단방향 연결리스트(Singly LinkedList)와 유사한 메커니즘이다.

반대로 Deque는 양방향 연결리스트(Doubly LinkedList)와 유사한 메커니즘이다. 앞서 말한 double-ended, 두 개의 종료 지점이 있다는 것. 한 마디로 단 방향으로 삽입 삭제가 이루어 진 것에서 양 쪽 방향으로 삽입 삭제가 이루어 질 수 있도록 구현 한 것이 Deque다.

양방향 큐. 즉 덱의 장점이라 하면 스택처럼 사용할 수도 있고 큐 처럼 사용할 수도 있는 자료구조다.

![image](https://user-images.githubusercontent.com/82142527/210203317-26f65952-e14a-4200-b889-c71589e6ce5f.png)
<br><br>

## Deque 생성
```
Deque<String> deque1 = new ArrayDeque<>();
Deque<String> deque2 = new LinkedBlockingDeque<>();
Deque<String> deque3 = new ConcurrentLinkedDeque<>();
Deque<String> linkedList = new LinkedList<>();
```

### Deque 값 추가 메서드
```
deque.addFirst(); // Deque의 앞쪽에 데이터를 삽입, 용량 초과시 Exception
deque.offerFirst(); //  Deque의 앞쪽에 데이터를 삽입 후 true, 용량 초과시 false

deque.addLast(); // Deque의 뒤쪽에 데이터를 삽입, 용량 초과시 Exception
deque.add(); // addLast()와 동일
deque.offerLast(); //Deque의 뒤쪽에 데이터를 삽입 후 true, 용량 초과시 false
deque.offer(); // offerLast()와 동일

deque.push(); // addFirst()와 동일
deque.pop(); // removeFirst()와 동일
```

### Deque 값 삭제 메서드
```
deque.removeFirst(); // Deque의 앞에서 제거, 비어있으면 예외
deque.remove(); // removeFirst()와 동일
deque.poll(); // Deque의 앞에서 제거, 비어있으면 null 리턴
deque.pollFirst(); // poll()과 동일

deque.removeLast(); // Deque의 뒤에서 제거, 비어있으면 예외
deque.pollLast(); // Deque의 뒤에서 제거, 비어있으면 null 리턴

// Deque의 앞쪽에서 찾아서 첫 번째 데이터를 삭제
deque.removeFirstOccurrence(Object o);

// Deque의 뒤쪽에서 찾아서 첫 번째 데이터를 삭제
deque.removeLastOccurrence(Object o);

// removeFirstOccurrence() 메소드와 동일
deque.remove(Object o);
```

### Deque 값 확인 메서드
```
deque.getFirst(); // 첫 번째 엘리먼트를 확인, 비어있으면 예외
deque.peekFirst(); // 첫 번째 엘리먼트를 확인, 비어있으면 null 리턴
deque.peek();// peekFirst()와 동일

deque.getLast(); // 마지막 엘리먼트를 확인, 비어있으면 예외
deque.peekLast();// 마지막 엘리먼트를 확인, 비어있으면 null 리턴

deque.contain(Object o); // Object 인자와 동일한 엘리먼트가 포함되어 있는지 확인
deque.size(); // Deque에 들어있는 엘리먼트의 개수
```

### Deque 순회
```
// for 문을 이용한 순회
for (String elem : deque1) {
  System.out.println(elem);
}

// Iterator를 이용한 순회
Iterator<String> iterator = deque1.iterator();
while (iterator.hasNext()) {
  String elem = iterator.next();
  System.out.println(elem);
}

// 역순순회 
Iterator<String> reverseIterator = deque1.descendingIterator();
while (reverseIterator.hasNext()) {
  String elem = reverseIterator.next();
  System.out.println(elem);
}
```