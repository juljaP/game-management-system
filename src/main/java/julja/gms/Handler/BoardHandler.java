package julja.gms.Handler;

import java.sql.Date;
import java.util.Scanner;
import julja.gms.domain.Board;
import julja.util.ArrayList;
import julja.util.Prompt;

public class BoardHandler {

  Prompt prompt;
  ArrayList<Board> boardList;

  public BoardHandler(Prompt prompt) {
    this.prompt = prompt;
    boardList = new ArrayList<>();
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public BoardHandler(Prompt prompt, int capacity) {
    this.prompt = prompt;
    boardList = new ArrayList(capacity);
  } 

  public void addBoard() {
    Board b = new Board();
    b.setBbsNum(boardList.getSize() + 1);
    System.out.print("제목 : ");
    b.setBbsName(input.nextLine());
    System.out.print("내용 : ");
    b.setBbsText(input.nextLine());
    b.setToday(new Date(System.currentTimeMillis()));
    b.setBbsHits(0);
    boardList.add(b);
    System.out.println("저장하였습니다.");
    System.out.println();
  }

  public void listBoard() {
    Board[] arr = boardList.toArray(new Board[] {});
    for (Board b : arr) {
      System.out.printf("[%d] %s | %s | %d \n",
          b.getBbsNum(), b.getBbsName(), b.getBbsText(), b.getBbsHits());
    }
    System.out.println();
  }

  public void detailBoard() {
    System.out.print("게시글 번호 ? ");
    int index = indexOfUser(input.nextInt());
    input.nextLine();

    if(index == -1) {
      System.out.println("유효한 게시물 번호가 아닙니다.");
    } else {
      Board b = this.boardList.get(index);
      System.out.println("제목 : " + b.getBbsName());
      System.out.println("내용 : " + b.getBbsText());
      System.out.println("조회수 : " + b.getBbsHits());
    }
    System.out.println();
  }

  public void updateBoard() {
    System.out.print("게시글 번호 ? ");
    int index = indexOfUser(input.nextInt());
    input.nextLine();

    if(index == -1) {
      System.out.println("유효한 게시물 번호가 아닙니다.");
      System.out.println();
      return;
    }
    Board board = this.boardList.get(index);
    System.out.printf("내용(%s)? ", board.getBbsText());
    String text = input.nextLine();
    if (text.length() == 0) {
      System.out.println("게시글 변경을 취소했습니다.");
      System.out.println();
      return;
    }
    board.setBbsText(text);
    board.setToday(new Date(System.currentTimeMillis()));
    this.boardList.set(index, board);
    System.out.println("게시글을 변경했습니다.");
    System.out.println();

  }

  public void deleteBoard() {
    System.out.print("게시글 번호 ? ");
    int index = indexOfUser(input.nextInt());
    input.nextLine();

    if(index == -1) {
      System.out.println("유효한 게시물 번호가 아닙니다.");
      System.out.println();
      return;
    }
    this.boardList.remove(index);
    System.out.println("게시글을 삭제했습니다.");
    System.out.println();
  }
  
  private int indexOfUser(int num) {
    for (int i = 0 ; i < this.boardList.getSize() ; i++) {
      if(this.boardList.get(i).getBbsNum() == num) {
        return i;
      }
    }
    return -1;
  }
  
}
