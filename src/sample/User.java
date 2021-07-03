package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Serializable {

    private int numberOfAPersonAccount;
//    private static int userNumber;
    private String FirstName;
    private String LastName;
    private String Password;
    protected String NationalCode;
    private String Email;
    private String Phone;
    public int NumberOfUserAccount = 0;
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
        //make a dir in Users dir in the name
        // of national code dir
        makeThisUserDir(nationalCode);
        DataBase.printUser(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "numberOfAPersonAccount=" + numberOfAPersonAccount +
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
