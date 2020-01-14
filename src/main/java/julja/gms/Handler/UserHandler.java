package julja.gms.Handler;

import java.sql.Date;
import julja.gms.domain.User;
import julja.util.AbstractList;
import julja.util.Prompt;

public class UserHandler {

  Prompt prompt;
  AbstractList<User> userList;

  public UserHandler(Prompt prompt, AbstractList<User> list) {
    this.prompt = prompt;
    userList = list;
  }

  public void addUser() {
    User u = new User();
    u.setUserNum(userList.getSize()+1); 

    u.setUserEmail(prompt.inputString("이메일 : "));
    u.setUserPW(prompt.inputString("비밀번호 : "));
    u.setUserName(prompt.inputString("회원명 : "));
    System.out.print("가입일 : ");
    u.setUserResisteredDate(new Date(System.currentTimeMillis()));
    System.out.println(u.getUserResisteredDate());
    userList.add(u);
    System.out.println("저장하였습니다.");
    System.out.println();
  }

  public void listUser() {
    User[] arr = (User[]) userList.toArray(new User[] {});
    for (User u : arr) {
      System.out.printf("[%d] %s | %s | %s\n", 
          u.getUserNum(), u.getUserEmail(), u.getUserName(), u.getUserResisteredDate());
    }
    System.out.println();
  }

  public void detailUser() {
    int index = indexOfUser(prompt.inputInt("회원 번호? "));
    if(index == -1) {
      System.out.println("해당하는 유저가 존재하지 않습니다.");
      System.out.println();
      return;
    }
    User u = userList.get(index);
    System.out.printf("이메일 : %s\n", u.getUserEmail());
    System.out.printf("비밀번호 : %s\n", u.getUserPW());
    System.out.printf("회원명 : %s\n", u.getUserName());
    System.out.printf("가입일 : %s\n", u.getUserResisteredDate());
    System.out.println();
  }

  public void updateUser() {
    int index = indexOfUser(prompt.inputInt("회원 번호? "));
    if(index == -1) {
      System.out.println("해당하는 유저가 존재하지 않습니다.");
      System.out.println();
      return;
    }
    User oldUser = userList.get(index);
    User newUser = new User();
    newUser.setUserNum(oldUser.getUserNum());
    newUser.setUserEmail(prompt.inputString
        (String.format("이메일(%s) : ", oldUser.getUserEmail()), oldUser.getUserEmail()));
    newUser.setUserPW(prompt.inputString
        (String.format("비밀번호(%s) : ", oldUser.getUserPW()), oldUser.getUserPW()));
    newUser.setUserName(prompt.inputString
        (String.format("회원명(%s) : ", oldUser.getUserName()), oldUser.getUserName()));
    newUser.setUserResisteredDate(oldUser.getUserResisteredDate());
    if(newUser.equals(oldUser)) {
      System.out.println("회원 정보 수정을 취소하였습니다.");
    } else {
      userList.set(index, newUser);
      System.out.println("회원 정보를 수정하였습니다.");
    }
    System.out.println();
  }

  public void deleteUser() {
    int index = indexOfUser(prompt.inputInt("회원 번호? "));
    if(index == -1) {
      System.out.println("해당하는 유저가 존재하지 않습니다.");
      System.out.println();
      return;
    }
    userList.remove(index);
    System.out.println("회원 정보를 삭제하였습니다.");
    System.out.println();
  }

  private int indexOfUser(int num) {
    for (int i = 0 ; i < this.userList.getSize() ; i++) {
      if(this.userList.get(i).getUserNum() == num) {
        return i;
      }
    }
    return -1;
  }

}
