package sample;

import java.util.ArrayList;
import java.util.Date;

public class Account  {

    protected static int AccountNumber = 0;
    protected int balance ;
    protected Date AccountDateCreated;
    protected String AccountPassword;
    protected ArrayList<MoneyTransfer> moneyTransfersList = new ArrayList<>();

    protected Account(int balance, String AccountPassword) {
        this.balance = balance;
        this.AccountPassword = AccountPassword;
        this.AccountDateCreated = new Date(System.currentTimeMillis());
        AccountNumber++;
    }

    protected Account( String AccountPassword) {
        this(0,AccountPassword);
    }

    // depsit method to deposit the account balance
    protected void Deposit (int deposit ) {
        balance += deposit;
    moneyTransfersList.add(new MoneyTransfer("Deposit", balance));
    }

    // withdraw method to withdraw the account balance
    protected void withdraw (int withdraw){
        if (withdraw > balance)
            /* Error.setError (" the balanc is less than the withdraw") ;*/
            return;
        balance -= withdraw ;
        moneyTransfersList.add(new MoneyTransfer("Withdraw", balance));

    }

    class MoneyTransfer {

        int transferNumber;
        String transferType;
        Date transferDate ;
        int remain;

        public MoneyTransfer(String transferType, int remain) {
            this.transferType = transferType;
            transferDate = new Date(System.currentTimeMillis());
            this.remain = remain;
            transferNumber = dataBase.transfeNumber();
        }

        @Override
        public String toString() {
            return "transferType: " + transferType +
                    "(\ttransferDate: " + transferDate +
                    "\tremain: " + remain +
                    "\ttransferNumber: " + transferNumber +
                    ")\n"
                    ;
        }
    }
}
