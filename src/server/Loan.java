package server;

import server.Account;
import server.DataBase;

import java.io.Serializable;
import java.util.ArrayList;

public class Loan implements Serializable {
    double loanRate;
    int loanAmount;
    int amountOfPaymentDeadlineInMinute;
    int accountNumber;
    long dateCreated ;
    int remainingMinute;
    
    public Loan(double loanRate, int loanAmount, int Minute, int accountNumber) {
        this.loanRate = loanRate;
        this.loanAmount = (int) (loanAmount * loanRate);
        this.remainingMinute = Minute;
        this.amountOfPaymentDeadlineInMinute = this.loanAmount / Minute ;
        this.accountNumber = accountNumber;
        this.dateCreated = System.currentTimeMillis();
        DataBase.loans.add(this);
        DataBase.printLoan(DataBase.loans);
    }
     void pay (Loan loan){
        Account account = DataBase.readAccount(loan.accountNumber);
        account.withdraw(loan.amountOfPaymentDeadlineInMinute);

    }

     void checkDeadLine (long timeNow){
        
        long diffrenceOfTimesInMinute = (timeNow - dateCreated) / ( 1000 * 60 ) ;
        if (diffrenceOfTimesInMinute >= 1 ){

            for (int i = 1; i <= diffrenceOfTimesInMinute ; i++)  {
                diffrenceOfTimesInMinute --;
                pay(this);
                remainingMinute--;
                if (remainingMinute == 0){
                    DataBase.deleteloan(accountNumber);
                    return ; 
                }
            }

            dateCreated = timeNow ;
        }

    }


    }

