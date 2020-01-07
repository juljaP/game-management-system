package julja.gms.Handler;

import java.sql.Date;
import java.util.Scanner;
import julja.gms.domain.Game;
import julja.util.ArrayList;

public class GameHandler {

	public Scanner input;
	ArrayList<Game> gameList;

	public GameHandler (Scanner input) {
		this.input = input;
		gameList = new ArrayList<>();
	}

	public void addGame() {
		Game g = new Game();
		System.out.print("품번 : ");
		g.setGameNum(input.nextInt());
		input.nextLine();
		System.out.print("게임명 : ");
		g.setGameName(input.nextLine());
		System.out.print("제작사 : ");
		g.setGameProduction(input.nextLine()); 
		System.out.print("발매일 : ");
		g.setGameDate(Date.valueOf(input.next()));
		input.nextLine();
		System.out.print("플랫폼 : ");
		g.setGamePlatform(input.nextLine()); 
		System.out.print("장르 : ");
		g.setGameGenre(input.nextLine()); 
		System.out.print("작화 : ");
		g.setGameIllust(input.nextLine()); 
		System.out.print("음성 : ");
		g.setGameVoice(input.nextLine());
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
		System.out.print("게임 인덱스? ");
		Game g = gameList.get(input.nextInt());
		input.nextLine();
		if (g == null) {
			System.out.println("해당하는 게임이 존재하지 않습니다.");
			System.out.println();
			return;
		}
		System.out.printf("품번 : %d\n", g.getGameNum());
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
		String s;
		System.out.print("게임 인덱스? ");
		int idx = input.nextInt();
		input.nextLine();
	    Game game = gameList.get(idx);
	    if(game == null) {
	      System.out.println("해당하는 게임이 존재하지 않습니다.");
	      System.out.println();
	      return;
	    }
	    System.out.printf("품번(%d)? ", game.getGameNum());
	    s = input.nextLine();
	    if(s.length() != 0) {
	      game.setGameNum(Integer.parseInt(s));
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
	    gameList.set(idx, game);
	    System.out.println("게임 정보를 변경했습니다.");
	    System.out.println();
	  }
		

	public void deleteGame() {
		System.out.print("게임 인덱스? ");
		int idx = input.nextInt();
		input.nextLine();
	    Game game = gameList.get(idx);
	    if(game == null) {
	      System.out.println("해당하는 게임이 존재하지 않습니다.");
	      System.out.println();
	      return;
	    }
	    gameList.remove(idx);
	    System.out.println("게임 정보를 삭제했습니다.");
	    System.out.println();
	}

}
