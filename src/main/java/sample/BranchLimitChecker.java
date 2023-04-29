package sample;

public class BranchLimitChecker implements LimitChecker {
    @Override
    public int validateLimit(int amount, String ssn) {
        if (amount < 999999999) {
            return amount;
        }
        return 0;
    }
}
