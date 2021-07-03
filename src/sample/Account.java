package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Account extends User implements Serializable {

    protected String alias;
    protected int balance ;
    protected long AccountDateCreated;
    protected String AccountPassword;
    protected ArrayList<MoneyTransfer> moneyTransfersList = new ArrayList<>();
    protected int AccountNum;

    protected Account(int balance, String AccountPassword) {
        this.balance = balance;
        this.AccountPassword = AccountPassword;
        this.AccountDateCreated = System.currentTimeMillis();
        AccountNum = DataBase.accountNumber();
        NumberOfUserAccount++;
        AccountNumbersOfUser.add(AccountNum);
        alias = "Account" + NumberOfUserAccount;
        AliasesOfUser.add(alias);
        DataBase.printAccount(this);
        DataBase.printAlias(this);
    }

    public void changeAlias(String defaultAlias, String newAlias){
        if (!AliasesOfUser.contains(defaultAlias))
            error.setError("you haven't build this account");
        else {
            AliasesOfUser.remove(defaultAlias);
            AliasesOfUser.add(newAlias);
            DataBase.printAlias(this);
        }
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

        if (withdraw > balance) {
            error.setError(" the balanc is less than the withdraw");
            return;
        }

        balance -= withdraw ;
        moneyTransfersList.add(new MoneyTransfer("Withdraw", balance));

    }

    // we save Money transfers info
    // in objects of this class
    class MoneyTransfer {

        int transferNumber;
        String transferType;
        Date transferDate ;
        int remain;

        public MoneyTransfer(String transferType, int remain) {
            this.transferType = transferType;
            transferDate = new Date(System.currentTimeMillis());
            this.remain = remain;
            transferNumber = DataBase.transfeNumber();
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
