# 24_4 - `Iterator` 구현체와 로컬 클래스(local class)

## 학습 목표

- 로컬 클래스 사용
- 로컬 클래스의 용도 이해

## 결과

- src/main/java/julja/util/AbstractList.java 변경
- src/main/java/julja/util/Stack.java 변경
- src/main/java/julja/util/Queue.java 변경


### 1. ListIterator 논스태틱 중첩클래스를 로컬 클래스로 만들기

- AbstractList.java
  - iterator() 메서드 변경

### 2. QueueIterator 논스태틱 중첩클래스를 로컬 클래스로 만들기

- Queue.java
  - iterator() 메서드 변경

### 3. StackIterator 논스태틱 중첩클래스를 로컬 클래스로 만들기

- Stack.java
  - iterator() 메서드 변경
