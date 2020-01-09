package julja.gms;

import java.util.Scanner;
import julja.gms.Handler.BoardHandler;
import julja.gms.Handler.GameHandler;
import julja.gms.Handler.UserHandler;
import julja.util.Prompt;

public class App {

  static Scanner sc = new Scanner(System.in);
  static final int SIZE = 100;

  public static void main(String[] args) {
    
    Prompt prompt = new Prompt(sc);

    GameHandler gh = new GameHandler(prompt);
    UserHandler uh = new UserHandler(prompt);
    BoardHandler bh = new BoardHandler(prompt);

    while (true) {
      String command = prompt();

      switch (command) {
        case "/game/add" :
          gh.addGame();
          break;
        case "/game/list" :
          gh.listGame();
          break;
        case "/game/detail" :
          gh.detailGame();
          break;
        case "/game/update" :
          gh.updateGame();
          break;
        case "/game/delete" :
          gh.deleteGame();
          break;
        case "/user/add" :
          uh.addUser();
          break;
        case "/user/list" :
          uh.listUser();
          break;
        case "/user/detail" :
          uh.detailUser();
          break;
        case "/user/update" :
          uh.updateUser();
          break;
        case "/user/delete" :
          uh.deleteUser();
          break;
        case "/board/add" :
          bh.addBoard();
          break;
        case "/board/list" :
          bh.listBoard();
          break;
        case "/board/detail" :
          bh.detailBoard();
          break;
        case "/board/update" :
          bh.updateBoard();
          break;
        case "/board/delete" :
          bh.deleteBoard();
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
    String command = sc.nextLine();
    return command;
  }

}
