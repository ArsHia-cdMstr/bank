package sample;

import java.io.*;
import java.util.Scanner;

public class User implements Serializable {

    private int numberOfAPersonAccount;
    private static int userNumber;
    private String FirstName;
    private String LastName;
    private String Password;
    private String NationalCode;
    private String Email;
    private String Phone;


    public User(String firstName, String lastName, String password,
                String nationalCode, String email, String phone) {
        FirstName = firstName;
        LastName = lastName;
        Password = password;
        NationalCode = nationalCode;
        Email = email;
        Phone = phone;
        userNumber = dataBase.userNumber();
        makeThisUserDir(String.valueOf(userNumber));
    }



    void makeThisUserDir(String username) {

        //make sure that Users directoru exists
        File UserDir = new File("Users");
        if (!UserDir.exists())
            UserDir.mkdir();

        //make "username" directory in Users Direcrory
        File usernamefile = new File("Users", username);
        usernamefile.mkdir();

    }
}
