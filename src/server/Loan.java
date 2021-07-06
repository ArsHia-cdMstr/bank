package server;

import server.Account;
import server.DataBase;

public class Loan {
    double loanRate;
    int loanAmount;
    int amountOfPaymentDeadlineInMonth;
    int accountNumber;
    long dateCreated ;
    public Loan(double loanRate, int loanAmount, int month, int accountNumber) {
        this.loanRate = loanRate;
        this.loanAmount = (int) (loanAmount * loanRate);
        this.amountOfPaymentDeadlineInMonth = this.loanAmount / month ;
        this.accountNumber = accountNumber;
        this.dateCreated = System.currentTimeMillis();
        DataBase.printLoan(accountNumber , this);
    }
    public void pay (Loan loan){
        monthDeadLine(String.valueOf(loan.accountNumber), loan.amountOfPaymentDeadlineInMonth);
    }

    public void monthDeadLine(String accountNum , int withdrawAmount){
        Account account = DataBase.readAccount(accountNumber);
        account.withdraw(withdrawAmount);

    }

    public boolean checkDeadLine (long timeNow,int accountNumber){
        Loan loan = DataBase.readLoan(accountNumber);
        long diffrenceOfTimesInMonth = (timeNow - loan.dateCreated) / ( 1000 * 60 * 60 *24 * 30) ;
        if (diffrenceOfTimesInMonth > 1 ){
            diffrenceOfTimesInMonth --;
            pay(loan);
            return true;
        }
        return false;
    }
}
