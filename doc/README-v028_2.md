# 28_2 - 파일 입출력 API의 활용 + CSV 문자열을 객체로 전환하는 기능을 도메인 객체로 이전 

##결과

- src/main/java/julja/gms/lms/App.java 변경
- src/main/java/julja/gms/domain/Board.java 변경
- src/main/java/julja/gms/domain/User.java 변경
- src/main/java/julja/gms/domain/Game.java 변경 

### 1: 게시물 데이터를 CSV 문자열로 다루는 코드를 Board 클래스로 옮겨라.  

- Board.java
  - CSV 문자열을 가지고 Board 객체를 생성하는 valueOf() 를 추가한다.
  - Board 객체를 가지고 CSV 문자열을 리턴하는 toCsvString() 를 추가한다.
- App.java
  - loadBoardData() 를 변경한다.
  - saveBoardData() 를 변경한다.

### 2: 유저 데이터를 CSV 문자열로 다루는 코드를 User 클래스로 옮겨라.  

- User.java
  - CSV 문자열을 가지고 User 객체를 생성하는 valueOf() 를 추가한다.
  - User 객체를 가지고 CSV 문자열을 리턴하는 toCsvString() 를 추가한다.
- App.java
  - loadUserData() 를 변경한다.
  - saveUserData() 를 변경한다.
  
### 3: 게임 데이터를 CSV 문자열로 다루는 코드를 Game 클래스로 옮겨라.  

- Board.java
  - CSV 문자열을 가지고 Game 객체를 생성하는 valueOf() 를 추가한다.
  - Game 객체를 가지고 CSV 문자열을 리턴하는 toCsvString() 를 추가한다.
- App.java
  - loadGameData() 를 변경한다.
  - saveGameData() 를 변경한다.