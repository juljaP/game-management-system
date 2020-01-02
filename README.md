17 - 다형성과 형변환 응용

### Game, User, Board를 모두 처리할 수 있는 List 클래스를 만들라.

- ArrayList.java
    - LessonList, MemberList, BoardList 클래스를 합쳐 한 클래스로 만든다.
- GameHandler.java
    - `ArrayList` 클래스를 사용하여 데이터를 처리한다.
- UserHandler.java
    - `ArrayList` 클래스를 사용하여 데이터를 처리한다.
- BoardHandler.java
    - `ArrayList` 클래스를 사용하여 데이터를 처리한다.

#### 실행 결과

`App` 클래스의 실행 결과는 이전 버전과 같다.

## 실습 소스

- src/main/java/com/eomcs/lms/handler/ArrayList.java 추가
- src/main/java/com/eomcs/lms/handler/GameList.java 삭제
- src/main/java/com/eomcs/lms/handler/UserList.java 삭제
- src/main/java/com/eomcs/lms/handler/BoardList.java 삭제
- src/main/java/com/eomcs/lms/handler/GameHandler.java 변경
- src/main/java/com/eomcs/lms/handler/UserHandler.java 변경
- src/main/java/com/eomcs/lms/handler/BoardHandler.java 변경