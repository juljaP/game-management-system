package julja.gms.Handler;

import java.util.List;
import julja.gms.domain.User;
import julja.util.Prompt;

public class UserUpdateCommand implements Command {

  Prompt prompt;
  List<User> userList;

  public UserUpdateCommand(Prompt prompt, List<User> list) {
    this.prompt = prompt;
    userList = list;
  }

  @Override
  public void execute() {
    int index = indexOfUser(prompt.inputInt("회원 번호? "));
    if (index == -1) {
      System.out.println("해당하는 유저가 존재하지 않습니다.");
      return;
    }
    User oldUser = userList.get(index);
    User newUser = new User();
    newUser.setUserNum(oldUser.getUserNum());
    newUser.setUserEmail(prompt.inputString(String.format("이메일(%s) : ", oldUser.getUserEmail()),
        oldUser.getUserEmail()));
    newUser.setUserPW(
        prompt.inputString(String.format("비밀번호(%s) : ", oldUser.getUserPW()), oldUser.getUserPW()));
    newUser.setUserName(prompt.inputString(String.format("회원명(%s) : ", oldUser.getUserName()),
        oldUser.getUserName()));
    newUser.setUserResisteredDate(oldUser.getUserResisteredDate());
    if (newUser.equals(oldUser)) {
      System.out.println("회원 정보 수정을 취소하였습니다.");
    } else {
      userList.set(index, newUser);
      System.out.println("회원 정보를 수정하였습니다.");
    }
  }

  private int indexOfUser(int num) {
    for (int i = 0; i < this.userList.size(); i++) {
      if (this.userList.get(i).getUserNum() == num) {
        return i;
      }
    }
    return -1;
  }

}
