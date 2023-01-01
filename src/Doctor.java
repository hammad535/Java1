import javax.swing.*;
import java.util.*;
public class Doctor extends Person{

    static int opCtr=0;
    protected int licencenumber;
    protected String specialisation;

    protected String availableDateFrom;

    protected String availableDateTo;

    protected String availableTimeFrom;

    protected String availableTimeTo;

    public Doctor() {
    }



    public Doctor(int licencenumber, String specialisation, String firstname, String surname, int age, String gender, String dateofbirth, String phonenumber,String availableDateFrom,String availableDateTo,String availableTimeFrom,String availableTimeTo) {
        super(firstname, surname, age, gender, dateofbirth, phonenumber);
        this.licencenumber = licencenumber;
        this.specialisation = specialisation;
        this.availableDateFrom=availableDateFrom;
        this.availableDateTo=availableDateTo;
        this.availableTimeFrom=availableTimeFrom;
        this.availableTimeTo=availableTimeTo;
    }



//    Doctor(String firstname, String surname, String mobilenumber, int licencenumber, LocalDate dateofbirth) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    public void setLicencenumber(int licencenumber) {
        this.licencenumber = licencenumber;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public int getLicencenumber() {
        return licencenumber;
    }

    public String getSpecialisation() {
        return specialisation;
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


    public static void checkAvailability(int licence, int date, JTextField t5,JTextField name,JTextField age,JTextField DOB,JTextField gender,JTextField Phone,JTextArea Notes,JButton book ){
        int flag=0;int flag2=0;

        if(date<30 && date>0) {

            for (int i = 0; i < ClinicManager.doctors.size(); i++)
                if (ClinicManager.doctors.get(i).licencenumber == licence) {
                    flag2 = 1;
                    if (date > Integer.valueOf(ClinicManager.doctors.get(i).availableDateFrom) && date < Integer.valueOf(ClinicManager.doctors.get(i).availableDateTo)) {
                        t5.setEditable(true);
                        t5.setText(Integer.toString(licence));
                        t5.setEditable(false);
                        name.setEditable(true);
                        age.setEditable(true);
                        gender.setEditable(true);
                        DOB.setEditable(true);
                        Notes.setEditable(true);
                        Phone.setEditable(true);
                        book.setEnabled(true);
                        flag = 1;
                        break;

                    }
                }
            if (flag2 == 0)
                JOptionPane.showMessageDialog(null, "\t Wrong Licence number provided. Please recheck from the list and try again.", "Info",
                        JOptionPane.INFORMATION_MESSAGE);

            if (flag == 1)
                JOptionPane.showMessageDialog(null, "\t Your specified doctor is available. Proceed to input form.", "Info",
                        JOptionPane.INFORMATION_MESSAGE);

            if (flag == 0 && flag2 == 1) {
                for (int i = 0; i < ClinicManager.doctors.size(); i++)
                    if (date > Integer.valueOf(ClinicManager.doctors.get(i).availableDateFrom) && date < Integer.valueOf(ClinicManager.doctors.get(i).availableDateTo)) {
                        t5.setEditable(true);
                        t5.setText(Integer.toString(ClinicManager.doctors.get(i).licencenumber));
                        t5.setEditable(false);
                        name.setEditable(true);
                        age.setEditable(true);
                        gender.setEditable(true);
                        DOB.setEditable(true);
                        Notes.setEditable(true);
                        Phone.setEditable(true);
                        book.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "\t Your specified doctor isn't available. Another doctor has been assigned. Proceed to input form.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        flag = 1;
                        break;

                    }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "\t Incorrect date format !", "Info",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void displayDoctors(JTextArea dntextArea){
        for(int i=0;i<ClinicManager.doctors.size();i++)
            dntextArea.append(ClinicManager.doctors.get(i).licencenumber+"\t"+ClinicManager.doctors.get(i).firstname+" "+ClinicManager.doctors.get(i).surname+"\t         "+ClinicManager.doctors.get(i).gender+"\t               "+ClinicManager.doctors.get(i).specialisation+"       \t\t\t"+ClinicManager.doctors.get(i).availableDateFrom+"-"+ClinicManager.doctors.get(i).availableDateTo+" [Every Month]"+     "\n\n");
    }


    public static void sort(JTextArea dntextArea) {

        if(opCtr==0) {
            ClinicManager.doctors.sort((o1, o2)
                    -> o1.firstname.compareTo(
                    o2.firstname));
            dntextArea.setText("");
            opCtr = 1;
            displayDoctors(dntextArea);
        }else
            JOptionPane.showMessageDialog(null,"\t List is already sorted! ","Info",
                    JOptionPane.INFORMATION_MESSAGE);
    }

}
