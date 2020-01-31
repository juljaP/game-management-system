package julja.gms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
  static List<Game> gameList = new ArrayList<>();
  static List<Board> boardList = new ArrayList<>();
  static List<User> userList = new ArrayList<>();

  public static void main(String[] args) {
    loadGameData();
    loadUserData();
    loadBoardData();
    Prompt prompt = new Prompt(App.sc);
    HashMap<String, Command> commandMap = new HashMap<>();

    commandMap.put("/board/add", new BoardAddCommand(prompt, App.boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(prompt, App.boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(prompt, App.boardList));
    commandMap.put("/board/list", new BoardListCommand(App.boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(prompt, App.boardList));

    commandMap.put("/game/add", new GameAddCommand(prompt, App.gameList));
    commandMap.put("/game/delete", new GameDeleteCommand(prompt, App.gameList));
    commandMap.put("/game/detail", new GameDetailCommand(prompt, App.gameList));
    commandMap.put("/game/list", new GameListCommand(App.gameList));
    commandMap.put("/game/update", new GameUpdateCommand(prompt, App.gameList));

    commandMap.put("/user/add", new UserAddCommand(prompt, App.userList));
    commandMap.put("/user/delete", new UserDeleteCommand(prompt, App.userList));
    commandMap.put("/user/detail", new UserDetailCommand(prompt, App.userList));
    commandMap.put("/user/list", new UserListCommand(App.userList));
    commandMap.put("/user/update", new UserUpdateCommand(prompt, App.userList));

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

  private static void loadGameData() {
    File file = new File("./game.data");
    try (DataInputStream in =
        new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      int size = in.readInt();
      for (int i = 0; i < size; i++) {
        Game game = new Game();
        game.setGameNum(in.readInt());
        game.setGameName(in.readUTF());
        game.setGameProduction(in.readUTF());
        game.setGameDate(Date.valueOf(in.readUTF()));
        game.setGamePlatform(in.readUTF());
        game.setGameGenre(in.readUTF());
        game.setGameIllust(in.readUTF());
        game.setGameVoice(in.readUTF());
        App.gameList.add(game);
      }
      System.out.printf("%d개의 게임 데이터, ", App.gameList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  private static void loadUserData() {

    File file = new File("./user.data");
    try (DataInputStream in =
        new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      int size = in.readInt();
      for (int i = 0; i < size; i++) {
        User user = new User();
        user.setUserNum(in.readInt());
        user.setUserEmail(in.readUTF());
        user.setUserPW(in.readUTF());
        user.setUserName(in.readUTF());
        user.setUserResisteredDate(Date.valueOf(in.readUTF()));
        App.userList.add(user);
      }
      System.out.printf("%d개의 유저 데이터, ", App.userList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  private static void loadBoardData() {
    File file = new File("./board.data");
    try (DataInputStream in =
        new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      int size = in.readInt();
      for (int i = 0; i < size; i++) {
        Board board = new Board();
        board.setBbsNum(in.readInt());
        board.setBbsName(in.readUTF());
        board.setBbsText(in.readUTF());
        board.setToday(Date.valueOf(in.readUTF()));
        board.setBbsHits(in.readInt());
        App.boardList.add(board);
      }
      System.out.printf("%d개의 게시글 데이터를 로딩했습니다.\n", App.boardList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  private static void saveGameData() {
    File file = new File("./game.data");
    try (DataOutputStream out =
        new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeInt(App.gameList.size());
      for (Game game : App.gameList) {
        out.writeInt(game.getGameNum());
        out.writeUTF(game.getGameName());
        out.writeUTF(game.getGameProduction());
        out.writeUTF(game.getGameDate().toString());
        out.writeUTF(game.getGamePlatform());
        out.writeUTF(game.getGameGenre());
        out.writeUTF(game.getGameIllust());
        out.writeUTF(game.getGameVoice());
      }
      System.out.printf("%d개의 게임 데이터, ", App.gameList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류가 발생하였습니다 : " + e.getMessage());
    }
  }

  private static void saveUserData() {
    File file = new File("./user.data");
    try (DataOutputStream out =
        new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeInt(App.userList.size());
      for (User user : App.userList) {
        out.writeInt(user.getUserNum());
        out.writeUTF(user.getUserEmail());
        out.writeUTF(user.getUserPW());
        out.writeUTF(user.getUserName());
        out.writeUTF(user.getUserResisteredDate().toString());
      }
      System.out.printf("%d개의 유저 데이터, ", App.userList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류가 발생하였습니다 : " + e.getMessage());
    }
  }

  private static void saveBoardData() {
    File file = new File("board.data");
    try (DataOutputStream out =
        new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeInt(App.boardList.size());
      for (Board board : App.boardList) {
        out.writeInt(board.getBbsNum());
        out.writeUTF(board.getBbsName());
        out.writeUTF(board.getBbsText());
        out.writeUTF(board.getToday().toString());
        out.writeInt(board.getBbsHits());
      }
      System.out.printf("%d개의 게시글 데이터를 저장했습니다.\n", App.boardList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류가 발생하였습니다 : " + e.getMessage());
    }
  }

  private static String prompt() {
    System.out.print("명령> ");
    String command = App.sc.nextLine();
    return command;
  }
}
