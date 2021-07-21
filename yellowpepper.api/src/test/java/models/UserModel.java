package models;

public class UserModel {

    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

    public UserModel(){ }

    public int getId(){ return this.id; }

    public String getUserName() { return this.userName; }

    public String getFirstName() { return this.firstName; }

    public String getLastName() { return this.lastName; }

    public String getEmail() { return this.email; }

    public String getPassword() { return this.password; }

    public String getPhone() { return this.phone; }

    public int getUserStatus(){ return this.userStatus; }

    public void setId(int id){ this.id = id; }

    public void setUserName(String userName) { this.userName = userName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setEmail(String email) { this.email = email; }

    public void setPassword(String password) { this.password = password; }

    public void setPhone(String phone) { this.phone = phone; }

    public void setUserStatus(int userStatus){ this.userStatus = userStatus; }
}