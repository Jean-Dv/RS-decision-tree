package co.edu.uptc.model;

public class User {

    private int userId;
    private String name;
    private String lastName;
    private String gender;
    private String nationality;

    public User() {
    }

    public User(int userId, String name, String lastName, String gender, String nationality) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", name=" + name + ", lastName=" + lastName + ", gender=" + gender
                + ", nationality=" + nationality + "]";
    }

}
