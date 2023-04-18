package sample;

public class CorportateLimitChecker implements LimitChecker {
    @Override
    public int validateLimit(int amount, String ssn) {
        if (amount < 200) {
            return amount;
        }
        return 0;
    }
}
