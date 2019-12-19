package julja.gms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    final int SIZE = 5000;
    /*
    class User {
      int userNum;
      String userEmail, userPW, userName;
      Date userResisteredDate;
    }
    */
    User[] users = new User[SIZE];
    for (int i = 0 ; i < SIZE ; i++) {
      users[i] = new User();
    }

    int count = 0;

    for (int i = 0 ; i < SIZE ; i++) {
      User u = users[i];
      u.userNum = i+1; 
      System.out.print("이메일 : ");
      u.userEmail = sc.nextLine();
      System.out.print("비밀번호 : ");
      u.userPW = sc.nextLine();
      System.out.print("회원명 : ");
      u.userName = sc.nextLine();
      System.out.print("가입일 : ");
      u.userResisteredDate = new Date(System.currentTimeMillis());
      System.out.print(u.userResisteredDate);

      count++;

      System.out.println();
      System.out.println();
      System.out.print("계속 입력하시겠습니까?(Y|N) ");
      String res = sc.nextLine();
      if (res.equalsIgnoreCase("Y")) {
        System.out.println();
        continue;
      } else {
        sc.close();
        break;
      }
    }
    System.out.println();
    for (int i = 0 ; i < count ; i++) {
      User u = users[i];
      System.out.printf("[%d] %s | %s | %s\n", 
          u.userNum, u.userEmail, u.userName, u.userResisteredDate);
    }
  }
}



