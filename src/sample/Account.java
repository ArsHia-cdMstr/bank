package sample;

import java.util.ArrayList;

public class Account  {

    protected static int AccountNumber = 0;
    protected int balance ;

    protected ArrayList<MoneyTransfer> moneyTransfersList =
            new ArrayList<>();

    public Account(int balance) {
        this.balance = balance;
        AccountNumber++;
    }

    public Account() {
        this( 0 );
    }

    // depsit method to deposit the account balance
    public void Deposit (int deposit ) {
        balance += deposit;
    //moneyTransfersList.add(new MoneyTransfer());
    }

    // withdraw method to withdraw the account balance
    public void withdraw (int withdraw){
        if (withdraw > balance)
            /* Error.setError (" the balanc is less than the withdraw") ;*/
            return;
        balance -= withdraw ;

    }

    static int transferNumber ;
    class MoneyTransfer {

        public MoneyTransfer(char transferType) {
            this.transferType = transferType;
        }

        char transferType;

    }


}
