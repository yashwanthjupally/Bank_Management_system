import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JLabel label, text;
    JButton deposit, withdraw, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pin;

    Transactions(String pin){

        this.pin = pin;

        setLayout(null);
        ImageIcon icon = new ImageIcon("atm.jpg");
        label = new JLabel();
        Image icon2 = icon.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        label.setIcon(icon3);
        label.setBounds(0,0,900,900);

        text = new JLabel("Please select your Transaction");
        text.setBounds(215,290,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("system", Font.BOLD, 16));
        add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(160,415,150,30);
        deposit.setFont(new Font("Arial", Font.BOLD,18));
        deposit.addActionListener(this);
        add(deposit);

        withdraw = new JButton("Cash Withdraw");
        withdraw.setBounds(330,415,180,30);
        withdraw.setFont(new Font("Arial", Font.BOLD,18));
        withdraw.addActionListener(this);
        add(withdraw);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(160,450,150,30);
        fastCash.setFont(new Font("Arial", Font.BOLD,18));
        fastCash.addActionListener(this);
        add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(330,450,180,30);
        miniStatement.setFont(new Font("Arial", Font.BOLD,18));
        miniStatement.addActionListener(this);
        add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(160,485,150,30);
        pinChange.setFont(new Font("Arial", Font.BOLD,18));
        pinChange.addActionListener(this);
        add(pinChange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(330,485,180,30);
        balanceEnquiry.setFont(new Font("Arial", Font.BOLD,18));
        balanceEnquiry.addActionListener(this);
        add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(410,520,100,28);
        exit.setFont(new Font("Arial", Font.BOLD,18));
        exit.addActionListener(this);
        add(exit);


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

        if(e.getSource() == exit){
            System.exit(0);
        }
        else if (e.getSource() == deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);  // Pass the pin to Deposit
        }
        else if (e.getSource() == withdraw){
            setVisible(false);
            new Withdraw(pin).setVisible(true);  // Pass the pin to Withdraw
        }
        else if (e.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pin).setVisible(true);  // Pass the pin to FastCash
        }
        else if (e.getSource() == pinChange) {
            setVisible(false);
            new pinChange(pin).setVisible(true);  // Pass the pin to pinChange
        }
        else if (e.getSource() == miniStatement) {
            new miniStatement(pin).setVisible(true);  // Pass the pin to miniStatement
        }
        else if (e.getSource() == balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);  // Pass the pin to BalanceEnquiry
        }

    }

    public static void main(String[] args) {

        new Transactions("");

    }
    
}
