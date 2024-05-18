
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

public class signup extends JFrame implements ActionListener{

    int random;
    JLabel formNo, personalDetails, name, fname, dob,
            gender, mail, martial, address, city, state, pin;
    JTextField nameTF, fnameTF, mailTF, addTF, cityTF, stateTF, pinTF;
    JRadioButton male,female,other, married, unmarried;
    JButton next;
    ButtonGroup buttonGroup, buttonGroup2;
    JDateChooser dateChooser;

    signup(){

        setLayout(null);

        Random rand = new Random();
        random = Math.abs((rand.nextInt() % 9000) + 1000);

        formNo = new JLabel("APPLICATION FORM NO. " +  random);
        formNo.setFont(new Font("Cambria",Font.BOLD,35));
        formNo.setBounds(160,30,600,30);
        this.add(formNo);

        personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Cambria",Font.BOLD,25));
        personalDetails.setBounds(260,80,300,40);
        this.add(personalDetails);

        name  = new JLabel("Name");
        name.setFont(new Font("Cambria",Font.BOLD,22));
        name.setBounds(120,150,200,40);
        this.add(name);

        fname = new JLabel("Fathers Name");
        fname.setFont(new Font("Cambria",Font.BOLD,22));
        fname.setBounds(120,200,200,40);
        this.add(fname);

        dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Cambria",Font.BOLD,22));
        dob.setBounds(120,250,200,40);
        this.add(dob);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Cambria",Font.BOLD,22));
        gender.setBounds(120,300,200,40);
        this.add(gender);

        mail = new JLabel("Email Address");
        mail.setFont(new Font("Cambria",Font.BOLD,22));
        mail.setBounds(120,350,200,40);
        this.add(mail);

        martial = new JLabel("Martial status");
        martial.setFont(new Font("Cambria",Font.BOLD,22));
        martial.setBounds(120,400,200,40);
        this.add(martial);

        address = new JLabel("Address");
        address.setFont(new Font("Cambria",Font.BOLD,22));
        address.setBounds(120,450,200,40);
        this.add(address);

        city = new JLabel("City");
        city.setFont(new Font("Cambria",Font.BOLD,22));
        city.setBounds(120,500,200,40);
        this.add(city);

        state = new JLabel("State");
        state.setFont(new Font("Cambria",Font.BOLD,22));
        state.setBounds(120,550,200,40);
        this.add(state);

        pin = new JLabel("Pin Code");
        pin.setFont(new Font("Cambria",Font.BOLD,22));
        pin.setBounds(120,600,200,40);
        this.add(pin);

        nameTF = new JTextField();
        nameTF.setFont(new Font("Arial", Font.BOLD,14));
        nameTF.setBounds(350, 150, 300,30);
        this.add(nameTF);

        fnameTF = new JTextField();
        fnameTF.setFont(new Font("Arial", Font.BOLD,14));
        fnameTF.setBounds(350, 200, 300,30);
        this.add(fnameTF);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(350, 250, 300,30);
        this.add(dateChooser);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");
        male.setBounds(350, 300, 100,30);
        female.setBounds(450, 300, 100,30);
        other.setBounds(550, 300, 100,30);
        male.setBackground(Color.white);
        female.setBackground(Color.white);
        other.setBackground(Color.white);
        this.add(male);
        this.add(female);
        this.add(other);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);
        buttonGroup.add(other);

        mailTF = new JTextField();
        mailTF.setFont(new Font("Arial", Font.BOLD,14));
        mailTF.setBounds(350, 350, 300,30);
        this.add(mailTF);

        married = new JRadioButton("Married");
        unmarried = new JRadioButton("UnMarried");
        married.setBounds(350, 400, 100,40);
        unmarried.setBounds(450, 400, 100,40);
        married.setBackground(Color.white);
        unmarried.setBackground(Color.white);
        this.add(married);
        this.add(unmarried);
        buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(married);
        buttonGroup2.add(unmarried);

        addTF = new JTextField();
        addTF.setFont(new Font("Arial", Font.BOLD,14));
        addTF.setBounds(350, 450, 300,30);
        this.add(addTF);

        cityTF = new JTextField();
        cityTF.setFont(new Font("Arial", Font.BOLD,14));
        cityTF.setBounds(350, 500, 300,30);
        this.add(cityTF);

        stateTF = new JTextField();
        stateTF.setFont(new Font("Arial", Font.BOLD,14));
        stateTF.setBounds(350, 550, 300,30);
        this.add(stateTF);

        pinTF = new JTextField();
        pinTF.setFont(new Font("Arial", Font.BOLD,14));
        pinTF.setBounds(350, 600, 300,30);
        this.add(pinTF);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Arial", Font.BOLD,14));
        next.setBounds(600, 700, 100,30);
        next.addActionListener(this);
        this.add(next);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Details");
        this.setSize(850, 800);
        this.setLocation(350, 10);
        this.getContentPane().setBackground(Color.white);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = String.valueOf(random);
        String name = nameTF.getText();
        String fname = fnameTF.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "male";
        }
        else if (female.isSelected()) {
            gender = "female";
        }
        else{
            gender = "Other";
        }

        String mail = mailTF.getText();
        String martial = null;
        if(married.isSelected()){
            martial = "Married";
        }
        else {
            martial = "Un-Married";
        }
        String address = addTF.getText();
        String city = cityTF.getText();
        String state = stateTF.getText();
        String pin = pinTF.getText();

        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name cant be Blank");
            }
            else {
                Conn conn = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', " +
                        "'"+fname+"', " + "'"+dob+"',  '"+gender+"', '"+mail+"', " +
                        "'"+martial+"','"+address+"', '"+city+"', '"+state+"', '"+pin+"' )";

                conn.statement.executeUpdate(query);

                System.out.println("Data added Successfully");

                if(e.getSource() == next){
                    setVisible(false);
                    new AddDetails(formno).setVisible(true);
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }


    public static void main(String[] args) {

            new signup();
    }


}
