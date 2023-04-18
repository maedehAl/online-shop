package sample;

public class IndividualLimitChecker implements LimitChecker {
    @Override
    public int validateLimit(int amount, String ssn) {
        if (amount > 100) {
            return 0;
        }
        return amount;
    }
}
