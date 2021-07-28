package server;

import server.Loan;
import sample.SignUp;
import sample.error;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// save 'the data which shold be saved even if the
// program is close' in multiple files
public class DataBase {


    public static User user;

    public static void userSaver(User user1){
        user = user1 ;
    }

    public static void changeDestinationAlias(ArrayList<UsedAccount> usedAccounts,int accountNumber,String newAlias){
        UsedAccount UA = serchByAccountNumber( usedAccounts , accountNumber);
        usedAccounts.remove(usedAccounts.indexOf(UA));
        UA.Alias = newAlias;
        usedAccounts.add(UA);
//we have to save the account after these
    }
    static UsedAccount serchByAccountNumber(ArrayList<UsedAccount> usedAccounts , int accountNumber ){
        for (UsedAccount U : usedAccounts){
            if ( U.usedAccountNumber == accountNumber)
                return U;
        }
        return null;
    }


    public static ArrayList<Loan> loans = new ArrayList<>();
    public void checkAllLoanDeadLines () {
        ArrayList<Loan> loans = DataBase.readLoan();
        for (Loan loan : loans) {
            loan.checkDeadLine(System.currentTimeMillis());
        }
    }


    public static Account readAccount(int accountNumber) {
        try ( // Create an input stream for file object.dat
              ObjectInputStream input =
                      new ObjectInputStream(new FileInputStream("Users/" + accountNumber + ".dat"));
        ) {

            return(Account)input.readObject();
        } catch (Exception e) {
        error.setError(accountNumber + "account name didn't found");
        }

        return null;
    }
    public static User readUser(String nationalCode) {
        try ( // Create an input stream for file object.dat
              ObjectInputStream input =
                      new ObjectInputStream(new FileInputStream("Users/" + nationalCode + "/UserInfo.dat"));
        ) {

            return(User) input.readObject();
        } catch (Exception e) {
            error.setError("username invalid!");
        }

        return null;
    }
    public static ArrayList<Loan> readLoan () {
        try ( // Create an input stream for file object.dat
              ObjectInputStream input =
                      new ObjectInputStream(new FileInputStream("Users/" + "Loans.dat"));
        ) {

            return (ArrayList<Loan>) input.readObject();
        } catch (Exception e) {
            error.setInfo("this Account number has no Loan");
        }

        return null;
    }
    public static void printnewAccount(Account account) {
        printUser(user);
        try ( // Create an output stream for file object.dat

              ObjectOutputStream output =
                      new ObjectOutputStream(new FileOutputStream("Users/"+ account.AccountNum + ".dat"));

        ) {

            output.writeObject(account);
        } catch (Exception e) {
        }
    }
    public static void printUser(User user) {

        try ( // Create an output stream for file object.dat

              ObjectOutputStream output =
                      new ObjectOutputStream(new FileOutputStream("Users/"+ user.NationalCode +"/UserInfo.dat"));

        ) {
// Write a string, double value, and object to the file
            output.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean isNationalCodeExist (String username){
        //    public static void printAccountNumberInfo(String NationalCode,Account account) {
//
//
//        try ( // Create an output stream for file object.dat
//
//              ObjectOutputStream output =
//                      new ObjectOutputStream(new FileOutputStream("Users/"+ account.AccountNum + ".dat"));
//
//        ) {
//// Write a string, double value, and object to the file
//            output.writeObject(account);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
        File file = new File("Users/" + username);
        if(file.isDirectory()){
            error.setError("you have signed up before please go to sign in page ");
            return true;
        }else {
            return false;
        }
    }
    public static void deleteAccount( Account account){

        user.AccountNumbersOfUser.remove(user.AccountNumbersOfUser.indexOf(account.AccountNum));
        user.NumberOfUserAccount-- ;
        user.AliasesOfUser.remove(user.AliasesOfUser.indexOf(account.alias));
        printUser(user);

        File deletedFile = new File("Users/" + account.AccountNum + ".dat");
        deletedFile.delete();
    }
    public static void deleteloan (int accountNumber ){


        File deletedFile = new File("Users/" + accountNumber + "Loan.dat");
        deletedFile.delete();
    }
    public static void printLoan( ArrayList<Loan> loans ){
        try ( // Create an output stream for file object.dat

              ObjectOutputStream output =
                      new ObjectOutputStream(new FileOutputStream("Users/" + "Loans.dat"));

        ) {
// Write a string, double value, and object to the file
            output.writeObject(loans);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    // public static Integer userNumber (){return givefileNumber(1,"UserNumber"); };
    public static Integer accountNumber (){return givefileNumber(1000,"AccountNumber"); }
    public static Integer transfeNumber (){return givefileNumber(1000,"TransferNumber"); }

    // the number that we start from :int number
    //the file which we save the file in: String numberType
    static int givefileNumber (int number ,String numberType){
        int Number = number;
        File file = new File(numberType);

        try(
                Scanner input = new Scanner(file);
        ) {

            if (input.hasNext()) {
                Number = (1 + input.nextInt());
            }

        } catch (FileNotFoundException e) {
        }

        try (
                PrintWriter output = new PrintWriter(file);
        ){
            output.println(Number);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return Number;
    }

}