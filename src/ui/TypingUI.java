package src.ui;

import src.model.Text;
import src.service.TypingService;
import src.dao.TextDAO;

import java.util.List;
import java.util.Scanner;

public class TypingUI {

    public static void startPractice(int userId, String level, String language) {
        List<Text> texts = TextDAO.getTextsByLevelAndLanguage(level, language);
        if (texts.isEmpty()) {
            System.out.println("해당 언어/난이도에 대한 예문이 없습니다.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        if (level.equals("전문가")) {
            Text longText = texts.get(0); // 하나의 긴 텍스트
            String[] lines = longText.getContent().split("\n");
            for (String line : lines) {
                System.out.println("[문장] " + line);
                System.out.print("입력: ");
                long start = System.currentTimeMillis();
                String input = scanner.nextLine();
                long end = System.currentTimeMillis();

                double accuracy = TypingService.calculateAccuracy(line, input);
                double speed = TypingService.calculateSpeed(input.length(), end - start);

                System.out.printf("정확도: %.2f%%, 속도: %.2f 타/분\n", accuracy, speed);
                TypingService.saveResult(userId, longText.getId(), speed, accuracy);
            }
        } else {
            for (Text text : texts.subList(0, Math.min(5, texts.size()))) {
                System.out.println("[문장] " + text.getContent());
                System.out.print("입력: ");
                long start = System.currentTimeMillis();
                String input = scanner.nextLine();
                long end = System.currentTimeMillis();

                double accuracy = TypingService.calculateAccuracy(text.getContent(), input);
                double speed = TypingService.calculateSpeed(input.length(), end - start);

                System.out.printf("정확도: %.2f%%, 속도: %.2f 타/분\n", accuracy, speed);
                TypingService.saveResult(userId, text.getId(), speed, accuracy);
            }
        }
    }
}
