import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener {

    JTextField pan ,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;

    JComboBox religion,category,occupation,education,income;
    String formno;

    Signup2( String formno) {
        this.formno=formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2");


        JLabel additionalDetail = new JLabel("PAGE 2: Additional DETAIL. ");
        additionalDetail.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetail.setBounds(290, 80, 400, 30);
        add(additionalDetail);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);


        String[] valReligion ={"Hindu","Muslim","Sikh","Christian","other"};
        religion =new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 400, 30);
        add(fname);

        String[] valcategory ={"General","OBC","SC","ST"};
        category =new JComboBox<>(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);



        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String[] valincome ={"Null","<1,50,000","<2,50,000","<5,00,000"};
        income =new JComboBox<>(valincome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender = new JLabel("Educational:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);


        JLabel email = new JLabel("Qulification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 315, 200, 30);
        add(email);

        String[] educationValue ={"Non-Graduation","Graduation","Post-Graduation","Other"};
        education =new JComboBox<>(educationValue);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        String[] occupationValue ={"Salaried","Self-Employed","Bussiness","Retired","Other"};
        occupation =new JComboBox<>(occupationValue);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);



        JLabel marital = new JLabel("Occupational:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);




        JLabel address = new JLabel("Pan Number:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel adhar = new JLabel("Aadhar Number:");
        adhar.setFont(new Font("Raleway", Font.BOLD, 20));
        adhar.setBounds(100, 490, 200, 30);
        add(adhar);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);


        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        syes = new JRadioButton("YES");
        syes.setBounds(300, 540, 100, 30);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(450, 540, 100, 30);
        add(sno);

        ButtonGroup old=new ButtonGroup();
        old.add(syes);
        old.add(sno);



        JLabel pin = new JLabel("Existing Account:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 590, 200, 30);
        add(pin);

        eyes = new JRadioButton("YES");
        eyes.setBounds(300, 590, 100, 30);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(450, 590, 100, 30);
        add(eno);

        ButtonGroup old1=new ButtonGroup();
        old1.add(eyes);
        old1.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);


        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion =(String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen= null;
        if (syes.isSelected()) {
            seniorcitizen = "YES";
        } else if (sno.isSelected()) {
            seniorcitizen = "NO";
        }
        String exisitingaccount = null;
        if (eyes.isSelected()) {
            exisitingaccount = "YES";
        } else if (eno.isSelected()) {
            exisitingaccount = "NO";
        }
        String span = pan.getText();
        String saadher = aadhar.getText();

        try {
                Conn con1=new Conn();
                String query="insert into signup2 value('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadher+"','"+seniorcitizen+"','"+exisitingaccount+"')";
                con1.statement.executeUpdate(query);

            setVisible(false);
                new Signup3(formno).setVisible(true);

        }catch (Exception E){
            E.printStackTrace();
        }

    }


    public static void main(String[] args) {
        new Signup2("");


    }
}

