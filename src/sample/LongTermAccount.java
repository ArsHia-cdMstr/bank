package sample;

public class LongTermAccount extends Account{

    //interest rate for each 3 min
    final double interestRate = 1.5;

    public LongTermAccount(int balance, String AccountPassword) {
        super(balance, AccountPassword);
    }

    public LongTermAccount(String AccountPassword) {
        super(AccountPassword);
    }

    // call it when you wanna show the balance
    public void IncreasProfitToBalance(long TimeDiffrence ){

        //the times that we should clculate balance
        int calculateTimes = (int) (TimeDiffrence % ( 3 * 60 * 1000 ));
        for (int i = 1; i <= calculateTimes; i++)
            balance *= interestRate;

    }

}
