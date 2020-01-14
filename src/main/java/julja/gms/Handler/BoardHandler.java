package julja.gms.Handler;

import java.sql.Date;
import julja.gms.domain.Board;
import julja.util.AbstractList;
import julja.util.Prompt;

public class BoardHandler {

  Prompt prompt;
  AbstractList<Board> boardList;

  public BoardHandler(Prompt prompt, AbstractList<Board> list) {
    this.prompt = prompt;
    boardList = list;
  }

  public void addBoard() {
    Board b = new Board();
    b.setBbsNum(boardList.getSize() + 1);
    b.setBbsName(prompt.inputString("제목 : "));
    b.setBbsText(prompt.inputString("내용 : "));
    b.setToday(new Date(System.currentTimeMillis()));
    b.setBbsHits(0);
    boardList.add(b);
    System.out.println("저장하였습니다.");
    System.out.println();
  }

  public void listBoard() {
    Board[] arr = (Board[]) boardList.toArray(new Board[] {});
    for (Board b : arr) {
      System.out.printf("[%d] %s | %s | %d \n",
          b.getBbsNum(), b.getBbsName(), b.getBbsText(), b.getBbsHits());
    }
    System.out.println();
  }

  public void detailBoard() {
    int index = indexOfUser(prompt.inputInt("게시글 번호 ? "));
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
    int index = indexOfUser(prompt.inputInt("게시글 번호 ? "));
    if(index == -1) {
      System.out.println("유효한 게시물 번호가 아닙니다.");
      System.out.println();
      return;
    }
    Board oldBoard = this.boardList.get(index);
    Board newBoard = new Board();
    newBoard.setBbsNum(oldBoard.getBbsNum());
    System.out.println("제목 : " + oldBoard.getBbsName());
    newBoard.setBbsName(oldBoard.getBbsName());
    newBoard.setBbsText(prompt.inputString
        (String.format("내용(%s)? ", oldBoard.getBbsText()), oldBoard.getBbsText()));
    newBoard.setBbsHits(oldBoard.getBbsHits());
    newBoard.setToday(new Date(System.currentTimeMillis()));
    if(newBoard.equals(oldBoard)) {
      System.out.println("게시글 변경을 취소했습니다.");
    } else {
    this.boardList.set(index, newBoard);
    System.out.println("게시글을 변경했습니다.");
    }
    System.out.println();

  }

  public void deleteBoard() {
    int index = indexOfUser(prompt.inputInt("게시글 번호 ? "));
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
