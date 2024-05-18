import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JLabel label, text;
    JButton  back;
    String pin;

    BalanceEnquiry(String pin) {

        this.pin = pin;

        setLayout(null);
        ImageIcon icon = new ImageIcon("atm.jpg");
        label = new JLabel();
        Image icon2 = icon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        label.setIcon(icon3);
        label.setBounds(0, 0, 900, 900);

        text = new JLabel();
        text.setBounds(180, 350, 400, 100);
        text.setForeground(Color.white);
        text.setFont(new Font("system", Font.BOLD, 20));
        add(text);

        back = new JButton("Back");
        back.setBounds(350, 520, 150, 28);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.addActionListener(this);
        add(back);

        int balance = 0;
        Conn conn = new Conn();
        try {
            ResultSet set = conn.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while (set.next()){
                if(set.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(set.getString("money"));
                }
                else {
                    balance -= Integer.parseInt(set.getString("money"));
                }
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }

        text.setText("<html> Your Current Account Balance is <br/> <br/> " +
                " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                " Rs " + balance +"<html>");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ATM");
        this.setSize(900, 900);
        this.setLocation(350, 0);
        this.getContentPane().setBackground(Color.white);
        this.add(label);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        new Transactions(pin).setVisible(true);

    }

    public static void main(String[] args) {

        new BalanceEnquiry("");

    }


}