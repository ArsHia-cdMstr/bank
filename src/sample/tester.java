package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class tester {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//       Account account = new LongTermAccount("a");
//       DataBase.print(account);
//       System.out.println(account);
//        System.out.println(DataBase.readAccount("object"));
        System.out.println(DataBase.isNationalCodeExist("0123456789"));

    }
}
