import java.util.*;
public class Person {

    protected String firstname;
    protected String surname;
    protected int age;
    protected String gender;
    protected String dateofbirth;
    protected String phonenumber;

    //constructor

    public Person(){
    }

//    public Person(String name, String sname, int age, String gender, int day, int month, int year, String phonenumber) {
//        this.firstname = name;
//        this.surname=sname;
//        this.age = age;
//        this.gender =  gender;
////        setdateofbirth(day,month,year);
//        this.phonenumber=phonenumber;
//    }

    public Person(String firstname, String surname, int age, String gender, String dateofbirth, String phonenumber) {
        this.firstname = firstname;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.dateofbirth = dateofbirth;
        this.phonenumber = phonenumber;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }





    // setter and getter methods

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }



    public String getPhonenumber() {
        return phonenumber;
    }

}
