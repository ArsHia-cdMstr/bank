package server;

import java.io.Serializable;

public class AccountNumberInfo implements Serializable {
    public Account account;
    public String nationalCode;

    public AccountNumberInfo(Account account, String nationalCode) {
        this.account = account;
        this.nationalCode = nationalCode;
        DataBase.printAccountNumberInfo(nationalCode,this);
    }
}
