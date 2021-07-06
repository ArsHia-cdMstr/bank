package server;

import sample.SignUp;

import java.io.Serializable;

public class LongTermAccount extends Account implements Serializable {

    //interest rate for each 3 min
    final double interestRate = 1.5;

    public LongTermAccount(int balance, String AccountPassword) {
        super(balance, AccountPassword);
        DataBase.printnewAccount(this);
    }

    public LongTermAccount(String AccountPassword) {
        this(0,AccountPassword);
    }

    // call it when you wanna show the balance
    public void IncreasProfitToBalance(){

        long TimeDiffrence = System.currentTimeMillis() - AccountDateCreated;

        //the times that we should clculate balance
        int calculateTimes = (int) (TimeDiffrence % ( 3 * 60 * 1000 ));
        for (int i = 1; i <= calculateTimes; i++)
            balance *= interestRate;

    }

    @Override
    public int getBalance(){
        IncreasProfitToBalance();
        return balance;
    }


    @Override
    public String toString() {
        return "LongTermAccount{" +
                "alias='" + alias + '\'' +
                ", balance=" + balance +
                ", AccountDateCreated=" + AccountDateCreated +
                ", AccountPassword='" + AccountPassword + '\'' +
                ", moneyTransfersList=" + moneyTransfersList +
                ", AccountNum=" + AccountNum +
                '}';
    }
}
