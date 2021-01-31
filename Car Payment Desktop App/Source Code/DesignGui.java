
//Imported classes used in order to design the GUI
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.AbstractTableModel;

public class DesignGui extends JFrame
{
	// Instance variables for GUI components
	// such as (labels, textfields,buttons, comboboxes, tables, scroll pane)
	private JLabel numofMonthErrorLabel;
	private JLabel carPriceErrorLabel;
	private JLabel creditScoreNoticeLabel;
	private JLabel downPaymentErrorlabel;
	private JLabel interestRateErrorLabel;
	private JLabel monthlyPaymentLabel;
	private JLabel totalAmountPaidLabel;
	private JLabel totalInterestPaidLabel;
	private JLabel jlbLastPayment;
	private JLabel jlbLast = new JLabel("");
	private JButton calculateButton;
	private JTextField carPriceTextField;
	private JTextField downPaymentTextField;
	private JTextField interestRateTextField;
	private JTextField numOfMonthTextField;
	private JComboBox<String> creditScoreDropDownList; // A combox to show different types of credit scores
	private JScrollPane jScrollPane1;
	private JTable jTable;

	// Credit Score array
	// Used Final String because i want to treat the array as a constant
	// that doesnt change throughout the life of the program
	private static final String[] CREDIT_SCORES = { "Super Prime (781-850)", "Prime (661-780)", "Nonprime (601-660)",
			"Subprime (501-600)", "Deep Subprime (300-500)" };

	// Interest Rate array what score is linked to what interest rate
	private static final double[] INTEREST_RATES = { 3.99, 4.99, 6.99, 11.99, 13.99 };

	// Using array list to store our data to display as part of the loginfo for the
	// GUI
	public static ArrayList<CalculationMethods> carPaymentLogger = new ArrayList<CalculationMethods>();

	// Table model gets the loggedinfo dynamically without the need to store the
	// data first like the cayPaymentLogger
	AbstractTableModel model = new AbstractTableModel()
	{
		final String[] columns = { "Searches", "Car Price ($)", "Interest Rate ($)", "Months", "Monthly Payment ($)" };

		@Override
		public Object getValueAt(int row, int column)
		{
			CalculationMethods obj1 = carPaymentLogger.get(row); // defining where the data is stored

			switch (column)
			{
			case 0:
				return row + 1; // displays search count entered in column0
			case 1:
				return String.format("%.2f", obj1.getCarPrice()); // displays car price entered in column1
			case 2:
				return String.format("%.2f", obj1.getInterestRate()); // displays interest rate entered in column2
			case 3:
				return String.format("%d", obj1.getMonths()); // displays months entered in column3
			case 4:
				return String.format("%.2f", obj1.getMonthlyPayment()); // displays monthly payment entered in column4
			}
			return null;
		} // end of method body

		// Providing Implementation details for Interface called Table Model
		public int getRowCount()
		{
			return carPaymentLogger.size();
		}

		// Providing Implementation details for Interface called Table Model
		public int getColumnCount()
		{
			return columns.length;
		}

		// Providing Implementation details for Interface called Table Model
		public String getColumnName(int column)
		{
			return columns[column];
		}
	};

