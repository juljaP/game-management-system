# 25 - 자바 컬렉션 API 사용하기

- 자바에서 제공하는 자료구조 구현체 활용

## 결과

- src/main/java/julja/util/List.java 삭제
- src/main/java/julja/util/AbstractList.java 삭제
- src/main/java/julja/util/ArrayList.java 삭제
- src/main/java/julja/util/LinkedList.java 삭제
- src/main/java/julja/util/Iterator.java 삭제
- src/main/java/julja/util/Stack.java 삭제
- src/main/java/julja/util/Queue.java 삭제
- src/main/java/julja/util 삭제
- src/main/java/julja/gms/handler/LessonHandler.java 변경
- src/main/java/julja/gms/handler/MemberHandler.java 변경
- src/main/java/julja/gms/handler/BoardHandler.java 변경
- src/main/java/julja/gms/App.java 변경


### 1. ArrayList, LinkedList, Stack, Queue 클래스를 자바 컬렉션 API로 교체하라.

- LessonHandler.java
    - `List` 를 `java.util.List` 인터페이스로 교체한다.
- MemberHandler.java
    - `List` 를 `java.util.List` 인터페이스로 교체한다.
- BoardHandler.java
    - `List` 를 `java.util.List` 인터페이스로 교체한다.
- App.java
    - 핸들러를 생성할 때 자바 컬렉션 API에서 제공하는 `java.util.List`의 구현체를 넘겨준다.
    - 명령 내역을 저장할 때도 자바 컬렉션 API의 Stack과 Queue 구현체를 사용한다.
