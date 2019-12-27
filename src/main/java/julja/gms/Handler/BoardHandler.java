package julja.gms.Handler;

import java.sql.Date;
import java.util.Scanner;
import julja.gms.domain.Board;

public class BoardHandler {

  Board[] boards = new Board[SIZE];
  int board_count = 0;
  
  static final int SIZE = 100;
  public static Scanner sc;

  public void addBoard() {
    Board b = new Board();
    b.bbsNum = this.board_count+1;
    System.out.print("제목 : ");
    b.bbsName = sc.nextLine();
    System.out.print("내용 : ");
    b.bbsText = sc.nextLine();
    b.today = new Date(System.currentTimeMillis());
    b.bbsHits = 0;
    this.boards[this.board_count++] = b;
    System.out.println("저장하였습니다.");
    System.out.println();
  }

  public void listBoard() {
    for (int i = 0 ; i < this.board_count ; i++) {
      Board b1 = this.boards[i];
      System.out.printf("[%d] %s | %s | %s | %d \n",
          b1.bbsNum, b1.bbsName, b1.bbsText, b1.today, b1.bbsHits);
    }
    System.out.println();
  }

}
