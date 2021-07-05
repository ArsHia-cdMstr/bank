package server;

import sample.SignUp;
import sample.error;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Account implements Serializable {

    public String alias;
    protected int balance ;
    protected long AccountDateCreated;
    public String AccountPassword;
    protected ArrayList<MoneyTransfer> moneyTransfersList = new ArrayList<>();
    public int AccountNum;

    protected Account(int balance, String AccountPassword) {
        this.balance = balance;
        this.AccountPassword = AccountPassword;
        this.AccountDateCreated = System.currentTimeMillis();
        AccountNum = DataBase.accountNumber();
        DataBase.user.NumberOfUserAccount++;
        DataBase.user.AccountNumbersOfUser.add(AccountNum);
        alias = "Account" + DataBase.user.NumberOfUserAccount;
        DataBase.user.AliasesOfUser.add(alias);
        DataBase.printnewAccount(DataBase.user.NationalCode,this);
    }
    //change alias from alias default to new alias
    public boolean changeAlias(String defaultAlias, String newAlias, Account account){
        if (DataBase.user.AliasesOfUser.contains(newAlias)){
            error.setError("this alias already exists");
            return false;
        }
        if ( !DataBase.user.AliasesOfUser.contains(defaultAlias)){
            error.setError("you haven't build this account");
            return false;
        }
        else {
            DataBase.user.AliasesOfUser.remove(defaultAlias);
            DataBase.user.AliasesOfUser.add(newAlias);
            account.alias = newAlias;
            DataBase.printAccount(DataBase.user.NationalCode, account, defaultAlias);
            return true;
        }
    }

    public Account( String AccountPassword) {
        this(0,AccountPassword);
    }

    // depsit method to deposit the account balance
    public void Deposit (int deposit ) {
        balance += deposit;
        moneyTransfersList.add(new MoneyTransfer("Deposit", balance));
    }

    // withdraw method to withdraw the account balance
    public void withdraw (int withdraw){

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


    public int getBalance(){
        return 12345;
    }


    public  void setBalance(int balance1){
        balance = balance1;
    }

}


