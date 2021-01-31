
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller
{
	private View2 View2Object;
	private Model ModelObject;

	// Constructor (called when object is created)
	public Controller(View2 View2Object, Model ModelObject)
	{
		this.View2Object = View2Object;
		this.ModelObject = ModelObject;

		// Tell the View to execute the actionPerformed method
		// in the CalculateListener inner class when ever the calculate button
		// is clicked

		this.View2Object.addCalculateListener(new ButtonListener());
	}

	// InnerClass (contains the button listener)
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int firstNumber, secondNumber = 0;
			// Surround interactions with the view with
			// a try block in case numbers weren't properly entered

			try
			{
				firstNumber = View2Object.getFirstNumberGuiInput(); // gets first number from the view
				secondNumber = View2Object.getSecondNumberGuiInput(); // gets second number from the view
				ModelObject.setAddTwoNumbers(firstNumber, secondNumber); // model performs calculation and stores the
																			// value into the additionValue variable
				View2Object.setAnswerGuiOutput(ModelObject.getAddTwoNumbers()); // view gets the additionValue variable
			}
			catch (NumberFormatException errorMessage)
			{
				View2Object.displayErrorMessage("You Need to Enter 2 Integers");
			}
		}
	}
}
