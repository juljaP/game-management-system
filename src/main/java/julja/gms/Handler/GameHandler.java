package julja.gms.Handler;

import java.sql.Date;
import java.util.Scanner;
import julja.gms.domain.Game;

public class GameHandler {
  
  public Scanner input;
  ArrayList gameList;
  
  public GameHandler (Scanner input) {
    this.input = input;
    gameList = new ArrayList();
  }

  public void addGame() {
    Game g = new Game();
    System.out.print("품번 : ");
    g.setGameNum(input.nextInt());
    input.nextLine();
    System.out.print("게임명 : ");
    g.setGameName(input.nextLine());
    System.out.print("제작사 : ");
    g.setGameProduction(input.nextLine()); 
    System.out.print("발매일 : ");
    g.setGameDate(Date.valueOf(input.next()));
    input.nextLine();
    System.out.print("플랫폼 : ");
    g.setGamePlatform(input.nextLine()); 
    System.out.print("장르 : ");
    g.setGameGenre(input.nextLine()); 
    System.out.print("작화 : ");
    g.setGameIllust(input.nextLine()); 
    System.out.print("음성 : ");
    g.setGameVoice(input.nextLine());
    System.out.println("저장하였습니다.");
    System.out.println();
    gameList.add(g);
  }

  public void listGame() {
    Object[] arr = gameList.toArray();
    for(Object obj : arr) {
      Game g = (Game)obj;
      System.out.printf("[%d] %s | %s | %s | %s\n", 
          g.getGameNum(), g.getGameName(), g.getGameProduction(), g.getGameDate(), g.getGameGenre());
    }
    System.out.println();
  }

}
