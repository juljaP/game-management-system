package julja.gms.domain;

import java.sql.Date;

public class Game {
  
  private int gameNum;
  private String gameName, gameProduction, gamePlatform, gameGenre, gameIllust, gameVoice;
  private Date gameDate;
  
  public int getGameNum() {
    return gameNum;
  }
  public void setGameNum(int gameNum) {
    this.gameNum = gameNum;
  }
  public String getGameName() {
    return gameName;
  }
  public void setGameName(String gameName) {
    this.gameName = gameName;
  }
  public String getGameProduction() {
    return gameProduction;
  }
  public void setGameProduction(String gameProduction) {
    this.gameProduction = gameProduction;
  }
  public String getGamePlatform() {
    return gamePlatform;
  }
  public void setGamePlatform(String gamePlatform) {
    this.gamePlatform = gamePlatform;
  }
  public String getGameGenre() {
    return gameGenre;
  }
  public void setGameGenre(String gameGenre) {
    this.gameGenre = gameGenre;
  }
  public String getGameIllust() {
    return gameIllust;
  }
  public void setGameIllust(String gameIllust) {
    this.gameIllust = gameIllust;
  }
  public String getGameVoice() {
    return gameVoice;
  }
  public void setGameVoice(String gameVoice) {
    this.gameVoice = gameVoice;
  }
  public Date getGameDate() {
    return gameDate;
  }
  public void setGameDate(Date gameDate) {
    this.gameDate = gameDate;
  }

}
