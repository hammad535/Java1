import javax.swing.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Patient extends Person{
    private String UniqueId;

    public Patient(String UniqueId, String firstname, String surname, int age, String gender, String dateofbirth, String phonenumber) {
        super(firstname, surname, age, gender, dateofbirth, phonenumber);
        this.UniqueId = UniqueId;
    }

    Patient() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getFirstname() {
        return firstname;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getDateofbirth() {
        return dateofbirth;
    }

    @Override
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setUniqueId(String UniqueId) {
        this.UniqueId = UniqueId;
    }

    public String getUniqueId() {
        return UniqueId;
    }



}
