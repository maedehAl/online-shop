package sample;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        LimitService limitService = new LimitService();
        Field myLimitChecker = LimitService.class
                .getDeclaredField("myLimitChecker");
        myLimitChecker.setAccessible(true);
        myLimitChecker.set(limitService, new BranchLimitChecker());
//        limitService.setMyLimitChecker(new BranchLimitChecker());

        boolean resp = limitService.checkLimit(10000, "1231313");

        System.out.println(resp);

        LimitService limitService2 = new LimitService();
        myLimitChecker.setAccessible(true);
        myLimitChecker.set(limitService2, new IndividualLimitChecker());
        boolean resp2 = limitService2.checkLimit(10000, "1231313");

        System.out.println(resp2);
    }
}
