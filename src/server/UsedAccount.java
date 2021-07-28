package server;

import java.io.Serializable;

public class UsedAccount implements Serializable {
    public int usedAccountNumber;
    public String Alias;

    public UsedAccount( int usedAccountNumber) {
        this.usedAccountNumber = usedAccountNumber;
        this.Alias = String.valueOf(usedAccountNumber);
    }

}

