import javax.swing.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Consultation {


    protected String notes;
    protected double cost;
    protected int patientID;
    protected int doctorID;
    protected int timing;



    public Consultation(String notes, double cost,int patientID, int doctorID, int timing) {
        this.notes = notes;
        this.cost = cost;
        this.doctorID=doctorID;
        this.patientID=patientID;
        this.timing=timing;
    }

    public int getTiming() {
        return timing;
    }

    public void setTiming(int timing) {
        this.timing = timing;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static final String ALGORITHM = "AES";

    public static void prepareSecreteKey(String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String strToEncrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    public static void viewConsultations(JTextArea dntextArea){

        dntextArea.setText("");

        if(ClinicManager.consultations.size()==0)
            dntextArea.setText("\n\n\n\tNo Consultations booked yet! ");
        else
            for(int i=0;i<ClinicManager.consultations.size();i++){
                dntextArea.append("     "+ClinicManager.consultations.get(i).patientID+"\t    "+ClinicManager.consultations.get(i).doctorID+"\t      "+ClinicManager.consultations.get(i).cost+"\t"+ClinicManager.consultations.get(i).timing+"-01-2023 \n\n");
            }
    }


    public static void bookConsultation(String name, String dob, int age,String phone, String docid, String notes, String gender, int timing , JTextArea dntextArea){

        String encryptedNotes=encrypt(notes, "secret");
        int uniqueID = ThreadLocalRandom.current().nextInt(100, 10000 + 1);

        String[] splited = name.split("\\s+");
        Patient p=new Patient(""+uniqueID,splited[0],splited[1],age,gender,dob,phone);
        ClinicManager.patients.add(p);

        int cost=25;
        Consultation c=new Consultation(encryptedNotes,cost,uniqueID,Integer.valueOf(docid),timing);
        ClinicManager.consultations.add(c);

        JOptionPane.showMessageDialog(null,"\t Consultation has been booked!","Info",
                JOptionPane.INFORMATION_MESSAGE);

        viewConsultations(dntextArea);

    }
}
