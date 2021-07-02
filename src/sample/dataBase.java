package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

// save 'the data which shold be saved even if the
// program is close' in multiple files
public class dataBase {

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

   public static ArrayList<User> users = new ArrayList<>();

    public static int userNumber (){return givefileNumber(1,"UserNumber"); };
    public static int accountNumber (){return givefileNumber(1000,"AccountNumber"); };
    public static int transfeNumber (){return givefileNumber(1,"TransferNumber"); };


}
