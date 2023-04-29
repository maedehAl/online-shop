package sample;

public class LimitService {

    private LimitChecker myLimitChecker;
    //private IndividualLimitChecker myLimitChecker = new IndividualLimitChecker();


    public LimitService() {
    }

    public LimitService(LimitChecker myLimitChecker) {
        this.myLimitChecker = myLimitChecker;
   }

//    public void setMyLimitChecker(LimitChecker myLimitChecker) {
//        this.myLimitChecker = myLimitChecker;
//    }

    public boolean checkLimit(int amount, String ssn){
        int resp = myLimitChecker.validateLimit(amount, ssn);
        return amount==resp;
    }
}
