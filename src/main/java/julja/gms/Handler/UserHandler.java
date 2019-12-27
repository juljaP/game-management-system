package julja.gms.Handler;

import java.sql.Date;
import java.util.Scanner;
import julja.gms.domain.User;


public class UserHandler {

  User[] users = new User[SIZE];
  int user_count = 0;
  
  static final int SIZE = 100;
  static public Scanner sc;

  public void addUser() {
    User u = new User();
    u.userNum = this.user_count+1; 
    System.out.print("이메일 : ");
    u.userEmail = sc.nextLine();
    System.out.print("비밀번호 : ");
    u.userPW = sc.nextLine();
    System.out.print("회원명 : ");
    u.userName = sc.nextLine();
    System.out.print("가입일 : ");
    u.userResisteredDate = new Date(System.currentTimeMillis());
    System.out.println(u.userResisteredDate);
    this.users[this.user_count++] = u;
    System.out.println("저장하였습니다.");
    System.out.println();
  }

  public void listUser() {
    for (int i = 0 ; i < this.user_count ; i++) {
      User u1 = this.users[i];
      System.out.printf("[%d] %s | %s | %s\n", 
          u1.userNum, u1.userEmail, u1.userName, u1.userResisteredDate);
    }
    System.out.println();
  }

}
