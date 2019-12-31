package julja.gms.Handler;

import java.sql.Date;
import java.util.Scanner;
import julja.gms.domain.Game;

public class GameHandler {

  Game[] games;
  int game_count = 0;
  
  static final int SIZE = 100;
  public Scanner input;
  
  public GameHandler (Scanner input) {
    this.input = input;
    this.games = new Game[SIZE];
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
    this.games[this.game_count++] = g;
  }

  public void listGame() {
    for (int i = 0 ; i < this.game_count ; i++)  {
      Game g1 = this.games[i];
      System.out.printf("[%d] %s | %s | %s | %s\n", 
          g1.getGameNum(), g1.getGameName(), g1.getGameProduction(), g1.getGameDate(), g1.getGameGenre());
    }
    System.out.println();
  }

}
