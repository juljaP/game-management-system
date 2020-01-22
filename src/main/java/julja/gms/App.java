package julja.gms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import julja.gms.Handler.BoardAddCommand;
import julja.gms.Handler.BoardDeleteCommand;
import julja.gms.Handler.BoardDetailCommand;
import julja.gms.Handler.BoardListCommand;
import julja.gms.Handler.BoardUpdateCommand;
import julja.gms.Handler.Command;
import julja.gms.Handler.GameAddCommand;
import julja.gms.Handler.GameDeleteCommand;
import julja.gms.Handler.GameDetailCommand;
import julja.gms.Handler.GameListCommand;
import julja.gms.Handler.GameUpdateCommand;
import julja.gms.Handler.UserAddCommand;
import julja.gms.Handler.UserDeleteCommand;
import julja.gms.Handler.UserDetailCommand;
import julja.gms.Handler.UserListCommand;
import julja.gms.Handler.UserUpdateCommand;
import julja.gms.domain.Board;
import julja.gms.domain.Game;
import julja.gms.domain.User;
import julja.util.Prompt;

public class App {

	static Scanner sc = new Scanner(System.in);
	static final int SIZE = 100;
	static Deque<String> stack = new ArrayDeque<>();
	static Queue<String> queue = new LinkedList<>();
	static ArrayList<Game> gameList = new ArrayList<>();
	static ArrayList<Board> boardList = new ArrayList<>();
	static LinkedList<User> userList = new LinkedList<>();

	public static void main(String[] args) {
		loadGameData();
		loadUserData();
		loadBoardData();
		Prompt prompt = new Prompt(App.sc);
		HashMap<String, Command> commandMap = new HashMap<>();

		commandMap.put("/board/add", new BoardAddCommand(prompt, App.boardList));
		commandMap.put("/board/delete", new BoardDeleteCommand(prompt, App.boardList));
		commandMap.put("/board/detail", new BoardDetailCommand(prompt, App.boardList));
		commandMap.put("/board/list", new BoardListCommand(App.boardList));
		commandMap.put("/board/update", new BoardUpdateCommand(prompt, App.boardList));

		commandMap.put("/game/add", new GameAddCommand(prompt, App.gameList));
		commandMap.put("/game/delete", new GameDeleteCommand(prompt, App.gameList));
		commandMap.put("/game/detail", new GameDetailCommand(prompt, App.gameList));
		commandMap.put("/game/list", new GameListCommand(App.gameList));
		commandMap.put("/game/update", new GameUpdateCommand(prompt, App.gameList));

		commandMap.put("/user/add", new UserAddCommand(prompt, App.userList));
		commandMap.put("/user/delete", new UserDeleteCommand(prompt, App.userList));
		commandMap.put("/user/detail", new UserDetailCommand(prompt, App.userList));
		commandMap.put("/user/list", new UserListCommand(App.userList));
		commandMap.put("/user/update", new UserUpdateCommand(prompt, App.userList));


		while (true) {
			String command = prompt();

			if (command.length() == 0) {
				continue;
			} else if (command.equalsIgnoreCase("quit")) {
				System.out.println("안녕!");
				break;
			} else if (command.equalsIgnoreCase("history")) {
				printCommandHistory(App.stack.iterator());
				System.out.println();
				continue;
			} else if (command.equalsIgnoreCase("history2")) {
				printCommandHistory(App.queue.iterator());
				System.out.println();
				continue;
			}

			App.stack.push(command);
			App.queue.offer(command);

			Command commandHandler = commandMap.get(command);

			if (commandHandler != null)
				try {
					commandHandler.execute();
				} catch (Exception e) {
					System.out.println("명령어 실행 중 오류 발생 : " + e.getMessage());
				}
			else
				System.out.println("실행할 수 없는 명령입니다.");
			System.out.println();
		}
		saveGameData();
		saveUserData();
		saveBoardData();
	}

