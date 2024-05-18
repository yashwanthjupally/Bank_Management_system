import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {


    JLabel label, text;
    JTextField  amount;
    JButton withdraw, back;
    String pin;

    Withdraw(String pin){

        this.pin = pin;

        setLayout(null);
        ImageIcon icon = new ImageIcon("atm.jpg");
        label = new JLabel();
        Image icon2 = icon.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        label.setIcon(icon3);
        label.setBounds(0,0,900,900);

        text = new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(190,290,800,35);
        text.setForeground(Color.white);
        text.setFont(new Font("system", Font.BOLD, 16));
        add(text);

        amount = new JTextField();
        amount.setBounds(230,350,200,30);
        amount.setFont(new Font("Arial", Font.BOLD,18));
        add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(350,485,150,30);
        withdraw.setFont(new Font("Arial", Font.BOLD,18));
        withdraw.addActionListener(this);
        add(withdraw);

        back = new JButton("Back");
        back.setBounds(350,520,150,28);
        back.setFont(new Font("Arial", Font.BOLD,18));
        back.addActionListener(this);
        add(back);


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

        if(e.getSource() == withdraw){

            String money = amount.getText();
            Date date = new Date();
            if(money.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to withdraw");
            }
            else{
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+ pin +"',  '"+date+"', 'Withdraw', '"+money+"')";
                    conn.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " +money+ " Withdrawl Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
                catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
        else if (e.getSource() == back){

            setVisible(false);
            new Transactions(pin).setVisible(true);
        }


    }

    public static void main(String[] args) {

        new Withdraw("").setVisible(true);

    }


}
