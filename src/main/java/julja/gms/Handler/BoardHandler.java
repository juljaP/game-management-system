package julja.gms.Handler;

import java.sql.Date;
import java.util.Scanner;
import julja.gms.domain.Board;
import julja.util.ArrayList;

public class BoardHandler {

	public Scanner input;
	ArrayList<Board> boardList;

	public BoardHandler(Scanner input) {
		this.input = input;
		boardList = new ArrayList<>();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BoardHandler(Scanner input, int capacity) {
		this.input = input;
		boardList = new ArrayList(capacity);
	} 

	public void addBoard() {
		Board b = new Board();
		b.setBbsNum(boardList.getSize());
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
			System.out.printf("[%d] %s | %s | %s | %d \n",
					b.getBbsNum(), b.getBbsName(), b.getBbsText(), b.getBbsText(), b.getBbsHits());
		}
		System.out.println();
	}

	public void detailBoard() {
		System.out.print("게시물 인덱스 ? ");
		Board b = this.boardList.get(input.nextInt());
		input.nextLine();

		if(b == null) {
			System.out.println("유효한 게시물 번호가 아닙니다.");
		} else {
			System.out.printf("[%d] %s | %s | %s | %d \n",
					b.getBbsNum(), b.getBbsName(), b.getBbsText(), b.getBbsText(), b.getBbsHits());
		}
		System.out.println();
	}

	public void updateBoard() {
		System.out.print("게시글 인덱스? ");
		int index = input.nextInt();
		Board board = boardList.get(index);
		input.nextLine();
		if (board == null) {
			System.out.println("게시글 번호가 유효하지 않습니다.");
		    System.out.println();
		    return;
		}
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
		System.out.print("게시글 인덱스? ");
		int index = input.nextInt();
		Board board = boardList.get(index);
		input.nextLine();
		if (board == null) {
			System.out.println("게시글 번호가 유효하지 않습니다.");
		    System.out.println();
		    return;
		}
		this.boardList.remove(index);
		System.out.println("게시글을 삭제했습니다.");
	    System.out.println();
	}
}
