package julja.gms.Handler;

import java.sql.Date;
import java.util.Scanner;
import julja.gms.domain.Board;

public class BoardHandler {

  Board[] boards; 
  int board_count = 0;
  
  static final int SIZE = 100;
  public Scanner input;
  
  public BoardHandler(Scanner input) {
    this.input = input;
    this.boards = new Board[SIZE];
  }
  
  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    if (capacity < SIZE || capacity > 10000)
      this.boards = new Board[SIZE];
    else
      this.boards = new Board[capacity];
  } 

  public void addBoard() {
    Board b = new Board();
    b.bbsNum = this.board_count+1;
    System.out.print("제목 : ");
    b.bbsName = input.nextLine();
    System.out.print("내용 : ");
    b.bbsText = input.nextLine();
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
