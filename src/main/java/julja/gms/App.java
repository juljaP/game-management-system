package julja.gms;

import java.util.Scanner;
import julja.gms.Handler.BoardHandler;
import julja.gms.Handler.GameHandler;
import julja.gms.Handler.UserHandler;
import julja.gms.domain.Board;
import julja.gms.domain.Game;
import julja.gms.domain.User;
import julja.util.ArrayList;
import julja.util.LinkedList;
import julja.util.Prompt;
import julja.util.Queue;
import julja.util.Stack;

public class App {

  static Scanner sc = new Scanner(System.in);
  static final int SIZE = 100;
  static Stack<String> stack = new Stack<>();
  static Queue<String> queue = new Queue<>();

  public static void main(String[] args) {

    Prompt prompt = new Prompt(sc);
    
    ArrayList<Game> gameList = new ArrayList<>();
    ArrayList<Board> boardList = new ArrayList<>();
    LinkedList<User> userList = new LinkedList<>();

    GameHandler gh = new GameHandler(prompt, gameList);
    UserHandler uh = new UserHandler(prompt, userList);
    BoardHandler bh = new BoardHandler(prompt, boardList);

    while (true) {
      String command = prompt();

      if(command.length() == 0) {
        continue;
      }

      stack.push(command);
      queue.offer(command);

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
        case "history" :
          printCommandHistory();
          break;
        case "history2" :
          printCommandHistory2();
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


  private static void printCommandHistory() {
    Stack<String> historyStack = stack.clone();
    int count = 0;
    String answer = null;
    while(!historyStack.empty()) {
      System.out.println(historyStack.pop());
      if(++count % 5 == 0) {
        System.out.print(": ");
        answer = sc.nextLine();
        if(answer.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
    System.out.println();
  }
  
  private static void printCommandHistory2() {
  Queue<String> historyQueue = queue.clone();
  int count = 0;
  String answer = null;
  for(int i = 0 ; i < queue.getSize() ; i++) {
    System.out.println(historyQueue.poll());
    if(++count % 5 == 0) {
      System.out.print(": ");
      answer = sc.nextLine();
      if(answer.equalsIgnoreCase("q")) {
        break;
      }
    }
  }
  System.out.println();
  }
  
  private static String prompt() {
    System.out.print("명령> ");
    String command = sc.nextLine();
    return command;
  }
}
