import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {


    JLabel label, text;
    JTextField  amount;
    JButton deposit, back;
    String pin;

    Deposit(String pin) {
        this.pin = pin;

        ImageIcon icon = new ImageIcon("atm.jpg");
        label = new JLabel();
        Image icon2 = icon.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        label.setIcon(icon3);
        label.setBounds(0,0,900,900);

        text = new JLabel("Enter the amount you want to Deposit");
        text.setBounds(190,290,800,35);
        text.setForeground(Color.white);
        text.setFont(new Font("system", Font.BOLD, 16));
        add(text);

        amount = new JTextField();
        amount.setBounds(230,350,200,30);
        amount.setFont(new Font("Arial", Font.BOLD,18));
        add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(350,485,150,30);
        deposit.setFont(new Font("Arial", Font.BOLD,18));
        deposit.addActionListener(this);
        add(deposit);

        back = new JButton("Back");
        back.setBounds(350,520,150,28);
        back.setFont(new Font("Arial", Font.BOLD,18));
        back.addActionListener(this);
        add(back);

        setLayout(null);
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
        try {
            Date date = new Date();
            String money = amount.getText();
            if(e.getSource() == deposit) {
                if (money.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter the amount you want to insert");
                }
                else {

                    Conn conn = new Conn();
                    String query = "insert into bank values('" +pin+ "', '" + date + "', 'Deposit', '" + money + "')";
                    conn.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + money + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }
            else if (e.getSource() == back){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {

        new Deposit("").setVisible(true);

    }


}
