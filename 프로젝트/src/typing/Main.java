package typing;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DBUtil.getConnection();
             Scanner sc = new Scanner(System.in)) {

            TextSeeder seeder = new TextSeeder();

            // ─── 첫 실행 시에만 아래 메서드 호출 ───
             seeder.insertKoreanTexts(conn, "resources/texts_korean");
             seeder.insertEnglishTexts(conn, "resources/texts_english");
             seeder.insertJapaneseTexts(conn, "resources/texts_japanese");
            // ※ 데이터가 삽입된 후에는 주석 처리하세요.

            UserDAO userDAO = new UserDAO();
            int currentUserId = -1;

            while (true) {
                System.out.println("\n===== 한컴 타자연습 프로그램 =====");
                System.out.println("1. 로그인 / 회원가입");
                System.out.println("2. 연습 시작");
                System.out.println("3. 내 기록 보기");
                System.out.println("4. 랭킹 보기");
                System.out.println("0. 종료");
                System.out.print("선택> ");

                String choice = sc.nextLine().trim();
                switch (choice) {
                    case "1":
                        System.out.print("1) 로그인  2) 회원가입 중 선택> ");
                        String sub = sc.nextLine().trim();
                        if ("1".equals(sub)) {
                            System.out.print("아이디> ");
                            String uname = sc.nextLine().trim();
                            System.out.print("비밀번호> ");
                            String pwd = sc.nextLine().trim();
                            int uid = userDAO.login(conn, uname, pwd);
                            if (uid != -1) {
                                currentUserId = uid;
                                System.out.println("로그인 성공(유저ID=" + uid + ")");
                            } else {
                                System.out.println("로그인 실패: 아이디/비밀번호 확인하세요.");
                            }
                        } else if ("2".equals(sub)) {
                            System.out.print("가입할 아이디> ");
                            String newU = sc.nextLine().trim();
                            System.out.print("가입할 비밀번호> ");
                            String newP = sc.nextLine().trim();
                            boolean ok = userDAO.register(conn, newU, newP);
                            if (ok) {
                                System.out.println("회원가입 성공! 다시 로그인해주세요.");
                            } else {
                                System.out.println("이미 존재하는 아이디입니다.");
                            }
                        } else {
                            System.out.println("잘못된 선택입니다.");
                        }
                        break;

                    case "2":
                        if (currentUserId == -1) {
                            System.out.println("먼저 로그인하세요.");
                        } else {
                            PracticeSession.start(conn, currentUserId, sc);
                        }
                        break;

                    case "3":
                        if (currentUserId == -1) {
                            System.out.println("먼저 로그인하세요.");
                        } else {
                            HistoryViewer.printMyHistory(conn, currentUserId);
                        }
                        break;

                    case "4":
                        Ranking.showTop10(conn);
                        break;

                    case "0":
                        System.out.println("프로그램을 종료합니다.");
                        return;

                    default:
                        System.out.println("잘못된 선택입니다.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}