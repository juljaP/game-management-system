# 24_2 - `Iterator` 구현체와 스태틱 중첩 클래스(static nested class)

- 스태틱 중첩 클래스를 사용할 수 있다.
- 스태틱 중첩 클래스를 사용하여 인터페이스 구현체를 만들 수 있다.


## 결과

- src/main/java/julja/util/ListIterator.java 삭제
- src/main/java/julja/util/AbstractList.java 변경
- src/main/java/julja/util/StackIterator.java 삭제
- src/main/java/julja/util/Stack.java 변경
- src/main/java/julja/util/QueueIterator.java 삭제
- src/main/java/julja/util/Queue.java 변경


### 1. ListIterator 클래스를 AbstractList 클래스의 중첩클래스로 만들기

- AbstractList.java
  - ListIterator 클래스를 스태틱 중첩 클래스로 정의한다.
- ListIterator.java
  - 삭제한다.

### 2. QueueIterator 클래스를 Queue 클래스의 중첩클래스로 만들기

- Queue.java
  - QueueIterator 클래스를 스태틱 중첩 클래스로 정의한다.
- QueueIterator.java 
  - 삭제한다.

### 3. StackIterator 클래스를 Stack 클래스의 중첩클래스로 만들기

- Stack.java
  - StackIterator 클래스를 스태틱 중첩 클래스로 정의한다.
- StackIterator.java 
  - 삭제한다.
