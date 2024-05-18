import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FastCash extends JFrame implements ActionListener {

    JLabel label, text;
    JButton hund, five_hund, thous, two_thous, five_thous, ten_thous, back;
    String pin;

    FastCash(String pin){

        this.pin = pin;

        setLayout(null);
        ImageIcon icon = new ImageIcon("atm.jpg");
        label = new JLabel();
        Image icon2 = icon.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        label.setIcon(icon3);
        label.setBounds(0,0,900,900);

        text = new JLabel("SELECT WITHDRAW AMOUNT");
        text.setBounds(215,290,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("system", Font.BOLD, 16));
        add(text);

        hund = new JButton("RS 100");
        hund.setBounds(160,415,150,30);
        hund.setFont(new Font("Arial", Font.BOLD,18));
        hund.addActionListener(this);
        add(hund);

        five_hund = new JButton("RS 500");
        five_hund.setBounds(330,415,180,30);
        five_hund.setFont(new Font("Arial", Font.BOLD,18));
        five_hund.addActionListener(this);
        add(five_hund);

        thous = new JButton("RS 1000");
        thous.setBounds(160,450,150,30);
        thous.setFont(new Font("Arial", Font.BOLD,18));
        thous.addActionListener(this);
        add(thous);

        two_thous = new JButton("RS 2000");
        two_thous.setBounds(330,450,180,30);
        two_thous.setFont(new Font("Arial", Font.BOLD,18));
        two_thous.addActionListener(this);
        add(two_thous);

        five_thous = new JButton("RS 5000");
        five_thous.setBounds(160,485,150,30);
        five_thous.setFont(new Font("Arial", Font.BOLD,18));
        five_thous.addActionListener(this);
        add(five_thous);

        ten_thous = new JButton("RS 10000");
        ten_thous.setBounds(330,485,180,30);
        ten_thous.setFont(new Font("Arial", Font.BOLD,18));
        ten_thous.addActionListener(this);
        add(ten_thous);

        back = new JButton("Back");
        back.setBounds(410,520,100,28);
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

        try {
            String amount = ((JButton)e.getSource()).getText().substring(3);
            Conn conn = new Conn();
            ResultSet set = conn.statement.executeQuery("select * from bank where pin = '"+ pin +"'");
            int balance = 0;
            while (set.next()){
                if(set.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(set.getString("money"));
                }
                else {
                    balance -= Integer.parseInt(set.getString("money"));
                }
            }
            String num = "17";
            if(e.getSource() != back && balance < Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
            }
            if(e.getSource() == back){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }

            else {
                Date date = new Date();
                String query = "insert into bank values('"+ pin +"', '"+date+"', 'withdraw','"+amount+"')";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " +amount+ "Debited Successfully");

                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
    }



    public static void main(String[] args) {

        new FastCash("").setVisible(true);
    }
}

