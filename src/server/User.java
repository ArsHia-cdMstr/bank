package server;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Serializable {

    //    private static int userNumber;
    public String FirstName;
    public String LastName;
    public String Password;
    public String NationalCode;
    public String Email;
    public String Phone;
    public int NumberOfUserAccount;
    public ArrayList<Integer> AccountNumbersOfUser = new ArrayList<>();
    public ArrayList<String> AliasesOfUser = new ArrayList<>();

    public User(){}

    public User(String firstName, String lastName, String password,
                String nationalCode, String email, String phone) {
        FirstName = firstName;
        LastName = lastName;
        Password = password;
        NationalCode = nationalCode;
        Email = email;
        Phone = phone;
        NumberOfUserAccount = 0;
        //make a dir in Users dir in the name
        // of national code dir
        makeThisUserDir(nationalCode);
        DataBase.printUser(this);
    }

    @Override
    public String toString() {
        return "User{" +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Password='" + Password + '\'' +
                ", NationalCode='" + NationalCode + '\'' +
                ", Email='" + Email + '\'' +
                ", Phone='" + Phone + '\'' +
                ", NumberOfUserAccount=" + NumberOfUserAccount +
                ", AccountNumbersOfUser=" + AccountNumbersOfUser +
                '}';
    }

    void makeThisUserDir(String username) {
        //make "username" directory in Users Direcrory
        File usernamefile = new File("Users", username);
        usernamefile.mkdir();

    }
}
