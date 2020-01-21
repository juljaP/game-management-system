package julja.gms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import julja.gms.Handler.BoardAddCommand;
import julja.gms.Handler.BoardDeleteCommand;
import julja.gms.Handler.BoardDetailCommand;
import julja.gms.Handler.BoardListCommand;
import julja.gms.Handler.BoardUpdateCommand;
import julja.gms.Handler.Command;
import julja.gms.Handler.GameAddCommand;
import julja.gms.Handler.GameDeleteCommand;
import julja.gms.Handler.GameDetailCommand;
import julja.gms.Handler.GameListCommand;
import julja.gms.Handler.GameUpdateCommand;
import julja.gms.Handler.UserAddCommand;
import julja.gms.Handler.UserDeleteCommand;
import julja.gms.Handler.UserDetailCommand;
import julja.gms.Handler.UserListCommand;
import julja.gms.Handler.UserUpdateCommand;
import julja.gms.domain.Board;
import julja.gms.domain.Game;
import julja.gms.domain.User;
import julja.util.Prompt;

public class App {

  static Scanner sc = new Scanner(System.in);
  static final int SIZE = 100;
  static Deque<String> stack = new ArrayDeque<>();
  static Queue<String> queue = new LinkedList<>();

  public static void main(String[] args) {

    Prompt prompt = new Prompt(App.sc);
    HashMap<String, Command> commandMap = new HashMap<>();

    ArrayList<Game> gameList = new ArrayList<>();
    ArrayList<Board> boardList = new ArrayList<>();
    LinkedList<User> userList = new LinkedList<>();

    commandMap.put("/board/add", new BoardAddCommand(prompt, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(prompt, boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(prompt, boardList));
    commandMap.put("/board/list", new BoardListCommand(boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(prompt, boardList));

    commandMap.put("/game/add", new GameAddCommand(prompt, gameList));
    commandMap.put("/game/delete", new GameDeleteCommand(prompt, gameList));
    commandMap.put("/game/detail", new GameDetailCommand(prompt, gameList));
    commandMap.put("/game/list", new GameListCommand(gameList));
    commandMap.put("/game/update", new GameUpdateCommand(prompt, gameList));

    commandMap.put("/user/add", new UserAddCommand(prompt, userList));
    commandMap.put("/user/delete", new UserDeleteCommand(prompt, userList));
    commandMap.put("/user/detail", new UserDetailCommand(prompt, userList));
    commandMap.put("/user/list", new UserListCommand(userList));
    commandMap.put("/user/update", new UserUpdateCommand(prompt, userList));


    while (true) {
      String command = prompt();

      if (command.length() == 0) {
        continue;
      } else if (command.equalsIgnoreCase("quit")) {
        System.out.println("안녕!");
        break;
      } else if (command.equalsIgnoreCase("history")) {
        printCommandHistory(App.stack.iterator());
        System.out.println();
        continue;
      } else if (command.equalsIgnoreCase("history2")) {
        printCommandHistory(App.queue.iterator());
        System.out.println();
        continue;
      }

      App.stack.push(command);
      App.queue.offer(command);

      Command commandHandler = commandMap.get(command);

      if (commandHandler != null)
        commandHandler.execute();
      else
        System.out.println("실행할 수 없는 명령입니다.");
      System.out.println();
    }
  }


  private static void printCommandHistory(Iterator<String> iter) {
    Iterator<String> iterator = iter;
    int count = 0;
    String answer = null;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      if (++count % 5 == 0) {
        System.out.print(": ");
        answer = App.sc.nextLine();
        if (answer.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
    System.out.println();
  }

  private static String prompt() {
    System.out.print("명령> ");
    String command = App.sc.nextLine();
    return command;
  }
}
