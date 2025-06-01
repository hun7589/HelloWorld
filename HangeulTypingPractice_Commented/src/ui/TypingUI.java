
package src.ui;

import src.service.TypingService;

import java.util.Scanner;

public class TypingUI {
    public static void startPractice(String content) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== 타자 연습 시작 ===");
        System.out.println("[연습할 문장]");
        System.out.println(content);
        System.out.println("\n아래에 타자를 시작하세요 (입력 후 Enter):");

        long startTime = System.currentTimeMillis();
        String input = scanner.nextLine();
        long endTime = System.currentTimeMillis();

        double accuracy = TypingService.calculateAccuracy(content, input);
        double speed = TypingService.calculateSpeed(input.length(), endTime - startTime);

        System.out.printf("정확도: %.2f%%\n", accuracy);
        System.out.printf("속도: %.2f 타/분\n", speed);

        // 이후 saveResult() 호출로 DB 저장 가능
    }
}
