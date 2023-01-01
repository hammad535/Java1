import java.awt.*;

import javax.lang.model.element.Name;
import javax.swing.*;

import java.awt.event.*;

import java.util.*;

public class gui extends JFrame{



    public static void createWindow() {
        JFrame frame = new JFrame("Clinic Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }





    private static void createUI(final JFrame frame){
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panel1 = new JPanel(false);
        JLabel filler = new JLabel("View Doctors");
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel1.setLayout(null);
        panel1.add(filler);
        tabbedPane.addTab("View Doctors", null, panel1,"Tab 1 tooltip");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        JPanel panel2 = new JPanel(false);
        JLabel filler2 = new JLabel("");
        filler2.setHorizontalAlignment(JLabel.CENTER);
        panel2.setLayout(null);
        panel2.add(filler2);
        tabbedPane.addTab("Bookings", null, panel2,"Tab 2 tooltip");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        JTextArea dntextArea = new JTextArea();
        dntextArea.setBounds(40, 50, 749, 500);
        dntextArea.setEditable(false);
        panel1.add(dntextArea);

        JLabel lblNewLabel_2 = new JLabel("ID");
        lblNewLabel_2.setBounds(52, 30, 46, 14);
        panel1.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Name");
        lblNewLabel_3.setBounds(142, 30, 46, 14);
        panel1.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Gender");
        lblNewLabel_4.setBounds(242, 30, 46, 14);
        panel1.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Speciality");
        lblNewLabel_5.setBounds(342, 30, 66, 14);
        panel1.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Availability");
        lblNewLabel_6.setBounds(653, 30, 66, 14);
        panel1.add(lblNewLabel_6);

        JButton sortDoctors = new JButton("Sort Alphabetically");
        sortDoctors.setBounds(850, 70, 150, 23);
        panel1.add(sortDoctors);

        Doctor.displayDoctors(dntextArea);

        sortDoctors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Doctor.sort(dntextArea);
            }
        });



        JLabel lab1 = new JLabel("Enter your full name:");
        lab1.setBounds(50, 80, 196, 14);
        panel2.add(lab1);
        JTextField name=new JTextField();
        name.setBounds(50,100, 200,30);
        panel2.add(name);
        name.setEditable(false);

        JLabel lab2 = new JLabel("Enter your DOB:");
        lab2.setBounds(50, 150, 156, 14);
        panel2.add(lab2);
        JTextField DOB=new JTextField();
        DOB.setBounds(50,170, 200,30);
        panel2.add(DOB);
        DOB.setEditable(false);

        JLabel lab3 = new JLabel("Enter your age:");
        lab3.setBounds(50, 220, 156, 14);
        panel2.add(lab3);
        JTextField age=new JTextField();
        age.setBounds(50,240, 200,30);
        panel2.add(age);
        age.setEditable(false);

        JLabel lab4 = new JLabel("Enter your Phone:");
        lab4.setBounds(50, 290, 156, 14);
        panel2.add(lab4);
        JTextField Phone=new JTextField();
        Phone.setBounds(50,310, 200,30);
        panel2.add(Phone);
        Phone.setEditable(false);

        JLabel lab5 = new JLabel("Doctor Selected");
        lab5.setBounds(50, 360, 156, 14);
        panel2.add(lab5);
        JTextField Selected=new JTextField();
        Selected.setBounds(50,380, 200,30);
        Selected.setEditable(false);
        panel2.add(Selected);

        JLabel lab37 = new JLabel("Enter your Gender:");
        lab37.setBounds(50, 430, 156, 14);
        panel2.add(lab37);
        JTextField gender=new JTextField();
        gender.setBounds(50,450, 200,30);
        panel2.add(gender);
        gender.setEditable(false);

        JLabel lab6 = new JLabel("Additional Notes if any");
        lab6.setBounds(50, 500, 256, 14);
        panel2.add(lab6);
        JTextArea Notes=new JTextArea();
        Notes.setBounds(50,520, 200,50);
        panel2.add(Notes);
        Notes.setEditable(false);

        JButton book = new JButton("Book Consultation");
        book.setBounds(50, 580, 150, 23);
        panel2.add(book);
        book.setEnabled(false);

        JTextArea t7=new JTextArea();
        t7.setBounds(900,120, 400,400);

        JTextField date=new JTextField();
        date.setBounds(480,200, 200,30);


        book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Consultation.bookConsultation(name.getText(),DOB.getText(),Integer.valueOf(age.getText()),Phone.getText(),Selected.getText(),Notes.getText(),gender.getText(),Integer.valueOf(date.getText()),t7);
                name.setText(""); name.setEditable(false);
                age.setText(""); age.setEditable(false);
                Phone.setText(""); Phone.setEditable(false);
                gender.setText(""); gender.setEditable(false);
                Notes.setText(""); Notes.setEditable(false);
                Selected.setText("");
                DOB.setText(""); DOB.setEditable(false);
                book.setEnabled(false);

            }
        });

        JLabel lab7 = new JLabel("Current Booked Consultations");
        lab7.setBounds(1050, 60, 256, 14);
        panel2.add(lab7);

        JLabel lab8 = new JLabel("ID");
        lab8.setBounds(920, 100, 150, 14);
        panel2.add(lab8);
        JLabel lab9 = new JLabel("Doctor ID");
        lab9.setBounds(1000, 100, 150, 14);
        panel2.add(lab9);
        JLabel lab90 = new JLabel("Price");
        lab90.setBounds(1100, 100, 150, 14);
        panel2.add(lab90);
        JLabel lab10 = new JLabel("Timings");
        lab10.setBounds(1200, 100, 150, 14);
        panel2.add(lab10);

        panel2.add(t7);
        t7.setEditable(false);

        JButton refresh = new JButton("Refresh");
        refresh.setBounds(1050, 540, 150, 23);
        panel2.add(refresh);

        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Consultation.viewConsultations(t7);
            }
        });

        JLabel lab52 = new JLabel("Enter the licence number of the doctor:");
        lab52.setBounds(480, 90, 256, 54);
        panel2.add(lab52);
        JTextField license=new JTextField();
        license.setBounds(480,130, 200,30);
        panel2.add(license);

        JLabel lab51 = new JLabel("Enter date (1-30)");
        lab51.setBounds(480, 180, 156, 14);
        panel2.add(lab51);
        panel2.add(date);

        JButton check = new JButton("Check Availability");
        check.setBounds(500, 270, 150, 23);
        panel2.add(check);

        check.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Doctor.checkAvailability(Integer.valueOf(license.getText()), Integer.valueOf(date.getText()),Selected,name,age,DOB,gender,Phone,Notes,book);
               // license.setText("");
               // date.setText("");
            }
        });


    }
}
