import java.util.*;
public class ClinicManager {

    static ArrayList<Doctor> doctors=new ArrayList<Doctor>();
    static ArrayList<Patient> patients=new ArrayList<Patient>();
    static ArrayList<Consultation> consultations=new ArrayList<Consultation>();
    public static void addDoctors(ArrayList<Doctor> docs){

        Doctor d1=new Doctor(3834,"Skin","Alex","Bhatti",28,"Male","03-04-1993","9377262","20","25","0600","0900");
        Doctor d2=new Doctor(7763,"Skin","Sarah","Joseph",43,"Female","13-05-1990","977662","05","15","1200","0300");
        Doctor d3=new Doctor(9970,"Skin","Harper","Joshua",24,"Male","23-04-1998","9636622","15","20","0900","1200");

        docs.add(d2);
        docs.add(d1);
        docs.add(d3);

    }
    public static void main(String[] args) {
        ClinicManager.addDoctors(doctors);
        gui.createWindow();
    }


}
