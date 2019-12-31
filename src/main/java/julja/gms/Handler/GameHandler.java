package julja.gms.Handler;

import java.sql.Date;
import java.util.Scanner;
import julja.gms.domain.Game;

public class GameHandler {
  
  public Scanner input;
  GameList gameList;
  
  public GameHandler (Scanner input) {
    this.input = input;
    gameList = new GameList();
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
    Game[] arr = gameList.toArray();
    for(Game g1 : arr) {
      System.out.printf("[%d] %s | %s | %s | %s\n", 
          g1.getGameNum(), g1.getGameName(), g1.getGameProduction(), g1.getGameDate(), g1.getGameGenre());
    }
    System.out.println();
  }

}
