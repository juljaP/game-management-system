package julja.gms;

import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    final int SIZE = 100;

    class Game {
      int gameNum;
      String gameName, gameProduction, gamePlatform, gameGenre, 
      gameIllust, gameVoice;
      Date gameDate;
    }
    Game[] games = new Game[SIZE];
    int game_count = 0;

    class User {
      int userNum;
      String userEmail, userPW, userName;
      Date userResisteredDate;
    }
    User[] users = new User[SIZE];
    int user_count = 0;

    class Board {
      String bbsName, bbsText;
      Date today;
      int bbsNum, bbsHits;
    }
    Board[] boards = new Board[SIZE];
    int board_count = 0;

    String command;
    while (true) {
      System.out.print("명령> ");
      command = sc.nextLine();
      switch (command) {

        case "/game/add" :
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
          games[game_count++] = g;
          break;

        case "/game/list" :
          for (int i = 0 ; i < game_count ; i++)  {
            Game g1 = games[i];
            System.out.printf("[%d] %s | %s | %s | %s\n", 
                g1.gameNum, g1.gameName, g1.gameProduction, g1.gameDate, g1.gameGenre);
          }
          System.out.println();
          break;

        case "/user/add" :
          User u = new User();
          u.userNum = user_count+1; 
          System.out.print("이메일 : ");
          u.userEmail = sc.nextLine();
          System.out.print("비밀번호 : ");
          u.userPW = sc.nextLine();
          System.out.print("회원명 : ");
          u.userName = sc.nextLine();
          System.out.print("가입일 : ");
          u.userResisteredDate = new Date(System.currentTimeMillis());
          System.out.println(u.userResisteredDate);
          users[user_count++] = u;
          System.out.println("저장하였습니다.");
          System.out.println();
          break;

        case "/user/list" :
          for (int i = 0 ; i < user_count ; i++) {
            User u1 = users[i];
            System.out.printf("[%d] %s | %s | %s\n", 
                u1.userNum, u1.userEmail, u1.userName, u1.userResisteredDate);
          }
          System.out.println();
          break;

        case "/board/add" :
          Board b = new Board();
          b.bbsNum = board_count+1;
          System.out.print("제목 : ");
          b.bbsName = sc.nextLine();
          System.out.print("내용 : ");
          b.bbsText = sc.nextLine();
          b.today = new Date(System.currentTimeMillis());
          b.bbsHits = 0;
          boards[board_count++] = b;
          System.out.println("저장하였습니다.");
          System.out.println();
          break;

        case "/board/list" :
          for (int i = 0 ; i < board_count ; i++) {
            Board b1 = boards[i];
            System.out.printf("[%d] %s | %s | %s | %d \n",
                b1.bbsNum, b1.bbsName, b1.bbsText, b1.today, b1.bbsHits);
          }
          System.out.println();
          break;

        case "quit" : 
          sc.close();
          System.out.println("안녕!");
          System.exit(0);

        default :
          System.out.println("실행할 수 없는 명령입니다.");
          System.out.println();
          break;
      }
    }
  }
}
