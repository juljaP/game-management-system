package julja.gms;

import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    final int SIZE = 5000;
    /*
    class Game {
      int gameNum;
      String gameName, gameProduction, gamePlatform, gameGenre, 
      gameIllust, gameVoice;
      Date gameDate;
    }
    */
    Game[] games = new Game[SIZE];
    for (int i = 0 ; i < SIZE ; i++) {
      games[i] = new Game();
    }

    int count = 0;
    for(int i = 0 ; i < SIZE ; i++) {
      Game g = games[i];
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
      count++;
      System.out.println();
      System.out.print("계속 입력하시겠습니까?(Y|N) ");
      String res = sc.nextLine();
      System.out.println();
      if (res.equalsIgnoreCase("Y")) {
        continue;
      }
      sc.close();
      break;
    }

    for (int i = 0 ; i < count ; i++)  {
      Game g = games[i];
      System.out.printf("[%d] %s | %s | %s | %s\n", 
          g.gameNum, g.gameName, g.gameProduction, g.gameDate, g.gameGenre);
    }
  }
}
