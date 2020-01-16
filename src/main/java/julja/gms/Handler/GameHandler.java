package julja.gms.Handler;

import java.util.Iterator;
import java.util.List;
import julja.gms.domain.Game;
import julja.util.Prompt;

public class GameHandler {

  Prompt prompt;
  List<Game> gameList;

  public GameHandler (Prompt prompt, List<Game> list) {
    this.prompt = prompt;
    gameList = list;
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
    Iterator<Game> iterator = gameList.iterator();
    while(iterator.hasNext()) {
      Game g = iterator.next();
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
    
    int index = indexOfLesson(prompt.inputInt("게임 품번? : "));
    if (index == -1) {
      System.out.println("해당하는 게임이 존재하지 않습니다.");
      System.out.println();
      return;
    }
    Game oldGame = this.gameList.get(index);
    Game newGame = new Game();
    newGame.setGameNum(oldGame.getGameNum());
    newGame.setGameName(prompt.inputString
        (String.format("게임명(%s) ? ", oldGame.getGameName()), oldGame.getGameName()));

    newGame.setGameProduction(prompt.inputString
        (String.format("제작사(%s) ? ", oldGame.getGameProduction()), oldGame.getGameProduction()));
    newGame.setGameDate(prompt.inputDate
        (String.format("발매일(%s) ? ", oldGame.getGameDate()), oldGame.getGameDate()));
    newGame.setGamePlatform(prompt.inputString
        (String.format("플랫폼(%s) ? ", oldGame.getGamePlatform()), oldGame.getGamePlatform()));
    newGame.setGameGenre(prompt.inputString
        (String.format("장르(%s) ? ", oldGame.getGameGenre()), oldGame.getGameGenre()));
    newGame.setGameIllust(prompt.inputString
        (String.format("작화(%s) ? ", oldGame.getGameIllust()), oldGame.getGameIllust()));
    newGame.setGameVoice(prompt.inputString
        (String.format("음성(%s) ? ", oldGame.getGameVoice()), oldGame.getGameVoice()));
    
    if(oldGame.equals(newGame)) {
    System.out.println("게임 정보 변경을 취소하였습니다.");
    } else {
      gameList.set(index, newGame);
      System.out.println("게임 정보를 변경했습니다.");
    }
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
    for (int i = 0 ; i < this.gameList.size() ; i++) {
      if(this.gameList.get(i).getGameNum() == num) {
        return i;
      }
    }
    return -1;
  }
  
}

