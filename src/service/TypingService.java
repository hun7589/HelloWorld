package src.service;

import src.dao.ResultDAO;

public class TypingService {

    public static double calculateAccuracy(String original, String typed) {
        return AccuracyCalculator.calculateAccuracy(original, typed);
    }

    public static double calculateSpeed(int typedLength, long durationMillis) {
        return AccuracyCalculator.calculateSpeed(typedLength, durationMillis);
    }

    public static void saveResult(int userId, int textId, double speed, double accuracy) {
        ResultDAO.saveResult(userId, textId, speed, accuracy);
    }
}
