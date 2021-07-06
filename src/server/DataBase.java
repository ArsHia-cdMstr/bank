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


    public static Account readAccount(int accountNumber) {
        try ( // Create an input stream for file object.dat
              ObjectInputStream input =
                      new ObjectInputStream(new FileInputStream("Users/" + accountNumber + ".dat"));
        ) {

            return(Account)input.readObject();
        } catch (Exception e) {
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
//            error.setError("username invalid!");
            e.printStackTrace();
        }

        return null;
    }
    public static Loan readLoan (int accountNumber ) {
        try ( // Create an input stream for file object.dat
              ObjectInputStream input =
                      new ObjectInputStream(new FileInputStream("Users/" +accountNumber+ "Loan.dat"));
        ) {

            return(Loan)input.readObject();
        } catch (Exception e) {
            error.setInfo("this Account number has no Loan");
        }

        return null;
    }

    //making an account
    public static void printnewAccount(Account account) {
        printUser(user);
        try ( // Create an output stream for file object.dat

              ObjectOutputStream output =
                      new ObjectOutputStream(new FileOutputStream("Users/"+ account.AccountNum + ".dat"));

        ) {
// Write a string, double value, and object to the file
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
    public static void deleteAccount(String nationalCode, Account account){

        user.AccountNumbersOfUser.remove(account.AccountNum);
        user.NumberOfUserAccount-- ;
        user.AccountNumbersOfUser.remove(account.alias);

        File deletedFile = new File("Users/" + nationalCode + account.alias + ".dat");
        deletedFile.delete();
    }
    public static void printLoan(int accountNumber, Loan loan){
        try ( // Create an output stream for file object.dat

              ObjectOutputStream output =
                      new ObjectOutputStream(new FileOutputStream("Users/"+accountNumber + "loan.dat"));

        ) {
// Write a string, double value, and object to the file
            output.writeObject(loan);
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