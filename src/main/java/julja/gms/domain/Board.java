package julja.gms.domain;

import java.sql.Date;

public class Board {
  
  private String bbsName, bbsText;
  private Date today;
  private int bbsNum, bbsHits;
  
  public String getBbsName() {
    return bbsName;
  }
  public void setBbsName(String bbsName) {
    this.bbsName = bbsName;
  }
  public String getBbsText() {
    return bbsText;
  }
  public void setBbsText(String bbsText) {
    this.bbsText = bbsText;
  }
  public Date getToday() {
    return today;
  }
  public void setToday(Date today) {
    this.today = today;
  }
  public int getBbsNum() {
    return bbsNum;
  }
  public void setBbsNum(int bbsNum) {
    this.bbsNum = bbsNum;
  }
  public int getBbsHits() {
    return bbsHits;
  }
  public void setBbsHits(int bbsHits) {
    this.bbsHits = bbsHits;
  }

}
