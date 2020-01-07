package julja.gms.Handler;

import java.sql.Date;
import java.util.Scanner;
import julja.gms.domain.User;
import julja.util.ArrayList;

public class UserHandler {

	public Scanner input;
	ArrayList<User> userList;

	public UserHandler(Scanner input) {
		this.input = input;
		userList = new ArrayList<>();
	}

	public void addUser() {
		User u = new User();
		u.setUserNum(userList.getSize()); 
		System.out.print("이메일 : ");
		u.setUserEmail(input.nextLine());
		System.out.print("비밀번호 : ");
		u.setUserPW(input.nextLine());
		System.out.print("회원명 : ");
		u.setUserName(input.nextLine());
		System.out.print("가입일 : ");
		u.setUserResisteredDate(new Date(System.currentTimeMillis()));
		System.out.println(u.getUserResisteredDate());
		userList.add(u);
		System.out.println("저장하였습니다.");
		System.out.println();
	}

	public void listUser() {
		User[] arr = userList.toArray(new User[] {});
		for (User u : arr) {
			System.out.printf("[%d] %s | %s | %s\n", 
					u.getUserNum(), u.getUserEmail(), u.getUserName(), u.getUserResisteredDate());
		}
		System.out.println();
	}

	public void detailUser() {
		System.out.print("회원 번호? ");
		int idx = input.nextInt();
		input.nextLine();
		User u = userList.get(idx);
		if(u == null) {
			System.out.println("해당하는 유저가 존재하지 않습니다.");
			System.out.println();
			return;
		}
		System.out.printf("이메일 : %s\n", u.getUserEmail());
		System.out.printf("비밀번호 : %s\n", u.getUserPW());
		System.out.printf("회원명 : %s\n", u.getUserName());
		System.out.printf("가입일 : %s\n", u.getUserResisteredDate());
		System.out.println();
	}

	public void updateUser() {
		String s;
		System.out.print("회원 번호? ");
		int idx = input.nextInt();
		input.nextLine();
		User u = userList.get(idx);
		if(u == null) {
			System.out.println("해당하는 유저가 존재하지 않습니다.");
			System.out.println();
			return;
		}
		System.out.printf("이메일(%s) : ", u.getUserEmail());
		s = input.nextLine();
		if(s.length() != 0) {
			u.setUserEmail(s);
		}
		System.out.printf("비밀번호(%s) : ", u.getUserPW());
		s = input.nextLine();
		if(s.length() != 0) {
			u.setUserPW(s);
		}
		System.out.printf("회원명(%s) : ", u.getUserName());
		s = input.nextLine();
		if(s.length() != 0) {
			u.setUserName(s);
		}
		userList.set(idx, u);
		System.out.println("회원 정보를 수정하였습니다.");
		System.out.println();
	}

	public void deleteUser() {
		System.out.print("회원 번호? ");
		int idx = input.nextInt();
		input.nextLine();
		User u = userList.get(idx);
		if(u == null) {
			System.out.println("해당하는 유저가 존재하지 않습니다.");
			System.out.println();
			return;
		}
		userList.remove(idx);
		System.out.println("회원 정보를 삭제하였습니다.");
		System.out.println();
	}

}
