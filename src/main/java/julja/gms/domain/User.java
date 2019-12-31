package julja.gms.domain;

import java.sql.Date;

public class User {
  
  private int userNum;
  private String userEmail, userPW, userName;
  private Date userResisteredDate;
  
  public int getUserNum() {
    return userNum;
  }
  public void setUserNum(int userNum) {
    this.userNum = userNum;
  }
  public String getUserEmail() {
    return userEmail;
  }
  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }
  public String getUserPW() {
    return userPW;
  }
  public void setUserPW(String userPW) {
    this.userPW = userPW;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public Date getUserResisteredDate() {
    return userResisteredDate;
  }
  public void setUserResisteredDate(Date userResisteredDate) {
    this.userResisteredDate = userResisteredDate;
  }

}
