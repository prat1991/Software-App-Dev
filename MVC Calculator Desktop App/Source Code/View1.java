
//import statement
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//create class and extend with JFrame
public class View1 extends JFrame implements ActionListener
{
	// Instance Variables
	private JLabel usernamePrompt = new JLabel("Username:"); // no user input required
	private JLabel passwordPrompt = new JLabel("Password:"); // no user input required
	private JTextField usernameInput = new JTextField(); // users types in the password information
	private JPasswordField passwordInput = new JPasswordField(); // users types in the password information
	private JButton loginButton = new JButton("Login"); // user clicks the login button
	private JButton resetButton = new JButton("Reset"); // user clicks the reset button
	// declare variable
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	// empty constructor
	public View1()
	{
		createAnEmptyGUI();
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
	}

	// Instance Method
	public void createAnEmptyGUI()
	{
		setTitle("Login Page"); // Method Usage is allowed due to inheritance from JFrame Class
		setVisible(true); // Method Usage is allowed due to inheritance from JFrame Class
		setBounds(10, 10, 370, 600); // Method Usage is allowed due to inheritance from JFrame Class
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Method Usage is allowed due to inheritance from JFrame Class
		setResizable(false); // Method Usage is allowed due to inheritance from JFrame Class
	}

	// Instance Method
	public void setLayoutManager()
	{

		setLayout(null); // Method Usage is allowed due to inheritance from JFrame Class
	}

	// Instance Method
	public void setLocationAndSize()
	{
		usernamePrompt.setBounds(50, 150, 100, 30);
		passwordPrompt.setBounds(50, 220, 100, 30);
		usernameInput.setBounds(150, 150, 150, 30);
		passwordInput.setBounds(150, 220, 150, 30);
		loginButton.setBounds(50, 300, 100, 30);
		resetButton.setBounds(200, 300, 100, 30);
	}

	// Instance Method
	public void addComponentsToContainer()
	{
		add(usernamePrompt); // Method Usage is allowed due to inheritance from JFrame Class
		add(passwordPrompt); // Method Usage is allowed due to inheritance from JFrame Class
		add(usernameInput); // Method Usage is allowed due to inheritance from JFrame Class
		add(passwordInput); // Method Usage is allowed due to inheritance from JFrame Class
		add(loginButton); // Method Usage is allowed due to inheritance from JFrame Class
		add(resetButton); // Method Usage is allowed due to inheritance from JFrame Class
	}

	// Instance Method
	public void addActionEvent()
	{
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
	}


	// Fully defining actionPerformed Method's code due to implementing the Action
	// Listener Interface
	View1 View1Object;
	@Override
	public void actionPerformed(ActionEvent mouseClick)
	{
		// LOGIN BUTTON CODE
		// When the user enters invalid info and presses the login button; display a
		// popup window that says that the login was unsuccessfull
		// when the user enters valid info and presses the login button; display a popup
		// window that says that the login was successfull, ..
		// .. then kill hide the login window, kill the login window, create the
		// calculator window, create the model and create the controller...
		// so that when the user enters the two numbers in the second window the
		// controller can update the output field after calculate add button was clicked

		if (mouseClick.getSource() == loginButton)
		{
			String storedUsername, storedPassword, databaseStoredUsername, databaseStoredPassword;

			storedUsername = usernameInput.getText();
			storedPassword = passwordInput.getText();

			databaseStoredUsername = "pratiksh";
			databaseStoredPassword = "prat1234";

			if (storedUsername.equalsIgnoreCase(databaseStoredUsername)
					&& storedPassword.equalsIgnoreCase(databaseStoredPassword))
			{
				JOptionPane.showMessageDialog(this, "Login successful");
				setVisible(false);
				dispose();
				View2 View2Object = new View2();
				Model ModelObject = new Model();
				Controller controllerObject = new Controller(View2Object, ModelObject);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Login Unsuccessful; Invalid Username or Password");
			}

		}

		// RESET BUTTON CODE
		// when the user enter invalid or valid information and presses the reset button
		// instead of the login button
		// both the populated fields for username and password get updated to reset to
		// being empty fields again.

		if (mouseClick.getSource() == resetButton)
		{
			usernameInput.setText("");
			passwordInput.setText("");
		}
	}
}
