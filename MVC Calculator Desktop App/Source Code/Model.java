
public class Model
{
	// Model contains the data
	private int additionCalculatedValue;

	// Model contains a setter method to update the data
	public void setAddTwoNumbers(int num1, int num2)
	{
		this.additionCalculatedValue = num1 + num2;
	}

	// Model contains a getter method provides access to the data
	public int getAddTwoNumbers()
	{
		return this.additionCalculatedValue;
	}
}
