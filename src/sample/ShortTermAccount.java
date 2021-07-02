package sample;

public class ShortTermAccount extends Account{


    //interest rate for each 1 min
    final double interestRate = 1.1;

    public ShortTermAccount(int balance, String AccountPassword) {
        super(balance, AccountPassword);
    }

    public ShortTermAccount(String AccountPassword) {
        super(AccountPassword);
    }

    // call it when you wanna show the balance
    public void IncreasProfitToBalance(long TimeDiffrence ){

        //the times that we should clculate balance
        int calculateTimes = (int) (TimeDiffrence % ( 60 * 1000 ));
        for (int i = 1; i <= calculateTimes; i++)
            balance *= interestRate;

    }
}
