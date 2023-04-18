package sample;

public class SpecialCustomerLimitChecker implements LimitChecker {
    @Override
    public int validateLimit(int amount, String ssn) {
        if (amount < 7777) {
            return amount;
        }
        return 0;
    }
}
