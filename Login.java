import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("AUTOMATED TALLER MACHINE");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/4263684.png"));
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,20,200,200);
        add(label);

        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Oswaed",Font .BOLD,40));
        text.setBounds(250,100,500,40);
        add(text);

        JLabel cardno = new JLabel("CARD NO:");
        cardno.setFont(new Font("Oswaed",Font .BOLD,30));
        cardno.setBounds(130,220,500,30);
        add(cardno);

        cardTextField= new JTextField();
        cardTextField.setBounds(310,220,240,35);
        cardTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font .BOLD,30));
        pin.setBounds(130,280,500,40);
        add(pin);

        pinTextField= new JPasswordField();
        pinTextField.setBounds(310,285,240,35);
        add(pinTextField);

        login=new JButton("SIGN IN");
        login.setBounds(310,350,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(450,350,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("SIGN UP");
        signup.setBounds(310,400,240,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(new Color(206, 130, 89));

        setSize(900,550);
        setVisible(true);
        setLocation(300,150);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (ae.getSource()==login){
            Conn conn =new Conn();
            String  cardnumber=cardTextField.getText();
            String pinnumber= pinTextField.getText();
            String query="select * from login where cardnumber = '"+cardnumber+"'and pinnumber= '"+pinnumber+"'";
            try{
                ResultSet rs=conn.statement.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }

            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup().setVisible(true);

        }


    }

    public static void main(String[] args) {

        new Login();
    }
}

