package sample;

public class User {

    private int numberOfAPersonAccount = 0;
    private int userNumber;
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
        userNumber = dataBase.users.size() -1 ;
    }


    @Override
    public String toString() {
        return
                 userNumber + " " +
                 FirstName + " " +
                 LastName + " " +
                 Password + " " +
                 NationalCode + " " +
                 Email + " " +
                 Phone    ;
    }
}
