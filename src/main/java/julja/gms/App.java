package julja.gms;

import java.util.Scanner;

public class App {

  static Scanner sc = new Scanner(System.in);
  static final int SIZE = 100;
  
  public static void main(String[] args) {
    GameHandler.sc = sc;
    UserHandler.sc = sc;
    BoardHandler.sc = sc;

    while (true) {
      
      String command = prompt();
      
      switch (command) {
        case "/game/add" :
          GameHandler.addGame();
          break;

        case "/game/list" :
          GameHandler.listGame();
          break;

        case "/user/add" :
          UserHandler.addUser();
          break;

        case "/user/list" :
          UserHandler.listUser();
          break;

        case "/board/add" :
          BoardHandler.addBoard();
          break;

        case "/board/list" :
          BoardHandler.listBoard();
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
