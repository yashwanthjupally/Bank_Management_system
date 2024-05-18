import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class miniStatement extends JFrame implements ActionListener {

    JLabel bank, card, mini, bal;
    JButton exit;

    miniStatement(String pinnumber){

        setLayout(null);

        bank = new JLabel("State Bank Of India");
        bank.setBounds(100,20,500,20);
        bank.setFont(new Font("system", Font.BOLD,20));
        this.add(bank);

        card = new JLabel();
        card.setBounds(20,100,400, 30);
        card.setFont(new Font("system", Font.BOLD,18));
        this.add(card);

        mini = new JLabel();
        mini.setBounds(20, 130, 400,300);
        mini.setFont(new Font("system", Font.BOLD,14));
        this.add(mini);

        bal = new JLabel();
        bal.setBounds(70,440,400, 20);
        bal.setFont(new Font("system", Font.BOLD,18));
        this.add(bal);

        exit = new JButton("Exit");
        exit.setBounds(130,480,100, 35);
        exit.setFont(new Font("system", Font.BOLD,16));
        exit.addActionListener(this);
        this.add(exit);

        try {

            Conn conn = new Conn();
            ResultSet rs = conn.statement.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while (rs.next()){
                card.setText("Card Number:  " + rs.getString("cardno").substring(0,4)+
                        "xxxxxxxx" + rs.getString("cardno").substring(12));
            }
        }
        catch (SQLException ex) {

            System.out.println(ex);
        }

        try {
            int balance = 0;
            Conn conn = new Conn();
            ResultSet rs = conn.statement.executeQuery("select * from bank where pin = '"+pinnumber+"' LIMIT 5");
            while (rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs.getString("money") + "<br><br><html>");

                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("money"));
                }
                else {
                    balance -= Integer.parseInt(rs.getString("money"));
                }
            }
            bal.setText("Your total Balance is Rs "+ balance);
            setVisible(false);
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this. setTitle("Mini Statement");;
        this.setSize(400, 600);
        this.setLocation(350, 0);
        this.getContentPane().setBackground(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        System.exit(0);
    }

    public static void main(String[] args) {

        new miniStatement("").setVisible(true);

    }


}
