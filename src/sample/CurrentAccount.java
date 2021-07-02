package sample;

public class CurrentAccount extends Account{

    public CurrentAccount(int balance, String AccountPassword) {
        super(balance, AccountPassword);
    }

    public CurrentAccount(String AccountPassword) {
        super(AccountPassword);
    }
}
