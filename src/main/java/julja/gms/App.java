package julja.gms;

import java.util.Scanner;
import julja.gms.Handler.BoardHandler;
import julja.gms.Handler.GameHandler;
import julja.gms.Handler.UserHandler;

public class App {

  static Scanner sc = new Scanner(System.in);
  static final int SIZE = 100;
  
  public static void main(String[] args) {
    GameHandler.sc = sc;
    UserHandler.sc = sc;
    BoardHandler.sc = sc;
    
    GameHandler gh = new GameHandler();
    UserHandler uh = new UserHandler();
    BoardHandler bh1 = new BoardHandler();
    BoardHandler bh2 = new BoardHandler();

    while (true) {
      String command = prompt();
      
      switch (command) {
        case "/game/add" :
          gh.addGame();
          break;
        case "/game/list" :
          gh.listGame();
          break;
        case "/user/add" :
          uh.addUser();
          break;
        case "/user/list" :
          uh.listUser();
          break;
        case "/board/add" :
          bh1.addBoard();
          break;
        case "/board/list" :
          bh1.listBoard();
          break;
        case "/board2/add" :
          bh2.addBoard();
          break;
        case "/board2/list" :
          bh2.listBoard();
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

  private static String prompt() {
    System.out.print("명령> ");
    String command= sc.nextLine();;
    return command;
  }

}
