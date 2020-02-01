# 31_2 - 애플리케이션을 시작하거나 종료할 때 작업할 옵저버 추가

- 옵저버 디자인 패턴에 따라 옵저버를 정의

## 소스 및 결과

- src/main/java/julja/gms/DataLoaderListener.java 추가
- src/main/java/julja/gms/App.java 변경


### 1: 애플리케이션을 시작하거나 종료할 때 데이터를 로딩하고 저장할 옵저버 생성

- DataLoaderListener.java 추가
  - ApplicationContextListener를 구현
  - 테스트 할 용도로 간단하게 구현
  

### 2: DataLoaderListener 옵저버를 App 객체에 등록하고 실행 확인

- App.java 변경
  - DataLoaderListener 객체를 생성한 후 App 객체에 등록

### 3: DataLoaderListener 옵저버에서 데이터를 로딩하고 저장

- DataLoaderListener.java 변경
  - App 클래스에 있는 List 객체를 이 클래스로 옮김
  - App 클래스에 있는 데이터 로딩, 저장 관련 메서드를 이 클래스로 옮김
  
- App.java 변경
  - List 객체를 필드에서 제거
  - 데이터 로딩, 저장 관련 메서드를 제거
  - 데이터 로딩 호출 코드를 제거
  - 데이터 저장 호출 코드를 제거

### 4: App 클래스가 옵저버의 결과물 사용

ApplicationContextListener.java 
  - contextInitialized()에 Map 파라미터 추가
  - contextDestroyed()에 Map 파라미터 추가

### 5: DataLoaderListener의 작업 결과를 Map 객체를 통해 공유하라.

DataLoaderListener.java 
  - 데이터 로딩 결과를 Map 객체에 보관

### 6: DataLoaderListener에서 준비한 List 객체를 Command에게 전달

App.java
  - 애플리케이션이 시작될 때 옵저버를 실행한 후 Map 에 저장된 작업 결과를 꺼내
    Command 객체에 전달
    