	public DesignGui()
	{
		Font smallFont = new Font("Tahoma", 1, 12);
		Font mediumFont = new Font("Tahoma", 1, 14);
		Font calbulateButtonFont = new Font("Tahoma", 1, 21);
		Font logDetails = new Font("Tahoma", 1, 30);
		Font guiTitleFont = new Font("Tahoma", 1, 36);

		JLabel jLabel1 = new JLabel("Car Payment Calculator");
		jLabel1.setFont(guiTitleFont);

		JLabel jLabel2 = new JLabel("What's your credit score?");
		jLabel2.setToolTipText("Name of the GUI");
		jLabel2.setFont(mediumFont);
		jLabel2.setToolTipText("");

		JLabel jLabel3 = new JLabel("Enter car price ($)");
		jLabel3.setFont(mediumFont);
		jLabel3.setToolTipText("Price of the car you wish to purchase");

		JLabel jLabel4 = new JLabel("Enter trade-in / down payment ($)");
		jLabel4.setFont(mediumFont);
		jLabel4.setToolTipText("your trade-in value or the downpayment value you wish to put down");

		JLabel jLabel5 = new JLabel("Enter interest rate (0-100)");
		jLabel5.setFont(mediumFont);
		jLabel5.setToolTipText("Banks offered interest rate");

		JLabel jLabel6 = new JLabel("Enter number of months (0-84)");
		jLabel6.setFont(mediumFont);
		jLabel6.setToolTipText("Banks offered payment periods for the loan");

		JLabel jLabel7 = new JLabel("Payment Details");
		jLabel7.setFont(mediumFont);
		jLabel7.setToolTipText("");

		JLabel jLabel8 = new JLabel("Calculated Monthly Payment");
		jLabel8.setFont(mediumFont);
		jLabel8.setToolTipText("Value that was calculated after hitting the calculate button");

		JLabel jLabel9 = new JLabel("Calculated Total amount paid");
		jLabel9.setFont(mediumFont);
		jLabel9.setToolTipText("Value that was calculated after hitting the calculate button");

		JLabel jLabel10 = new JLabel("Calculated Total interest paid");
		jLabel10.setFont(mediumFont);
		jLabel10.setToolTipText("Value that was calculated after hitting the calculate button");

		JLabel jLabel11 = new JLabel("Car payment logger");
		jLabel11.setFont(logDetails);
		jLabel11.setToolTipText("Keeps track of all the different Monthly Payment options");

		jlbLastPayment = new JLabel("Last payment"); // passing argument as the labels title
		jlbLastPayment.setFont(mediumFont);
		jlbLast.setForeground(new Color(0, 0, 204));
		jlbLast.setFont(smallFont);

		calculateButton = new JButton("Calculate"); // no arguments for title
		calculateButton.setFont(calbulateButtonFont);
		calculateButton.setToolTipText("Click this button to calculate payment details");

		creditScoreDropDownList = new JComboBox();
		carPriceTextField = new JTextField();
		downPaymentTextField = new JTextField();
		interestRateTextField = new JTextField();
		numOfMonthTextField = new JTextField();

		jTable = new JTable();
		jTable.setModel(model);
		jTable.setRowHeight(25);

		jScrollPane1 = new JScrollPane();
		jScrollPane1.setViewportView(jTable);

		monthlyPaymentLabel = new JLabel();
		monthlyPaymentLabel.setFont(smallFont);
		monthlyPaymentLabel.setForeground(new Color(0, 0, 204));
		monthlyPaymentLabel.setText("$0.00");

		totalAmountPaidLabel = new JLabel();
		totalAmountPaidLabel.setFont(smallFont);
		totalAmountPaidLabel.setForeground(new Color(0, 0, 204));
		totalAmountPaidLabel.setText("$0.00");

		totalInterestPaidLabel = new JLabel();
		totalInterestPaidLabel.setFont(smallFont);
		totalInterestPaidLabel.setForeground(new Color(0, 0, 204));
		totalInterestPaidLabel.setText("$0.00");

		downPaymentErrorlabel = new JLabel();
		downPaymentErrorlabel.setFont(smallFont);
		downPaymentErrorlabel.setForeground(new Color(255, 0, 0));

		carPriceErrorLabel = new JLabel();
		carPriceErrorLabel.setFont(smallFont);
		carPriceErrorLabel.setForeground(new Color(255, 0, 0));

		interestRateErrorLabel = new JLabel();
		interestRateErrorLabel.setFont(smallFont);
		interestRateErrorLabel.setForeground(new Color(255, 0, 0));

		numofMonthErrorLabel = new JLabel();
		numofMonthErrorLabel.setFont(smallFont);
		numofMonthErrorLabel.setForeground(new Color(255, 0, 0));

		creditScoreNoticeLabel = new JLabel();
		creditScoreNoticeLabel.setFont(smallFont);
		creditScoreNoticeLabel.setForeground(new Color(255, 0, 0));

		setDefaultCloseOperation(EXIT_ON_CLOSE); // closes GUI application the user clicks the x mark
		// setTitle("Car payment calculator"); // Name of the GUI

		creditScoreDropDownList.setModel(new DefaultComboBoxModel<String>(CREDIT_SCORES));

		calculateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				calculatebtnActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGroup(layout
						.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
								.addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(jLabel1).addGroup(layout
												.createSequentialGroup().addGap(33)
												.addGroup(layout.createParallelGroup(Alignment.LEADING)
														.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
																.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(creditScoreDropDownList, 0,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(carPriceTextField,
																		GroupLayout.PREFERRED_SIZE, 286,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
																.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(downPaymentTextField,
																		GroupLayout.PREFERRED_SIZE, 286,
																		GroupLayout.PREFERRED_SIZE))
														.addComponent(downPaymentErrorlabel).addComponent(
																carPriceErrorLabel)
														.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
																.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(interestRateTextField,
																		GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
														.addComponent(interestRateErrorLabel).addGroup(layout
																.createParallelGroup(Alignment.LEADING,
																		false)
																.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(numOfMonthTextField,
																		GroupLayout.PREFERRED_SIZE, 286,
																		GroupLayout.PREFERRED_SIZE))
														.addComponent(numofMonthErrorLabel)
														.addComponent(creditScoreNoticeLabel))
												.addGap(79).addGroup(
														layout.createParallelGroup(Alignment.LEADING)
																.addGroup(layout.createSequentialGroup()
																		.addComponent(jLabel7, GroupLayout.DEFAULT_SIZE,
																				265, Short.MAX_VALUE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(jLabel11).addGap(414))
																.addGroup(layout.createSequentialGroup().addGroup(layout
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(layout
																				.createParallelGroup(Alignment.LEADING)
																				.addGroup(layout.createSequentialGroup()
																						.addGroup(layout
																								.createParallelGroup(
																										Alignment.LEADING)
																								.addComponent(jLabel10,
																										GroupLayout.DEFAULT_SIZE,
																										455,
																										Short.MAX_VALUE)
																								.addComponent(jLabel8,
																										GroupLayout.DEFAULT_SIZE,
																										455,
																										Short.MAX_VALUE)
																								.addComponent(
																										jLabel9,
																										GroupLayout.DEFAULT_SIZE,
																										455,
																										Short.MAX_VALUE))
																						.addGap(24))
																				.addGroup(layout.createSequentialGroup()
																						.addGroup(layout
																								.createParallelGroup(
																										Alignment.LEADING)
																								.addComponent(
																										monthlyPaymentLabel)
																								.addComponent(
																										totalAmountPaidLabel)
																								.addComponent(
																										totalInterestPaidLabel))
																						.addPreferredGap(
																								ComponentPlacement.RELATED,
																								442, Short.MAX_VALUE)))
																		.addGroup(layout.createSequentialGroup()
																				.addComponent(jlbLastPayment)
																				.addPreferredGap(
																						ComponentPlacement.RELATED))
																		.addGroup(layout.createSequentialGroup()
																				.addComponent(jlbLast).addPreferredGap(
																						ComponentPlacement.RELATED)))
																		.addComponent(jScrollPane1,
																				GroupLayout.PREFERRED_SIZE, 538,
																				GroupLayout.PREFERRED_SIZE))))))
						.addGroup(layout.createSequentialGroup().addGap(98).addComponent(calculateButton,
								GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap().addComponent(jLabel1).addGap(18)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel2).addComponent(jLabel7)
						.addComponent(jLabel11))
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(30).addComponent(jLabel8)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(monthlyPaymentLabel))
								.addGroup(layout.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(creditScoreDropDownList, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(creditScoreNoticeLabel)))
								.addGap(12).addComponent(jLabel3).addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(carPriceTextField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel9))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(totalAmountPaidLabel).addComponent(carPriceErrorLabel))
								.addGap(27).addComponent(jLabel4)
								.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout
										.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(downPaymentTextField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(downPaymentErrorlabel)
										.addGap(35).addComponent(jLabel5).addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(interestRateTextField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(interestRateErrorLabel).addGap(36).addComponent(jLabel6)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(numOfMonthTextField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(numofMonthErrorLabel)
										.addPreferredGap(ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
										.addComponent(calculateButton, GroupLayout.PREFERRED_SIZE, 37,
												GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup().addGap(2).addComponent(jLabel10)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(totalInterestPaidLabel).addGap(18)
												.addComponent(jlbLastPayment).addGap(18).addComponent(jlbLast))))
						.addGroup(layout.createSequentialGroup().addGap(13).addComponent(jScrollPane1,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		getContentPane().setLayout(layout);

		pack(); // causes window to comform to the subcomponents preferred size and layout
	}

	// Handle the event of the user pressing the calculate button on the GUI
	private void calculatebtnActionPerformed(ActionEvent evt)
	{
		CalculationMethods obj2 = new CalculationMethods();
		int fields = 0;

		boolean valid = true;
		try
		{
			// First we parse convert the string data into double data.
			// If that approach doesnt work; we know the field is empty or has non numeric
			// values
			// In that case of empty field or non numeric values; the try/catch exception
			// handler will take care of the issue and
			// check for empty string

			carPriceErrorLabel.setText("");
			obj2.setCarPrice(Double.parseDouble(carPriceTextField.getText()));
			fields++;
		}
		catch (NumberFormatException errorMessage)
		{
			if (!carPriceTextField.getText().equals(""))
			{
				carPriceErrorLabel.setText("Please enter a valid number");
				valid = false;
			}
			else
			{
				setHistoryData(obj2);
			}
		}

		try
		{
			interestRateErrorLabel.setText("");
			double interestRate = Double.parseDouble(interestRateTextField.getText());
			if (interestRate > 100 || interestRate < 0)
			{
				throw new NumberFormatException();
			}
			fields++;
			obj2.setInterestRate(interestRate);

		}
		catch (NumberFormatException errorMessage)
		{
			creditScoreNoticeLabel.setText("");

			if (!interestRateTextField.getText().equals(""))
			{
				interestRateErrorLabel.setText("Please enter a valid number between 0-100");
				valid = false;
			}
			else if (carPaymentLogger.isEmpty())
			{
				obj2.setInterestRate(INTEREST_RATES[creditScoreDropDownList.getSelectedIndex()]);
				creditScoreNoticeLabel.setText(
						String.format("Based on your credit %.2f%% interest was used", obj2.getInterestRate()));
			}
			else
			{
				obj2.setInterestRate(-1);
				setHistoryData(obj2);
				CalculationMethods prev = carPaymentLogger.get(carPaymentLogger.size() - 1);
				obj2.setLoanAmount(prev.getLoanAmount());
			}
		}

		try
		{
			downPaymentErrorlabel.setText("");
			obj2.setDownPayment(Double.parseDouble(downPaymentTextField.getText()));
			fields++;
		}
		catch (NumberFormatException nex)
		{
			if (!downPaymentTextField.getText().equals(""))
			{
				downPaymentErrorlabel.setText("Please enter a valid number");
				valid = false;
			}
			else
			{
				setHistoryData(obj2);
			}
		}

		try
		{
			numofMonthErrorLabel.setText("");
			int months = Integer.parseInt(numOfMonthTextField.getText());
			if (months > 84)
			{
				throw new NumberFormatException();
			}
			fields++;
			obj2.setMonths(months);
		}
		catch (NumberFormatException nex)
		{
			if (!numOfMonthTextField.getText().equals(""))
			{
				numofMonthErrorLabel.setText("Please enter a valid number between 0-84");
				valid = false;
			}
			else
			{
				setHistoryData(obj2);

			}
		}

		if (valid && fields >= 3)
		{
			// following calculations below are computed independent of the GUI construction
			// so thats
			// why i stored all the calculations into an object
			obj2.calculate();
			// Updating GUI display
			monthlyPaymentLabel.setText(String.format("$%.2f", obj2.getMonthlyPayment()));
			totalAmountPaidLabel.setText(String.format("$%.2f", obj2.getTotalAmountPaid()));
			totalInterestPaidLabel.setText(String.format("$%.2f", obj2.getTotalInterestPaid()));
			numOfMonthTextField.setText(String.format("%d", obj2.getMonths()));
			jlbLast.setText(String.format("$%.2f", obj2.getLastPayment()));
			carPriceTextField.setText(String.format("%.2f", obj2.getCarPrice()));
			downPaymentTextField.setText(String.format("%.2f", obj2.getDownPayment()));
			interestRateTextField.setText(String.format("%.2f", obj2.getInterestRate()));
			carPaymentLogger.add(obj2); // store payment details into the payment log
			model.fireTableDataChanged();
		}

	}

	private void setHistoryData(CalculationMethods obj3)
	{
		// models the condition of the user deleting the months field.
		// Here we use the last calculations (total loan amount & monthly payment)
		// values
		// to solve for deleted months field
		if (!carPaymentLogger.isEmpty())
		{
			CalculationMethods prev = carPaymentLogger.get(carPaymentLogger.size() - 1);

			obj3.setTotalAmountPaid(prev.getTotalAmountPaid());

			obj3.setMonthlyPayment(prev.getMonthlyPayment());
			obj3.setTotalInterestPaid(prev.getTotalInterestPaid());
		}
	}
} // end of class body