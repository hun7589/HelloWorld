
package src.ui;

import java.util.Scanner;

public class LoginUI {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== 언어 선택 ===");
        System.out.println("1. 한글  2. Eng  3.日本語 ");
        String langChoice = scanner.nextLine();
        String language = switch (langChoice) {
            case "1" -> "한글";
            case "2" -> "Eng";
            case "3" -> "日本語 ";
            default -> "한글";
        };
        System.out.println("선택한 언어: " + language);

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
        System.out.println("선택한 난이도: " + level);
        // 다음 단계에서 로그인, 연습 UI로 연결
    }
}
