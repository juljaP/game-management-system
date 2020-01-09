package julja.gms.Handler;

import java.sql.Date;
import julja.gms.domain.Game;
import julja.util.ArrayList;
import julja.util.Prompt;

public class GameHandler {

  Prompt prompt;
  ArrayList<Game> gameList;

  public GameHandler (Prompt prompt) {
    this.prompt = prompt;
    gameList = new ArrayList<>();
  }

  public void addGame() {
    Game g = new Game();
    g.setGameNum(prompt.inputInt("품번 : "));
    g.setGameName(prompt.inputString("게임명 : "));
    g.setGameProduction(prompt.inputString("제작사 : ")); 
    g.setGameDate(prompt.inputDate("발매일 : "));
    g.setGamePlatform(prompt.inputString("플랫폼 : ")); 
    g.setGameGenre(prompt.inputString("장르 : ")); 
    g.setGameIllust(prompt.inputString("작화 : "));
    g.setGameVoice(prompt.inputString("음성 : "));
    System.out.println("저장하였습니다.");
    System.out.println();
    gameList.add(g);
  }

  public void listGame() {
    Game[] arr = gameList.toArray(new Game[] {});
    for(Game g : arr) {
      System.out.printf("[%d] %s | %s | %s | %s\n", 
          g.getGameNum(), g.getGameName(), g.getGameProduction(), g.getGameDate(), g.getGameGenre());
    }
    System.out.println();
  }

  public void detailGame() {
    int index = indexOfLesson(prompt.inputInt("게임 품번? : "));
    Game g = this.gameList.get(index);
    if (index == -1) {
      System.out.println("해당하는 게임이 존재하지 않습니다.");
      System.out.println();
      return;
    }
    System.out.printf("게임명 : %s\n", g.getGameName());
    System.out.printf("제작사 : %s\n", g.getGameProduction());
    System.out.printf("발매일 : %s\n", g.getGameDate());
    System.out.printf("플랫폼 : %s\n", g.getGamePlatform());
    System.out.printf("장르 : %s\n", g.getGameGenre());
    System.out.printf("작화 : %s\n", g.getGameIllust());
    System.out.printf("음성 : %s\n", g.getGameVoice());
    System.out.println();
  }
  
  public void updateGame() {
    boolean changed = false;
    String s;
    
    int index = indexOfLesson(prompt.inputInt("게임 품번? : "));
    Game game = this.gameList.get(index);
    if (index == -1) {
      System.out.println("해당하는 게임이 존재하지 않습니다.");
      System.out.println();
      return;
    }
    
    System.out.printf("게임명(%s)? ", game.getGameName());
    s = input.nextLine();
    if(s.length() != 0) {
      game.setGameName(s);
    }
    System.out.printf("제작사(%s)? ", game.getGameProduction());
    s = input.nextLine();
    if(s.length() != 0) {
      game.setGameProduction(s);
    }
    System.out.printf("발매일(%s)? ", game.getGameDate());
    s = input.nextLine();
    if(s.length() != 0) {
      game.setGameDate(Date.valueOf(s));
    }
    System.out.printf("플랫폼(%s)? ", game.getGamePlatform());
    s = input.nextLine();
    if(s.length() != 0) {
      game.setGamePlatform(s);
    }
    System.out.printf("장르(%s)? ", game.getGameGenre());
    s = input.nextLine();
    if(s.length() != 0) {
      game.setGameGenre(s);
    }
    System.out.printf("작화(%s)? ", game.getGameIllust());
    s = input.nextLine();
    if(s.length() != 0) {
      game.setGameIllust(s);
    }
    System.out.printf("음성(%s)? ", game.getGameVoice());
    s = input.nextLine();
    if(s.length() != 0) {
      game.setGameVoice(s);
    }
    gameList.set(index, game);
    System.out.println("게임 정보를 변경했습니다.");
    System.out.println();
  }

  public void deleteGame() {
    int index = indexOfLesson(prompt.inputInt("게임 품번? : "));
    if (index == -1) {
      System.out.println("해당하는 게임이 존재하지 않습니다.");
      System.out.println();
      return;
    }
    gameList.remove(index);
    System.out.println("게임 정보를 삭제했습니다.");
    System.out.println();
  }

  private int indexOfLesson(int num) {
    for (int i = 0 ; i < this.gameList.getSize() ; i++) {
      if(this.gameList.get(i).getGameNum() == num) {
        return i;
      }
    }
    return -1;
  }
  
}

