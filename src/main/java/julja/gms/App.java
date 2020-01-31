package julja.gms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import julja.context.ApplicationContextListener;
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

  Scanner sc = new Scanner(System.in);
  final int SIZE = 100;
  Deque<String> stack = new ArrayDeque<>();
  Queue<String> queue = new LinkedList<>();
  List<Game> gameList = new ArrayList<>();
  List<Board> boardList = new ArrayList<>();
  List<User> userList = new ArrayList<>();
  Set<ApplicationContextListener> listeners = new HashSet<>();

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  private void notifyApplicationInitialized() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitailized();
    }
  }

  private void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed();
    }
  }

  public void service() {

    notifyApplicationInitialized();

    loadGameData();
    loadUserData();
    loadBoardData();
    Prompt prompt = new Prompt(sc);
    HashMap<String, Command> commandMap = new HashMap<>();

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
        printCommandHistory(stack.iterator());
        System.out.println();
        continue;
      } else if (command.equalsIgnoreCase("history2")) {
        printCommandHistory(queue.iterator());
        System.out.println();
        continue;
      }

      stack.push(command);
      queue.offer(command);

      Command commandHandler = commandMap.get(command);

      if (commandHandler != null)
        try {
          commandHandler.execute();
        } catch (Exception e) {
          System.out.println("명령어 실행 중 오류 발생 : " + e.getMessage());
        }
      else
        System.out.println("실행할 수 없는 명령입니다.");
      System.out.println();
    }
    saveGameData();
    saveUserData();
    saveBoardData();

    notifyApplicationDestroyed();

  }

  private void printCommandHistory(Iterator<String> iter) {
    Iterator<String> iterator = iter;
    int count = 0;
    String answer = null;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      if (++count % 5 == 0) {
        System.out.print(": ");
        answer = sc.nextLine();
        if (answer.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
    System.out.println();
  }

  @SuppressWarnings("unchecked")
  private void loadGameData() {
    File file = new File("./game.ser");
    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      gameList = (List<Game>) in.readObject();
      System.out.printf("%d개의 게임 데이터, ", gameList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  private void loadUserData() {

    File file = new File("./user.ser");
    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      userList = (List<User>) in.readObject();
      System.out.printf("%d개의 유저 데이터, ", userList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  private void loadBoardData() {
    File file = new File("./board.ser");
    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      boardList = (List<Board>) in.readObject();
      System.out.printf("%d개의 게시글 데이터를 로딩했습니다.\n", boardList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  private void saveGameData() {
    File file = new File("./game.ser");
    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(gameList);
      System.out.printf("%d개의 게임 데이터, ", gameList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류가 발생하였습니다 : " + e.getMessage());
    }
  }

  private void saveUserData() {
    File file = new File("./user.ser");
    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(userList);
      System.out.printf("%d개의 유저 데이터, ", userList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류가 발생하였습니다 : " + e.getMessage());
    }
  }

  private void saveBoardData() {
    File file = new File("board.ser");
    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(boardList);
      System.out.printf("%d개의 게시글 데이터를 저장했습니다.\n", boardList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류가 발생하였습니다 : " + e.getMessage());
    }
  }

  private String prompt() {
    System.out.print("명령> ");
    String command = sc.nextLine();
    return command;
  }


  public static void main(String[] args) {
    App app = new App();
    app.service();
  }

}
