import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class AddDetails extends JFrame implements ActionListener {

    JLabel personalDetails,religion, income, education,
            occupation, pan, aadhar, senior, existing, l1, l2;
    JComboBox religionTF, incomeTF, educationTF, occupationTF;
    JTextField panTF, aadharTF;
    JRadioButton yes, no, yes1, no1;
    ButtonGroup buttonGroup, buttonGroup1;
    JButton next;
    String formno;

    AddDetails(String form) {



        this.formno = form;

        personalDetails = new JLabel("Page 2: Additional Details");
        personalDetails.setFont(new Font("Cambria", Font.BOLD, 25));
        personalDetails.setBounds(260, 80, 300, 40);
        this.add(personalDetails);

        religion = new JLabel("Religion");
        religion.setFont(new Font("Cambria", Font.BOLD, 22));
        religion.setBounds(120, 150, 200, 40);
        this.add(religion);

        income = new JLabel("Income");
        income.setFont(new Font("Cambria", Font.BOLD, 22));
        income.setBounds(120, 200, 200, 40);
        this.add(income);

        education = new JLabel("Education Qualifications");
        education.setFont(new Font("Cambria", Font.BOLD, 22));
        education.setBounds(120, 250, 200, 40);
        this.add(education);

        occupation = new JLabel("Occupation");
        occupation.setFont(new Font("Cambria", Font.BOLD, 22));
        occupation.setBounds(120, 300, 200, 40);
        this.add(occupation);

        pan= new JLabel("PAN Number");
        pan.setFont(new Font("Cambria", Font.BOLD, 22));
        pan.setBounds(120, 350, 200, 40);
        this.add(pan);

        aadhar = new JLabel("Aadhar Number");
        aadhar.setFont(new Font("Cambria", Font.BOLD, 22));
        aadhar.setBounds(120, 400, 200, 40);
        this.add(aadhar);

        senior = new JLabel("Senior Citizen");
        senior.setFont(new Font("Cambria", Font.BOLD, 22));
        senior.setBounds(120, 450, 200, 40);
        this.add(senior);

        existing = new JLabel("Existing Account");
        existing.setFont(new Font("Cambria", Font.BOLD, 22));
        existing.setBounds(120, 500, 200, 40);
        this.add(existing);


        l1 = new JLabel("Form No:");
        l1.setFont(new Font("Cambria", Font.BOLD, 22));
        l1.setBounds(500,10,100,30);
        this.add(l1);
        l2 = new JLabel(form);
        l2.setFont(new Font("Cambria", Font.BOLD, 22));
        l2.setBounds(610,10,100,30);
        this.add(l2);


        String[] rel = {"Hindu", "Muslim", "Christian", "Other"};
        religionTF = new JComboBox<>(rel);
        religionTF.setBounds(380, 150, 300,30);
        religionTF.setFont(new Font("Arial", Font.PLAIN, 18));
        religionTF.setBackground(Color.white);
        this.add(religionTF);

        String[] inc = {"NULL", "<150000", "<250000", "<500000", "Above 500000"};
        incomeTF = new JComboBox<>(inc);
        incomeTF.setBounds(380, 200, 300,30);
        incomeTF.setFont(new Font("Arial", Font.PLAIN, 18));
        incomeTF.setBackground(Color.white);
        this.add(incomeTF);

        String[] edu = {"Non-Graduate", "Graduate","Post-Graduate", "Others"};
        educationTF = new JComboBox<>(edu);
        educationTF.setBounds(380, 250, 300,30);
        educationTF.setFont(new Font("Arial", Font.PLAIN, 18));
        educationTF.setBackground(Color.white);
        this.add(educationTF);

        String[] occ = {"Student", "Self-Employed", "Business", "Others"};
        occupationTF = new JComboBox<>(occ);
        occupationTF.setBounds(380, 300, 300,30);
        occupationTF.setFont(new Font("Arial", Font.PLAIN, 18));
        occupationTF.setBackground(Color.white);
        this.add(occupationTF);

        panTF = new JTextField();
        panTF.setFont(new Font("Arial", Font.BOLD, 14));
        panTF.setBounds(380, 350, 300, 30);
        this.add(panTF);

        aadharTF = new JTextField();
        aadharTF.setFont(new Font("Arial", Font.BOLD, 14));
        aadharTF.setBounds(380, 400, 300, 30);
        this.add(aadharTF);

        yes = new JRadioButton("Yes");
        no = new JRadioButton("No");
        yes.setBounds(380, 450, 100, 30);
        no.setBounds(480, 450, 100, 30);
        yes.setFont(new Font("Arial", Font.PLAIN, 18));
        no.setFont(new Font("Arial", Font.PLAIN, 18));
        yes.setBackground(Color.white);
        no.setBackground(Color.white);
        this.add(yes);
        this.add(no);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(yes);
        buttonGroup.add(no);

        yes1 = new JRadioButton("Yes");
        no1 = new JRadioButton("No");
        yes1.setBounds(380, 500, 100, 30);
        no1.setBounds(480, 500, 100, 30);
        yes1.setFont(new Font("Arial", Font.PLAIN, 18));
        no1.setFont(new Font("Arial", Font.PLAIN, 18));
        yes1.setBackground(Color.white);
        no1.setBackground(Color.white);
        this.add(yes1);
        this.add(no1);
        buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(yes1);
        buttonGroup1.add(no1);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Arial", Font.BOLD,14));
        next.setBounds(550, 600, 100,30);
        next.addActionListener(this);
        this.add(next);


        setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Additional Details");
        this.setSize(850, 800);
        this.setLocation(350, 10);
        this.getContentPane().setBackground(Color.white);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String religion = (String) religionTF.getSelectedItem();
        String income = (String) incomeTF.getSelectedItem();
        String education = (String) educationTF.getSelectedItem();
        String occupation = (String) occupationTF.getSelectedItem();

        String pan = panTF.getText();
        String aadhar = aadharTF.getText();

        String sen = "";
        if(yes.isSelected()){
            sen = "Yes";
        }
        else {
            sen = "No";
        }

        String exist = "";
        if(yes1.isSelected()){
            exist = "Yes";
        }
        else {
            exist = "No";
        }

        try {
            if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null, "Aadhar cant be Blank");
            }
            else{
                Conn c1 = new Conn();
                String q1 = "insert into AddDetails values('"+formno+"', '"+religion+"', " +
                        "'"+income+"', " + "'"+education+"',  '"+occupation+"', '"+pan+"', " +
                        "'"+aadhar+"','"+sen+"', '"+exist+"')";

                c1.statement.executeUpdate(q1);
                System.out.println("Data added Successfully");

                if(e.getSource() == next){
                    setVisible(false);
                    new signup3(formno).setVisible(true);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public static void main(String[] args) {

        new AddDetails("").setVisible(true);

    }


}


