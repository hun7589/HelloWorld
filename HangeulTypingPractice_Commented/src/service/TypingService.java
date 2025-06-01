
package src.service;

// 타자 연습 결과를 계산하는 서비스 클래스
public class TypingService {

    // 정확도 계산 메서드: 원문과 입력을 비교하여 정확도(%) 반환
    public static double calculateAccuracy(String original, String input) {
        int length = Math.min(original.length(), input.length());
        int correct = 0;

        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == input.charAt(i)) {
                correct++;
            }
        }

        return (correct / (double) original.length()) * 100;
    }

    // 속도 계산 메서드: 입력한 총 글자 수와 시간(ms)으로 타자 속도 계산
    public static double calculateSpeed(int totalTyped, long timeMillis) {
        double minutes = timeMillis / 60000.0;
        return totalTyped / minutes;
    }
}
