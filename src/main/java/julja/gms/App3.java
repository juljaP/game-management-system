package julja.gms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    final int SIZE = 5000;
    /*
    class Board {
      String bbsName, bbsText;
      Date today;
      int bbsNum, bbsHits;
    }
    */
    Board[] boards = new Board[SIZE];
    for (int i = 0 ; i < SIZE ; i++) {
      boards[i] = new Board();
    }

    int count = 0;

    for(int i = 0 ; i < SIZE ; i++) {
      Board b = boards[i];
      b.bbsNum = i+1;
      System.out.print("제목 : ");
      b.bbsName = sc.nextLine();
      System.out.print("내용 : ");
      b.bbsText = sc.nextLine();
      b.today = new Date(System.currentTimeMillis());
      b.bbsHits = 0;
      count++;
      System.out.println();
      System.out.print("계속 입력하시겠습니까?(Y|N) ");
      String res = sc.nextLine();
      if (res.equalsIgnoreCase("Y")) {
        continue;
      } else {
        System.out.println();
        sc.close();
        break;
      }
    }
    for (int i = 0 ; i < count ; i++) {
      Board b = boards[i];
      System.out.printf("[%d] %s | %s | %s | %d \n",
          b.bbsNum, b.bbsName, b.bbsText, b.today, b.bbsHits);
    }
  }
}
