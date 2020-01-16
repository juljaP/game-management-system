# 24_3 - `Iterator` 구현체와 논스태틱 중첩 클래스(non-static nested class; inner class)

- 논스태틱 중첩 클래스를 사용
- 스태틱 중첩 클래스와 논스태틱 중첩 클래스 사이의 차이점 이해
- 논스태틱 중첩 클래스를 사용하여 인터페이스 구현체를 만들기


## 결과

- src/main/java/julja/util/AbstractList.java 변경
- src/main/java/julja/util/Stack.java 변경
- src/main/java/julja/util/Queue.java 변경


### 1. ListIterator 중첩 클래스를 논스태틱 중첩클래스로 만들기

- AbstractList.java
  - ListIterator 클래스를 논스태틱 중첩 클래스로 변경
  - iterator() 메서드를 변경

### 2. QueueIterator 중첩 클래스를 논스태틱 중첩클래스로 만들기

- Queue.java
  - QueueIterator 클래스를 논스태틱 중첩 클래스로 변경
  - iterator() 메서드를 변경

### 3. StackIterator 중첩 클래스를 논스태틱 중첩클래스로 만들기

- Stack.java
  - StackIterator 클래스를 논스태틱 중첩 클래스로 변경
  - iterator() 메서드를 변경
