package julja.gms.Handler;

import java.sql.Date;
import java.util.Scanner;
import julja.gms.domain.Game;

public class GameHandler {

  Game[] games = new Game[SIZE];
  int game_count = 0;
  
  static final int SIZE = 100;
  public static Scanner sc;

  public void addGame() {
    Game g = new Game();
    System.out.print("품번 : ");
    g.gameNum = sc.nextInt();
    sc.nextLine();
    System.out.print("게임명 : ");
    g.gameName = sc.nextLine();
    System.out.print("제작사 : ");
    g.gameProduction = sc.nextLine();
    System.out.print("발매일 : ");
    g.gameDate = Date.valueOf(sc.next());
    sc.nextLine();
    System.out.print("플랫폼 : ");
    g.gamePlatform = sc.nextLine();
    System.out.print("장르 : ");
    g.gameGenre = sc.nextLine();
    System.out.print("작화 : ");
    g.gameIllust = sc.nextLine();
    System.out.print("음성 : ");
    g.gameVoice = sc.nextLine();
    System.out.println("저장하였습니다.");
    System.out.println();
    this.games[this.game_count++] = g;
  }

  public void listGame() {
    for (int i = 0 ; i < this.game_count ; i++)  {
      Game g1 = this.games[i];
      System.out.printf("[%d] %s | %s | %s | %s\n", 
          g1.gameNum, g1.gameName, g1.gameProduction, g1.gameDate, g1.gameGenre);
    }
    System.out.println();
  }

}
