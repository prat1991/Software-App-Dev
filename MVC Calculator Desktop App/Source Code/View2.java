
//import statement
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View2 extends JFrame
{
	// Instance Variables (defines all the view (GUI) components)
	private JLabel firstNumberLabel = new JLabel("First Number: ");
	private JTextField firstNumberInput = new JTextField(10);
	private JLabel secondNumberLabel = new JLabel("Second Number: ");
	private JTextField secondNumberInput = new JTextField(10);
	private JButton calculateButton = new JButton("Calculate Add");
	private JTextField answer = new JTextField(10);

	// Constructor (Sets up the view (GUI); (called when object is created))
	View2()
	{
		// sets the title of view(GUI)
		this.setTitle("Addition Calculator");
		// setup the location & size of the view(GUI)
		this.setBounds(10, 10, 300, 300);
		// locks up the location & size of the view(GUI) so that the frame cannot be
		// resized
		this.setResizable(false);
		// allow the view(GUI) to be visible
		this.setVisible(true);
		// allow the view(GUI) to be closed when the user clicks the X button
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set up the location and size of the components
		firstNumberLabel.setBounds(50, 150, 100, 30);
		secondNumberLabel.setBounds(50, 150, 100, 30);
		firstNumberInput.setBounds(50, 150, 100, 30);
		secondNumberInput.setBounds(50, 150, 100, 30);
		calculateButton.setBounds(50, 150, 100, 30);
		// create the panel object
		JPanel PanelObject = new JPanel();
		// add components into the panel
		PanelObject.add(firstNumberLabel);
		PanelObject.add(firstNumberInput);
		PanelObject.add(secondNumberLabel);
		PanelObject.add(secondNumberInput);
		PanelObject.add(calculateButton);
		PanelObject.add(answer);
		// add the panel object onto the view(GUI)
		this.add(PanelObject);
	}

	public int getFirstNumberGuiInput()
	{
		return Integer.parseInt(firstNumberInput.getText()); // converts GUI user input into integer value
	}

	public int getSecondNumberGuiInput()
	{
		return Integer.parseInt(secondNumberInput.getText()); // converts GUI user input into integer value
	}

	public void setAnswerGuiOutput(int solution)
	{
		answer.setText(Integer.toString(solution)); // takes integer value and converts it back into string value to
		// display the result into the GUI textfield
	}

	// If the user click on the calculate button after entering first number and
	// second number
	// in the Controller named actionPerformed
	void addCalculateListener(ActionListener listenerForCalculateButton)
	{
		calculateButton.addActionListener(listenerForCalculateButton);
	}

	// If the user click on the calculate button before entering first number and
	// second number
	void displayErrorMessage(String errorMessage)
	{
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
