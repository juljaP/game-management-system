# 20 - 배열 대신 연결 리스트 자료구조 사용하기


## 실습 소스 및 결과

- src/main/java/com/eomcs/util/LinkedList.java 추가
- src/main/java/com/eomcs/lms/handler/GameHandler.java 변경
- src/main/java/com/eomcs/lms/handler/UserHandler.java 변경
- src/main/java/com/eomcs/lms/handler/BoardHandler.java 변경

## 실습

### 연결 리스트 자료구조를 구현.

- LinkedList.java.01
    - 연결 리스트 자료 구조를 구현한 클래스를 정의한다.


### LinkedList 클래스에 제네릭을 적용.

- LinkedList.java
    - ArrayList처럼 특정 타입의 값을 다루도록 제네릭을 적용한다.


### 훈련3. 핸들러 클래스는 ArrayList 대신 LinkedList를 사용하라.

- GameHandler.java
    - 수업 데이터를 저장하는 ArrayList를 LinkedList로 교체한다.
- UserHandler.java
    - 회원 데이터를 저장하는 ArrayList를 LinkedList로 교체한다.
- BoardHandler.java
    - 게시글 데이터를 저장하는 ArrayList를 LinkedList로 교체한다.