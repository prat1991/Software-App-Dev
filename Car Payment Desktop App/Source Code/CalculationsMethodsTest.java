
//Imported Classes in order to do JUNIT testing
import static org.junit.Assert.assertEquals; // allows us to check the accuracy of the output variables

import org.junit.Before; //setus up objects before running test cases
import org.junit.FixMethodOrder; // allows us to control the order of text cases
import org.junit.Test; // allows us to write junit tests
import org.junit.runners.MethodSorters; // allows us to control the order of text execution

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // allows us to control the order of text execution

public class CalculationsMethodsTest
{
	CalculationMethods object; // initializing object at class level so local methods can use object

	@Before
	public void setUp() throws Exception
	{
		// declaring the object to allow all the test cases to use the object
		object = new CalculationMethods();
	}

	@Test
	public void test01_ZeroInterest()
	{
		// fully define input variables(knowns)
		object.setCarPrice(1000);
		object.setDownPayment(0.00);
		object.setInterestRate(0);
		object.setMonths(3);
		// calculate output variables(unknowns)
		object.calculate();
		// check output variables accuracy by comparing it against known values
		assertEquals(333.33, object.getMonthlyPayment(), 0.01);
		assertEquals(333.34, object.getLastPayment(), 0.01);
		assertEquals(1000, object.getTotalAmountPaid(), 0.01);
	}

	@Test
	public void test02_PositiveInterest()
	{
		// fully define input variables(knowns)
		object.setCarPrice(1000);
		object.setDownPayment(0.00);
		object.setInterestRate(1);
		object.setMonths(3);
		// calculate output variables(unknowns)
		object.calculate();
		// check output variables accuracy by comparing it against known values
		assertEquals(333.89, object.getMonthlyPayment(), 0.01);
		assertEquals(333.89, object.getLastPayment(), 0.01);
	}

	// Calculate the number of months when the loan amount and interest rates are
	// known
	@Test
	public void test03_CalculateMonths()
	{
		// fully define input variables(knowns)
		object.setCarPrice(1000);
		object.setDownPayment(0.00);
		object.setInterestRate(4);
		object.setMonths(12);
		// calculate output variables(unknowns)
		object.calculate();
		// check output variables accuracy by comparing it against known values
		assertEquals(85.15, object.getMonthlyPayment(), 0.01);
		assertEquals(1021.8, object.getTotalAmountPaid(), 0.01);
		// create objects
		object = new CalculationMethods();
		// fully define input variables(knowns)
		object.setCarPrice(1000);
		object.setDownPayment(0.00);
		object.setInterestRate(4);
		object.setTotalAmountPaid(1021.8);
		object.setMonthlyPayment(85.15);
		// calculate output variables(unknowns)
		object.calculate();
		// check output variables accuracy by comparing it against known values
		assertEquals(12, object.getMonths());
	}

	// Calculate the number of months when the loan amount and interest rates are
	// known

	@Test
	public void test04_DownPayment()
	{
		// fully define input variables(knowns)
		object.setCarPrice(1000);
		object.setDownPayment(0.00);
		object.setInterestRate(4);
		object.setMonths(12);
		// calculate output variables(unknowns)
		object.calculate();
		// check output variables accuracy by comparing it against known values
		assertEquals(85.15, object.getMonthlyPayment(), 0.01);
		assertEquals(1021.8, object.getTotalAmountPaid(), 0.01);
		// fully define input variables(knowns)
		object.setCarPrice(1000);
		object.setDownPayment(0.00);
		object.setInterestRate(4);
		object.setTotalAmountPaid(1021.8);
		object.setMonthlyPayment(85.15);
		object.setDownPayment(-1);
		object.setMonths(12);
		// calculate output variables(unknowns)
		object.calculate();
		// check output variables accuracy by comparing it against known values
		assertEquals(12, object.getMonths());
		assertEquals(0, object.getDownPayment(), 0.01);
	} // end of method body

	@Test
	public void test05_CarPrice()
	{
		// fully define input variables(knowns)
		object.setCarPrice(1000);
		object.setInterestRate(4);
		object.setMonths(12);
		// calculate output variables(unknowns)
		object.calculate();
		// check output variables accuracy by comparing it against known values
		assertEquals(85.15, object.getMonthlyPayment(), 0.01);
		assertEquals(1021.8, object.getTotalAmountPaid(), 0.01);
	} // end of method body
}// end of class body
