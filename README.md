# 10 - 클래스로 메서드를 분류하기

### 작업1) 게임 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라.

- GameHandler.java
    - 게임 관리와 관련된 메서드를 담을 클래스를 만든다.
    - `App.java` 에서 수업관리와 관련된 변수와 메서드를 `GameHandler` 클래스로 옮긴다.
- App.java (App.java.01)
    - `GameHandler` 클래스 사용한다.


### 작업2) 회원 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라.

- UserHandler.java
    - 회원 관리와 관련된 메서드를 담을 클래스를 만든다.
    - `App.java` 에서 회원관리와 관련된 변수와 메서드를 `UserHandler` 클래스로 옮긴다.
- App.java (App.java.02)
    - `UserHandler` 클래스 사용한다.


### 작업3) 게시물 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라.

- BoardHandler.java
    - 게시물 관리와 관련된 메서드를 담을 클래스를 만든다.
    - `App.java` 에서 게시물관리와 관련된 변수와 메서드를 `BoardHandler` 클래스로 옮긴다.
- App.java
    - `BoardHandler` 클래스 사용한다.
