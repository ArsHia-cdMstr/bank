package server;

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


    public static Account readAccount(String alias) {
        try ( // Create an input stream for file object.dat
              ObjectInputStream input =
                      new ObjectInputStream(new FileInputStream("Users/" +user.NationalCode+ "/" +alias + ".dat"));
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
    public static ArrayList<String> readAlias(String nationalCode) {
        try ( // Create an input stream for file object.dat
              ObjectInputStream input =
                      new ObjectInputStream(new FileInputStream("Users/" + nationalCode +"/AliasNames.dat"));
        ) {

            return(ArrayList<String>) input.readObject();
        } catch (Exception e) {
            error.setError("the userName is invalid!");
        }

        return null;
    }
    public static AccountNumberInfo readAccountNumberInfo(String accountNumber) {
        try ( // Create an input stream for file object.dat
              ObjectInputStream input =
                      new ObjectInputStream(new FileInputStream("Users/" +accountNumber+ ".dat"));
        ) {

            return(AccountNumberInfo) input.readObject();
        } catch (Exception e) {
            error.setError("the Account number  is invalid!");
        }

        return null;
    }

    //making an account
    public static void printnewAccount(String NationalCode,Account account) {
        printAlias(NationalCode, user.AliasesOfUser);
        printUser(user);
        try ( // Create an output stream for file object.dat

              ObjectOutputStream output =
                      new ObjectOutputStream(new FileOutputStream("Users/"+ NationalCode + "/"+ account.alias + ".dat"));

        ) {
// Write a string, double value, and object to the file
            output.writeObject(account);
        } catch (Exception e) {
        }
    }

    // renaming the alias of an account
    public static void printAccount(String NationalCode,Account account, String defalutAlias) {
        File file = new File("Users/"+ NationalCode + "/"+ defalutAlias + ".dat");
        file.delete();
        printAlias(NationalCode, user.AliasesOfUser);
        try ( // Create an output stream for file object.dat

              ObjectOutputStream output =
                      new ObjectOutputStream(new FileOutputStream("Users/"+ NationalCode + "/"+ account.alias + ".dat"));

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
    public static void printAlias(String NationalCode,ArrayList<String> AliasesOfUser) {


        try ( // Create an output stream for file object.dat

              ObjectOutputStream output =
                      new ObjectOutputStream(new FileOutputStream("Users/" + NationalCode +"/AliasNames.dat"));

        ) {
// Write a string, double value, and object to the file
            output.writeObject(AliasesOfUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean isNationalCodeExist (String username){
        File file = new File("Users/" + username);
        if(file.isDirectory()){
            error.setError("you have signed up before please go to sign in page ");
            return true;
        }else {
            return false;
        }
    }
    public static void printAccountNumberInfo(String NationalCode,AccountNumberInfo accountNumberInfo) {


        try ( // Create an output stream for file object.dat

              ObjectOutputStream output =
                      new ObjectOutputStream(new FileOutputStream("Users/"+ accountNumberInfo.account.AccountNum + ".dat"));

        ) {
// Write a string, double value, and object to the file
            output.writeObject(accountNumberInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteAccount(String nationalCode, Account account){

        user.AccountNumbersOfUser.remove(account.AccountNum);
        user.NumberOfUserAccount-- ;
        user.AccountNumbersOfUser.remove(account.alias);

        File deletedFile = new File("Users/" + nationalCode + account.alias + ".dat");
        deletedFile.delete();
    }
//    public static ArrayList<AccountNumberInfo> accountNumberInfos = new ArrayList<>();


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