import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinChange extends JFrame implements ActionListener {

    JLabel label, text, pintext, repin;
    JTextField  newPin;
    JPasswordField reEnter;
    JButton change, back;
    String pin;

    pinChange(String pin){

        this.pin = pin;

        setLayout(null);
        ImageIcon icon = new ImageIcon("atm.jpg");
        label = new JLabel();
        Image icon2 = icon.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        label.setIcon(icon3);
        label.setBounds(0,0,900,900);

        text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,290,800,35);
        text.setForeground(Color.white);
        text.setFont(new Font("system", Font.BOLD, 16));
        add(text);

        pintext = new JLabel("New PIN");
        pintext.setBounds(160,350,300,35);
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("system", Font.BOLD, 16));
        add(pintext);

        newPin = new JTextField();
        newPin.setBounds(330,350, 150,25);
        newPin.setFont(new Font("system", Font.BOLD,14));
        add(newPin);

        repin = new JLabel("Re-Enter New PIN");
        repin.setBounds(160,400,300,35);
        repin.setForeground(Color.white);
        repin.setFont(new Font("system", Font.BOLD, 16));
        add(repin);

        reEnter = new JPasswordField();
        reEnter.setBounds(330,400, 150,25);
        reEnter.setFont(new Font("system", Font.BOLD,14));
        add(reEnter);

        change = new JButton("Change");
        change.setBounds(390,485,120,30);
        change.setFont(new Font("Arial", Font.BOLD,18));
        change.addActionListener(this);
        add(change);

        back = new JButton("Back");
        back.setBounds(390,520,120,28);
        back.setFont(new Font("Arial", Font.BOLD,18));
        back.addActionListener(this);
        add(back);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("PIN Change");
        this.setSize(900, 900);
        this.setLocation(350, 0);
        this.getContentPane().setBackground(Color.white);
        this.add(label);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String npin = newPin.getText();
            String rpin = reEnter.getText();

            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
                return;
            }
            if(e.getSource() == change){
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");

                }
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin= '"+ pin +"'";
                String query2 = "update login set pin = '"+rpin+"' where pin= '"+ pin +"'";
                String query3 = "update signup3 set pin = '"+rpin+"' where pin = '"+ pin +"' ";

                conn.statement.executeUpdate(query1);
                conn.statement.executeUpdate(query2);
                conn.statement.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,  "PIN changed successfully");

            }
            setVisible(false);
            new Transactions(rpin).setVisible(true);
        }catch (Exception ex){
            System.out.println(ex);
        }

    }

    public static void main(String[] args) {

        new pinChange("").setVisible(true);

    }
}
