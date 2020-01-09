# 19 - CRUD(Create/Retrieve/Update/Delete) 기능 완성

- src/main/java/com/eomcs/util/ArrayList.java 변경
- src/main/java/com/eomcs/lms/handler/GameHandler.java 변경
- src/main/java/com/eomcs/lms/handler/UserHandler.java 변경
- src/main/java/com/eomcs/lms/handler/BoardHandler.java 변경
- src/main/java/com/eomcs/lms/domain/Lesson.java 변경
- src/main/java/com/eomcs/lms/domain/Member.java 변경
- src/main/java/com/eomcs/lms/domain/Board.java 변경
- src/main/java/com/eomcs/lms/App.java 변경

### 작업1) ArrayList 클래스에 항목 값을 조회하고 변경하고 삭제하는 기능을 추가

- ArrayList.java
  - 목록의 특정 위치에 저장된 항목을 꺼내주는 get()을 정의한다.
  - 목록의 특정 위치에 저장된 항목을 바꾸는 set()을 정의한다.
  - 목록의 특정 위치에 저장된 항목을 삭제하는 remove()를 정의한다.


### 작업2) 게임 데이터의 상세조회, 변경, 삭제 기능을 추가하라.

- GameHandler.java
  - 상세조회 기능을 수행하는 detailLesson()을 정의한다.
  - 변경 기능을 수행하는 updateLesson()을 정의한다.
  - 삭제 기능을 수행하는 deleteLesson()을 정의한다.
- App.java
  - 상세조회, 변경, 삭제 명령에 대한 분기문을 추가한다.

#### 실행 결과

명령> /game/list
[1] 프린세스 메이커 | 코에이 | 2000-02-02 | 육성
[2] 뿌요뿌요 | - | 2003-10-10 | -

명령> /game/detail
게임 인덱스? 0
품번 : 1
게임명 : 프린세스 메이커
제작사 : 코에이
발매일 : 2000-02-02
플랫폼 : PC
장르 : 육성
작화 : -
음성 : -

명령> /game/detail
게임 인덱스? 10
해당하는 게임이 존재하지 않습니다.

명령> /game/update
게임 인덱스? 1
품번(2)? 
게임명(뿌요뿌요)? 
제작사(-)? 세가
발매일(2003-10-10)? 2000-09-20
플랫폼(PC)? 
장르(-)? 퍼즐
작화(-)? 
음성(-)? 
게임 정보를 변경했습니다.

명령> /game/update
게임 인덱스? 20
해당하는 게임이 존재하지 않습니다.

명령> /game/delete
게임 인덱스? 1
게임 정보를 삭제했습니다.

명령> /game/delete
게임 인덱스? 20
해당하는 게임이 존재하지 않습니다.


### 작업3) GameHandler 코드를 리팩토링하라.

- GameHandler.java
    - 저장된 목록에서 수업 번호로 항목을 찾는 코드를 indexOfLesson() 메서드로 분리한다.


### 작업4) 유저 데이터의 상세조회, 변경, 삭제 기능을 추가하라.

- UserHandler.java
    - 상세조회 기능을 수행하는 detailMember()을 정의한다.
    - 변경 기능을 수행하는 updateMember()을 정의한다.
    - 삭제 기능을 수행하는 deleteMember()을 정의한다.
    - 저장된 목록에서 회원 번호로 항목을 찾는 indexOfMember()를 정의한다.
- App.java
    - 상세조회, 변경, 삭제 명령에 대한 분기문을 추가한다.

#### 실행 결과

명령> /user/list
[1] aaa@naver.com | 가나다 | 2020-01-09
[2] bbb@gmail.com | 라마바 | 2020-01-09
[3] ccc@daum.net | 사아자 | 2020-01-09

명령> /user/detail
회원 번호? 1
이메일 : aaa@naver.com
비밀번호 : aaa
회원명 : 가나다
가입일 : 2020-01-09

명령> /user/detail
회원 번호? 50
해당하는 유저가 존재하지 않습니다.


명령> /user/update
회원 번호? 1
이메일(aaa@naver.com) : 111@naver.com
비밀번호(aaa) :    <=== 입력하지 않으면 기존 값 사용
회원명(가나다) : 
회원 정보를 수정하였습니다.

명령> /user/update
회원 번호? 30
해당하는 유저가 존재하지 않습니다.

명령> /user/delete
회원 번호? 1
회원 정보를 삭제하였습니다.

명령> /user/delete
회원 번호? 40
해당하는 유저가 존재하지 않습니다.

### 작업5) 게시글 데이터의 상세조회, 변경, 삭제 기능을 추가하라.

- BoardHandler.java
    - 상세조회 기능을 수행하는 detailBoard()을 정의한다.
    - 변경 기능을 수행하는 updateBoard()을 정의한다.
    - 삭제 기능을 수행하는 deleteBoard()을 정의한다.
    - 저장된 목록에서 회원 번호로 항목을 찾는 indexOfBoard()를 정의한다.
- App.java
    - 상세조회, 변경, 삭제 명령에 대한 분기문을 추가한다.

#### 실행 결과

명령> /board/list
[1] 게시글입니다. | 111 | 0 
[2] 두 번째 게시글입니다. | 222 | 0 
[3] 세 번째 게시글입니다. | 333 | 0 

명령> /board/detail
게시글 번호 ? 1
제목 : 게시글입니다.
내용 : 111
조회수 : 0

명령> /board/detail
게시글 번호 ? 45
유효한 게시물 번호가 아닙니다.

명령> /board/update
게시글 번호 ? 1
내용(111)? 
게시글 변경을 취소했습니다.

명령> /board/update
게시글 번호 ? 20
유효한 게시물 번호가 아닙니다.

명령> /board/delete
게시글 번호 ? 1
게시글을 삭제했습니다.

명령> /board/delete
게시글 번호 ? 10
유효한 게시물 번호가 아닙니다.

