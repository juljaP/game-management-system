# 26 - `커맨드(Command)` 디자인 패턴을 적용

##  결과

- src/main/java/julja/gms/handler/Command.java 추가
- src/main/java/julja/gms/handler/GameAddCommand.java 추가
- src/main/java/julja/gms/handler/GameListCommand.java 추가
- src/main/java/julja/gms/handler/GameDetailCommand.java 추가
- src/main/java/julja/gms/handler/GameUpdateCommand.java 추가
- src/main/java/julja/gms/handler/GameDeleteCommand.java 추가
- src/main/java/julja/gms/handler/UserAddCommand.java 추가
- src/main/java/julja/gms/handler/UserListCommand.java 추가
- src/main/java/julja/gms/handler/UserDetailCommand.java 추가
- src/main/java/julja/gms/handler/UserUpdateCommand.java 추가
- src/main/java/julja/gms/handler/UserDeleteCommand.java 추가
- src/main/java/julja/gms/handler/BoardAddCommand.java 추가
- src/main/java/julja/gms/handler/BoardListCommand.java 추가
- src/main/java/julja/gms/handler/BoardDetailCommand.java 추가
- src/main/java/julja/gms/handler/BoardUpdateCommand.java 추가
- src/main/java/julja/gms/handler/BoardDeleteCommand.java 추가
- src/main/java/julja/gms/handler/GameHandler.java 삭제
- src/main/java/julja/gms/handler/UserHandler.java 삭제
- src/main/java/julja/gms/handler/BoardHandler.java 삭제
- src/main/java/julja/gms/App.java 변경


### 1. 메서드를 호출하는 쪽과 실행 쪽 사이의 규칙을 정의하라.

- Command.java
    - `App` 클래스와 명령을 처리하는 클래스 사이의 호출 규칙을 정의한다.

### 2. 명령을 처리하는 각 메서드를 객체로 분리하라.

- GameHandler.java
    - 수업 CRUD 각 기능을 `Command` 규칙에 따라 객체로 분리한다.
- UserHandler.java
    - 수업 CRUD 각 기능을 `Command` 규칙에 따라 객체로 분리한다.
- BoardHandler.java
    - 수업 CRUD 각 기능을 `Command` 규칙에 따라 객체로 분리한다.
- App.java (App.java.01)
    - 명령어가 입력되면 `Command` 규칙에 따라 객체를 실행한다.
    - `/board2/xxx` 명령 처리는 삭제한다.

### 3: `Map`으로 `Command` 객체를 관리하라.

- App.java
    - 명령어를 `key`, `Command` 객체를 `value`로 하여 Map에 저장한다.
    - 각 명령에 대해 조건문으로 분기하는 부분을 간략하게 변경한다.