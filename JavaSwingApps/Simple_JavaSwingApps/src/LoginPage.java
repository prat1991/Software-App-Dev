import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener
{
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JLabel loginMessage;

	public static void main(String[] args)
	{
		frame = new JFrame();  //creating a new frame object with no title
		panel = new JPanel(); //creating a jpanel object
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //setting action taken when user closes the frame
		frame.add(panel); //adding panel onto the frame

		panel.setLayout(null); //setting the layout of the panel

		userLabel = new JLabel("User");  //creating the label object with initial text
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel); //adding label onto the panel

		userText = new JTextField(20); // text field that is 20 chars long
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText); //adding text field onto the panel

		passwordLabel = new JLabel("Password");  //creating the label object with initial text
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel); //adding label onto the panel

		passwordText = new JPasswordField(20); // text field that is 20 chars long
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText); //adding label onto the panel

		button = new JButton("Login"); //creating the button object with specified text
		button.setBounds(10, 80, 80, 25);
		panel.add(button);  //adding button onto the panel

		loginMessage = new JLabel("");   //creating the label object with initial text
		loginMessage.setBounds(10, 110, 300, 25);
		panel.add(loginMessage);  //adding label onto the panel

		button.addActionListener(new LoginPage()); //calls actionPerformed() upon button click

		frame.setVisible(true); //shows the frame (false hides the frame)
	}

	//function that performs an action after listening to the login button being clicked
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String user = userText.getText();
		String password = passwordText.getText();
		System.out.println(user + ", " + password);
		
		//checking to see if the user entered the corrected username and password
		if(user.equals("Prat") && password.equals("Prat"))
		{
			loginMessage.setText("logged in successfully"); //sets the text displayed after the button click
		}
	}
}
