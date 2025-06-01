package src.ui;

import src.model.User;
import src.dao.UserDAO;

import java.util.Scanner;

public class LoginUI {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== 언어 선택 ===");
        System.out.println("1. 한국어  2. 영어  3. 일본어");
        String langChoice = scanner.nextLine();
        String language = switch (langChoice) {
            case "1" -> "한국어";
            case "2" -> "영어";
            case "3" -> "일본어";
            default -> "한국어";
        };

        System.out.println("=== 난이도 선택 ===");
        System.out.println("1. 초급  2. 중급  3. 고급  4. 전문가");
        String levelChoice = scanner.nextLine();
        String level = switch (levelChoice) {
            case "1" -> "초급";
            case "2" -> "중급";
            case "3" -> "고급";
            case "4" -> "전문가";
            default -> "초급";
        };

        while (true) {
            System.out.println("1. 로그인  2. 회원가입  3. 종료");
            String menu = scanner.nextLine();

            if (menu.equals("1")) {
                System.out.print("아이디: ");
                String uname = scanner.nextLine();
                System.out.print("비밀번호: ");
                String pw = scanner.nextLine();

                User user = UserDAO.login(uname, pw);
                if (user != null) {
                    System.out.println(user.getUname() + "님 환영합니다!");
                    TypingUI.startPractice(user.getId(), level, language);
                    break;
                } else {
                    System.out.println("로그인 실패");
                }
            } else if (menu.equals("2")) {
                System.out.print("새 아이디: ");
                String uname = scanner.nextLine();
                System.out.print("새 비밀번호: ");
                String pw = scanner.nextLine();
                if (UserDAO.register(uname, pw)) {
                    System.out.println("회원가입 성공!");
                } else {
                    System.out.println("회원가입 실패!");
                }
            } else {
                System.out.println("프로그램 종료");
                System.exit(0);
            }
        }
    }
}
