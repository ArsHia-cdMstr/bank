package server;

import sample.error;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// save 'the data which shold be saved even if the
// program is close' in multiple files
public class DataBase {



    public static Account readAccount(String natioanlcode ,String alias) {
        try ( // Create an input stream for file object.dat
              ObjectInputStream input =
                      new ObjectInputStream(new FileInputStream("Users/" +natioanlcode+ "/" +alias + ".dat"));
        ) {

            return(Account)input.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public static User readUser(String nationalCode)  {
        try ( // Create an input stream for file object.dat
              ObjectInputStream input =
                      new ObjectInputStream(new FileInputStream("Users/" + nationalCode + "/UserInfo.dat"));
        ) {

            return(User) input.readObject();
        } catch (Exception e) {
            error.setError("username invalid!");
            e.printStackTrace();
        }

        return null;
    }
    public static ArrayList<String> readAlias(String nationalCode)  {
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

    public static void printAccount(Account account){

        try ( // Create an output stream for file object.dat

              ObjectOutputStream output =
                      new ObjectOutputStream(new FileOutputStream("Users/"+account.NationalCode + "/"+account.alias + ".dat"));

        ) {
            // Write a string, double value, and object to the file
            output.writeObject(account);
        } catch (Exception e) {
            e.printStackTrace();
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
    public static void printAlias(Account account) {

        try ( // Create an output stream for file object.dat

              ObjectOutputStream output =
                      new ObjectOutputStream(new FileOutputStream("Users/" + account.NationalCode +"/AliasNames.dat"));

        ) {
            // Write a string, double value, and object to the file
            output.writeObject(account.AliasesOfUser);
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




//    public static Integer userNumber (){return givefileNumber(1,"UserNumber"); };
    public static Integer accountNumber (){return givefileNumber(1000,"AccountNumber"); }
    public static Integer transfeNumber (){return givefileNumber(1000,"TransferNumber"); }

    // the number that we start from :int number
    //the file which we save the file in: String numberType
    static int givefileNumber (int number ,String numberType){
        int Number = number;
        File file = new File(numberType);

        try(
                PrintWriter output = new PrintWriter(file);
                Scanner input = new Scanner(file);
        ) {

            if (input.hasNext())
                Number = input.nextInt()+1;

            output.println(Number);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return Number;
    }

}
