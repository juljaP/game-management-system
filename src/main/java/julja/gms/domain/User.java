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
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
    result = prime * result + ((userName == null) ? 0 : userName.hashCode());
    result = prime * result + userNum;
    result = prime * result + ((userPW == null) ? 0 : userPW.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    if (userEmail == null) {
      if (other.userEmail != null)
        return false;
    } else if (!userEmail.equals(other.userEmail))
      return false;
    if (userName == null) {
      if (other.userName != null)
        return false;
    } else if (!userName.equals(other.userName))
      return false;
    if (userNum != other.userNum)
      return false;
    if (userPW == null) {
      if (other.userPW != null)
        return false;
    } else if (!userPW.equals(other.userPW))
      return false;
    return true;
  }

}
