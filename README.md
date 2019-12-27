# 13 - 인스턴스 필드와 인스턴스 메서드가 필요한 이유

- src/main/java/com/eomcs/lms/handler/BoardHandler.java 변경
- src/main/java/com/eomcs/lms/handler/GameHandler.java 변경
- src/main/java/com/eomcs/lms/handler/MemberHandler.java 변경
- src/main/java/com/eomcs/lms/handler/BoardHandler2.java 삭제
- src/main/java/com/eomcs/lms/App.java 변경


### 작업1) 인스턴스 멤버를 활용하여 새 게시판 추가

- BoardHandler.java
    - 게시판 마다 게시글을 개별적으로 다룰 수 있도록 필드를 인스턴스 멤버로 전환한다.
    - 인스턴스 필드를 다루기 위해 클래스 메서드를 인스턴스 메서드로 전환한다.
- App.java (App.java.01)
    - `BoardHandler` 클래스의 변화에 맞추어 코드를 변경한다.
- BoardHandler2.java
    - 삭제한다.

### 작업2) 핸들러의 스태틱 멤버를 인스턴스 필드와 인스턴스 메서드로 전환하라.

- GameHandler.java
    - 필드와 메서드를 인스턴스 멤버로 전환한다.
- UserHandler.java    
    - 필드와 메서드를 인스턴스 멤버로 전환한다.
- App.java
    - `LessonHandler`와 `MemberHandler` 클래스의 변화에 맞추어 코드를 변경한다.
