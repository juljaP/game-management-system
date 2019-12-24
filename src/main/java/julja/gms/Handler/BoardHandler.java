package julja.gms.Handler;

import java.sql.Date;
import java.util.Scanner;
import julja.gms.domain.Board;

public class BoardHandler {

  static final int SIZE = 100;
  static Board[] boards = new Board[SIZE];
  static int board_count = 0;
  public static Scanner sc;

  public static void addBoard() {
    Board b = new Board();
    b.bbsNum = board_count+1;
    System.out.print("제목 : ");
    b.bbsName = sc.nextLine();
    System.out.print("내용 : ");
    b.bbsText = sc.nextLine();
    b.today = new Date(System.currentTimeMillis());
    b.bbsHits = 0;
    boards[board_count++] = b;
    System.out.println("저장하였습니다.");
    System.out.println();
  }

  public static void listBoard() {
    for (int i = 0 ; i < board_count ; i++) {
      Board b1 = boards[i];
      System.out.printf("[%d] %s | %s | %s | %d \n",
          b1.bbsNum, b1.bbsName, b1.bbsText, b1.today, b1.bbsHits);
    }
    System.out.println();
  }

}
