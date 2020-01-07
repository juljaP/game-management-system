package julja.gms.Handler;

import java.sql.Date;
import java.util.Scanner;
import julja.gms.domain.User;
import julja.util.ArrayList;

public class UserHandler {
  
  public Scanner input;
  ArrayList<User> userList;
  
  public UserHandler(Scanner input) {
    this.input = input;
    userList = new ArrayList<>();
  }

  public void addUser() {
    User u = new User();
    u.setUserNum(userList.getSize()); 
    System.out.print("이메일 : ");
    u.setUserEmail(input.nextLine());
    System.out.print("비밀번호 : ");
    u.setUserPW(input.nextLine());
    System.out.print("회원명 : ");
    u.setUserName(input.nextLine());
    System.out.print("가입일 : ");
    u.setUserResisteredDate(new Date(System.currentTimeMillis()));
    System.out.println(u.getUserResisteredDate());
    userList.add(u);
    System.out.println("저장하였습니다.");
    System.out.println();
  }

  public void listUser() {
    User[] arr = userList.toArray(new User[] {});
    for (User u : arr) {
      System.out.printf("[%d] %s | %s | %s\n", 
          u.getUserNum(), u.getUserEmail(), u.getUserName(), u.getUserResisteredDate());
    }
    System.out.println();
  }

}
