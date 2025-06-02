package typing;

public class TypingUtils {

    // 속도 계산: (타이핑한 문자 수 / 5) / (경과시간(초) / 60) = WPM
    public static double calculateSpeed(int charCount, double elapsedSeconds) {
        if (elapsedSeconds <= 0) {
            return 0;
        }
        double words = charCount / 5.0;
        double minutes = elapsedSeconds / 60.0;
        return words / minutes;
    }

    // 정확도 계산: 원본 문자열 길이 기준으로 같은 위치의 문자 일치 비율
    public static double calculateAccuracy(String original, String typed) {
        if (original == null || original.isEmpty()) {
            return 0;
        }
        int correct = 0;
        int length = original.length();
        for (int i = 0; i < Math.min(typed.length(), length); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                correct++;
            }
        }
        return (correct / (double) length) * 100.0;
    }
}