	private static void printCommandHistory(Iterator<String> iter) {
		Iterator<String> iterator = iter;
		int count = 0;
		String answer = null;
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			if (++count % 5 == 0) {
				System.out.print(": ");
				answer = App.sc.nextLine();
				if (answer.equalsIgnoreCase("q")) {
					break;
				}
			}
		}
		System.out.println();
	}

	private static void loadGameData() {
		File file = new File("./game.csv");
		FileReader in = null;
		Scanner dataScan = null;

		try {
			in = new FileReader(file);
			dataScan = new Scanner(in);

			int count = 0;
			while (true) {
				try {
					String line = dataScan.nextLine();
					String[] data = line.split(", ");
					Game game = new Game();

					game.setGameNum(Integer.parseInt(data[0]));
					game.setGameName(data[1]);
					game.setGameProduction(data[2]);
					game.setGameDate(Date.valueOf(data[3]));
					game.setGamePlatform(data[4]);
					game.setGameGenre(data[5]);
					game.setGameIllust(data[6]);
					game.setGameVoice(data[7]);

					App.gameList.add(game);
					count++;
				} catch (Exception e) {
					break;
				}
			}
			System.out.printf("총 %d개의 게임 데이터를 로딩했습니다.\n", count);
		} catch (FileNotFoundException e) {
			System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
		} finally {
			try {
				dataScan.close();
			} catch (Exception e) {

			}
			try {
				in.close();
			} catch (Exception e) {
			}
		}
	}

	private static void loadUserData() {

		File file = new File("./user.csv");
		FileReader in = null;
		Scanner dataScan = null;
		try {
			in = new FileReader(file);
			dataScan = new Scanner(in);

			int count = 0;
			while(true) {
				try {
					String line = dataScan.nextLine();
					String[] data = line.split(", ");
					User user = new User();
					user.setUserNum(Integer.parseInt(data[0]));
					user.setUserEmail(data[1]);
					user.setUserPW(data[2]);
					user.setUserName(data[3]);
					user.setUserResisteredDate(Date.valueOf(data[4]));

					userList.add(user);
					count++;
				} catch (Exception e) {
					break;
				}
			}
			System.out.printf("총 %d개의 유저 데이터를 로딩했습니다.\n", count);
		} catch (FileNotFoundException e) {
			System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
		} finally {
			try {
				dataScan.close();
			} catch (Exception e){

			}
			try {
				in.close();
			} catch (Exception e) {
			}
		}

	}

	private static void loadBoardData() {
		File file = new File("./board.csv");
		FileReader in = null;
		Scanner dataScan = null;
		try {
			in = new FileReader(file);
			dataScan = new Scanner(in);

			int count = 0;
			while(true) {
				try {
					String line = dataScan.nextLine();
					String[] data = line.split(", ");
					Board board = new Board();
					board.setBbsNum(Integer.parseInt(data[0]));
					board.setBbsName(data[1]);
					board.setBbsText(data[2]);
					board.setToday(Date.valueOf(data[3]));
					board.setBbsHits(Integer.parseInt(data[4]));

					boardList.add(board);
					count++;
				} catch (Exception e) {
					break;
				}
			}
			System.out.printf("총 %d개의 게시글 데이터를 로딩했습니다.\n", count);
		} catch (FileNotFoundException e) {
			System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
		} finally {
			try {
			dataScan.close();
			} catch (Exception e) {
				
			}
			try {
				in.close();
			} catch (Exception e) {

			}
		}
	}

	private static void saveGameData() {
		File file = new File("./game.csv");
		FileWriter out = null;

		try {
			out = new FileWriter(file);
			int count = 0;

			for (Game game : App.gameList) {
				String line = String.format("%d, %s, %s, %s, %s, %s, %s, %s\n", game.getGameNum(),
						game.getGameName(), game.getGameProduction(), game.getGameDate(),
						game.getGamePlatform(), game.getGameGenre(), game.getGameIllust(), game.getGameVoice());
				out.write(line);
				count++;
			}
			System.out.printf("총 %d개의 게임 데이터를 저장했습니다.\n", count);
		} catch (IOException e) {
			System.out.println("파일 쓰기 중 오류가 발생하였습니다 : " + e.getMessage());
		} finally {
			try {
				out.close();
			} catch (IOException e) {

			}
		}
	}

	private static void saveUserData() {
		File file = new File("./user.csv");
		FileWriter out = null;
		try {
			out = new FileWriter(file);
			int count = 0;
			for(User user : userList) {
				String line = String.format("%d, %s, %s, %s, %s\n", user.getUserNum(), user.getUserEmail(), user.getUserPW(), user.getUserName(), user.getUserResisteredDate());
				out.write(line);
				count++;
			}
			System.out.printf("총 %d개의 유저 데이터를 저장했습니다.\n", count);
		} catch (IOException e) {
			System.out.println("파일 쓰기 중 오류가 발생하였습니다 : " + e.getMessage());
		} finally {
			try {
				out.close();
			} catch (IOException e) {

			}
		}

	}

	private static void saveBoardData() {
		File file = new File("board.csv");
		FileWriter out = null;
		try {
			out = new FileWriter(file);
			int count = 0;
			for(Board board : boardList) {
			String line = String.format("%d, %s, %s, %s, %d\n", board.getBbsNum(), board.getBbsName(), board.getBbsText(), board.getToday(), board.getBbsHits());
			out.write(line);
			count++;
			}
			System.out.printf("총 %d개의 게시글 데이터를 저장했습니다.\n", count);
		} catch (IOException e) {
			System.out.println("파일 쓰기 중 오류가 발생하였습니다 : " + e.getMessage());
		} finally {
			try {
				out.close();
			} catch (Exception e) {

			}
		}
		
	}

	private static String prompt() {
		System.out.print("명령> ");
		String command = App.sc.nextLine();
		return command;
	}
}
