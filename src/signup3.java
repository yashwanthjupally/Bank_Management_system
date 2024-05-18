import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

public class signup3 extends JFrame implements ActionListener{

    JLabel personalDetails, account, card, aadNo, cardNo,ll1,ll2,ll3,services ,l1, l2;
    JRadioButton r1,r2,r3,r4;
    JButton submit, cancel;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;

    signup3(String formno){

        this.formno = formno;

        l1 = new JLabel("Form No:");
        l1.setFont(new Font("Cambria", Font.BOLD, 22));
        l1.setBounds(500,10,100,30);
        this.add(l1);
        l2 = new JLabel(formno);
        l2.setFont(new Font("Cambria", Font.BOLD, 22));
        l2.setBounds(610,10,100,30);
        this.add(l2);

        personalDetails = new JLabel("Page 3: Account Details");
        personalDetails.setFont(new Font("Cambria", Font.BOLD, 25));
        personalDetails.setBounds(260, 80, 300, 30);
        this.add(personalDetails);

        account = new JLabel("Account Type:");
        account.setFont(new Font("Cambria", Font.BOLD, 22));
        account.setBounds(120, 150, 200, 30);
        this.add(account);


        r1 = new JRadioButton("Saving Account");
        r1.setBounds(120, 190, 200, 30);
        r1.setFont(new Font("Arial", Font.PLAIN, 18));
        r1.setBackground(Color.white);
        this.add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBounds(400, 190, 300, 30);
        r2.setFont(new Font("Arial", Font.PLAIN, 18));
        r2.setBackground(Color.white);
        this.add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setBounds(120, 230, 200, 30);
        r3.setFont(new Font("Arial", Font.PLAIN, 18));
        r3.setBackground(Color.white);
        this.add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(400, 230, 300, 30);
        r4.setFont(new Font("Arial", Font.PLAIN, 18));
        r4.setBackground(Color.white);
        this.add(r4);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        groupgender.add(r3);
        groupgender.add(r4);

        card = new JLabel("Card Number:");
        card.setFont(new Font("Cambria", Font.BOLD, 22));
        card.setBounds(120, 280, 200, 30);
        this.add(card);

        aadNo = new JLabel("XXXX-XXXX-XXXX-4184");
        aadNo.setFont(new Font("Cambria", Font.BOLD, 20));
        aadNo.setBounds(400, 280, 300, 30);
        this.add(aadNo);

        cardNo = new JLabel("Your 16-digit Card number");
        cardNo.setFont(new Font("Cambria", Font.BOLD, 14));
        cardNo.setBounds(120, 310, 200, 30);
        this.add(cardNo);


        ll1 = new JLabel("PIN:");
        ll1.setFont(new Font("Cambria", Font.BOLD, 22));
        ll1.setBounds(120, 360, 200, 30);
        this.add(ll1);

        ll2 = new JLabel("Your 4 Digit Password");
        ll2.setFont(new Font("Cambria", Font.BOLD, 14));
        ll2.setBounds(120, 390, 200, 30);
        this.add(ll2);

        ll3 = new JLabel("XXXX");
        ll3.setFont(new Font("Cambria", Font.BOLD, 20));
        ll3.setBounds(400, 360, 200, 30);
        this.add(ll3);

        services = new JLabel("Services Required:");
        services.setFont(new Font("Cambria", Font.BOLD, 22));
        services.setBounds(120, 440, 200, 30);
        this.add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Arial", Font.PLAIN, 18));
        c1.setBounds(120,480,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Arial", Font.PLAIN, 18));
        c2.setBounds(400,480,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Arial", Font.PLAIN, 18));
        c3.setBounds(120,520,200,30);
        add(c3);

        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Arial", Font.PLAIN, 18));
        c4.setBounds(400,520,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Arial", Font.PLAIN, 18));
        c5.setBounds(120,560,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Arial", Font.PLAIN, 18));
        c6.setBounds(400,560,200,30);
        add(c6);

        c7 = new JCheckBox("I hereby declares that the above " +
                "entered details correct to th best of my knowledge.",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Arial", Font.PLAIN, 16));
        c7.setBounds(120,610,600,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Arial", Font.BOLD,18));
        submit.setBounds(250, 660, 100,30);
        submit.addActionListener(this);
        this.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Arial", Font.BOLD,18));
        cancel.setBounds(450, 660, 100,30);
        cancel.addActionListener(this);
        this.add(cancel);

        setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("NEW ACCOUNT APPLICATION FORM");
        this.setSize(850, 800);
        this.setLocation(350, 10);
        this.getContentPane().setBackground(Color.white);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String atype = null;
        if(r1.isSelected()){
            atype = "Saving Account";
        }
        else if(r2.isSelected()){
            atype = "Fixed Deposit Account";
        }
        else if(r3.isSelected()){
            atype = "Current Account";
        }
        else if(r4.isSelected()){
            atype = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        String facility = "";
        if(c1.isSelected()){
            facility = facility + " ATM Card";
        }
        if(c2.isSelected()){
            facility = facility + " Internet Banking";
        }
        if(c3.isSelected()){
            facility = facility + " Mobile Banking";
        }
        if(c4.isSelected()){
            facility = facility + " EMAIL Alerts";
        }
        if(c5.isSelected()){
            facility = facility + " Cheque Book";
        }
        if(c6.isSelected()){
            facility = facility + " E-Statement";
        }

        try{
            if(e.getSource() == submit){
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else {
                    Conn c1 = new Conn();
                    String q1 = "insert into signup3 values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+facility+"')";
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);

                    System.out.println("Data added Successfully");
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);

                    // Start Transactions with the generated pin
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }
            else if(e.getSource()== cancel){
                System.exit(0);
            }

        }
        catch(Exception ex){
            System.out.println(ex);
        }

    }


    public static void main(String[] args) {

        new signup3("").setVisible(true);

    }


}
