package src.service;

public class AccuracyCalculator {
    public static int levenshtein(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= s2.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(
                    Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                    dp[i - 1][j - 1] + cost
                );
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static double calculateAccuracy(String original, String typed) {
        int distance = levenshtein(original, typed);
        int maxLen = Math.max(original.length(), 1);
        return (1.0 - (double) distance / maxLen) * 100;
    }

    public static double calculateSpeed(int typedLength, long durationMillis) {
        double minutes = durationMillis / 60000.0;
        return typedLength / minutes; // 타자 수 / 분
    }
}
