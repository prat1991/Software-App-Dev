import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonClicker implements ActionListener
{
	private int btnCount=0;
	private JFrame frame;
	private JPanel panel;
	private JLabel label;
	private JButton button;
	
	//constructor
	public ButtonClicker()
	{			
		frame = new JFrame(); //creating a new frame object with no title
		frame.add(panel, BorderLayout.CENTER); //adding panel onto the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //setting action taken when user closes the frame
		frame.setTitle("My GUI");
		frame.pack(); //adjusting size of the frame to fit the panel
			
		panel = new JPanel(); //creating a jpanel object
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1)); //setting the layout
		
		button = new JButton("Click me"); //creating the button object with specified text
		button.addActionListener(this); //calls actionPerformed() upon button click
		
		label = new JLabel("Num of clicks:0"); //creating the label object with initial text
		
		panel.add(button); //adding button onto the panel
		panel.add(label); //adding label onto the panel
		
		frame.setVisible(true); //shows the frame (false hides the frame)
	}
	
	public static void main(String[] args)
	{
		ButtonClicker myGui = new ButtonClicker();
	}

	//function that performs an action after listening to a button being clicked
	@Override
	public void actionPerformed(ActionEvent e)
	{
		btnCount++;
		label.setText("Num of clicks:"+btnCount); //sets the text displayed after the button click
		
	}
}
