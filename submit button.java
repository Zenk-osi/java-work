public class TwoIntegers {
	public static void main(String[] args) {
		int first=22;
		int second=3;

		int sum=first+second;
		System.Out.println("The sum is:"+sum);
	import javax.swing.*;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.*;


public class Main extends JFrame implements ActionListener {
    public static void main (String []args){
        new Main("Meniu"); // Create title

    }
// Main class constructor
    public Main(String title) {
        super(title); 
        setMenu(); //create menu
        setSize(300, 400);// size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close running program if window are closed
        setLocationRelativeTo(null); // set window position at center
        setResizable(false); //resizable or not
        show();
    }// Main class constructor

// menu choices
    JMenuItem Registration, Apie, Exit;

// menu method for creation and style   
    private void setMenu() {
        JMenuBar barObj = new JMenuBar(); // create menuBar obj
        JMenu messagesObj = new JMenu("Meniu"); //create menu bar menu object

        barObj.setBackground(Color.YELLOW); // set menu bar bg color

        Registration = new JMenuItem("Registration"); 
        Registration.setToolTipText("Push to register"); // write text when u hang mouse over
        Registration.addActionListener(this);   
        Registration.setBackground(Color.WHITE); // set menu bar menu options bg color
        messagesObj.add(Registration); // add Registration into messages

        Apie = new JMenuItem("Apie");
        Apie.setToolTipText("Push for information");
        Apie.addActionListener(this);
        Apie.setBackground(Color.WHITE);
        messagesObj.add(Apie);  

        Exit = new JMenuItem("Exit");
        Exit.setToolTipText("Here you will exit");
        Exit.addActionListener(this);
        Exit.setBackground(Color.WHITE);
        messagesObj.add(Exit);



        barObj.add(messagesObj);
        setJMenuBar(barObj);
    } //create menu end


// implemented method
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Registration){
            int registReply = JOptionPane.showConfirmDialog(this, "Norite registruotis?", 
                "Išeiti", JOptionPane.YES_NO_OPTION);
            if(registReply == JOptionPane.YES_OPTION){ //registReply is what u have choosen
                petRegistration ();
            }
        }else if (e.getSource() == Apie)
            JOptionPane.showMessageDialog(this, "Jus esate informacijos lange.", "Apie", JOptionPane.PLAIN_MESSAGE);                    
        else if (e.getSource() == Exit){
            int exitReply = JOptionPane.showConfirmDialog(this, "Ar norite Exit?", 
                    "Išeiti", JOptionPane.YES_NO_OPTION);// exitReply is what u have choosen
                if(exitReply == JOptionPane.YES_OPTION){// if its has been chose/ program will shutdown
                    System.exit(0);
                }           
        } // if end
    }// actionPerformed

    public void petRegistration(){

        Container container = getContentPane();
// petName textbox and label        
        JTextField jtfRegLabel = new JTextField("***Registration***", 25);
        jtfRegLabel.setHorizontalAlignment(JTextField.CENTER);
        jtfRegLabel.setEditable(false);


        JTextField jtfText1 = new JTextField(7);
        JTextField jtfNameLabel = new JTextField("Pet Name (min 3, max 16 letters)", 17);
        jtfNameLabel.setEditable(false);
        jtfText1.setDocument(new JTextFieldLimit(16)); // add limit to text box

// pettype combobox and label
        Frame frame = new Frame("Choice");
        Label label = new Label("What is your Choice:");
        Choice choice = new Choice();

        frame.add(choice);
        choice.add("Cat        ");
        choice.add("Dog        ");
        choice.add("Fish       ");
        choice.add("Mouse      ");
        choice.add("Bird       ");
        choice.add("Horse      ");

        JTextField jtfTypeLabel = new JTextField("Pet Type, Choose one ", 17);
        jtfTypeLabel.setEditable(false);

// petGender combobox and label

        Choice choice1 = new Choice();
        frame.add(choice1);
        choice1.add("Male       ");
        choice1.add("Female     ");

        JTextField jtfGenderLabel = new JTextField("Pet Gender, Choose one ", 17);
        jtfGenderLabel.setEditable(false);

// submit registration  
        JButton submitRegObj = new JButton("Submit");



        container.add(jtfRegLabel);
        container.add(jtfText1);
        container.add(jtfNameLabel);
        container.add(choice);
        container.add(jtfTypeLabel);
        container.add(choice1);
        container.add(jtfGenderLabel);
        container.add(submitRegObj);    

        container.setLayout(new FlowLayout());
        setSize(300, 400); // set size of window
        setVisible(true);// set it visible


    }
}
} 