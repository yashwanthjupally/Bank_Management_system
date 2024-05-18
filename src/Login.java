import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login extends JFrame implements ActionListener {

    JLabel text, cardno, pin;
    JButton login, clear, signup;
    JTextField ip_card;
    JPasswordField ip_pin;

    Login(){

        ImageIcon icon = new ImageIcon("bank.png");
        JLabel label = new JLabel();
        Image icon2 = icon.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        label.setIcon(icon3);
        label.setBounds(70,20,100,100);
        this.add(label);

        text = new JLabel("Welcome to ATM");
        text.setBounds(250,50,500,70);
        text.setFont(new Font("Cambria",Font.BOLD,35));
        this.add(text);

        cardno = new JLabel("Card No: ");
        cardno.setBounds(120,150,150,50);
        cardno.setFont(new Font("system",Font.BOLD,22));
        this.add(cardno);

        pin = new JLabel("PIN: ");
        pin.setBounds(120,200,150,50);
        pin.setFont(new Font("system",Font.BOLD,22));
        this.add(pin);

        this.ip_card = new JTextField(15);
        this.ip_card.setBounds(270,165, 250,25);
        this.ip_card.setFont(new Font("Arial", Font.BOLD,14));
        this.add(ip_card);

        this.ip_pin = new JPasswordField(15);
        this.ip_pin.setBounds(270,215, 250,25);
        this.ip_pin.setFont(new Font("Arial", Font.BOLD,14));
        this.add(ip_pin);

        login = new JButton("SIGN IN");
        login.setBounds(270,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        this.add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(400,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        this.add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,150,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        this.add(signup);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Login");
        this.setSize(800,480);
        this.setLocation(350,175);
        this.getContentPane().setBackground(Color.white);
        setLayout(null);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource() == login) {
                Conn conn = new Conn();
                String cardnumber = ip_card.getText();
                String pinnumber = ip_pin.getText();

                String query = "select * from login where cardno = '" + cardnumber + "' and pin = '" + pinnumber + "'";
                ResultSet set = conn.statement.executeQuery(query);

                if (set.next()) {
                    setVisible(false);
                    new Transactions("").setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }
            else if(e.getSource() == clear) {
                ip_card.setText("");
                ip_pin.setText("");
            }
            else if(e.getSource() == signup) {
                setVisible(false);
                new signup().setVisible(true);

            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }

}
