public class CalculationMethods
{
	// Instance Variables
	double carPrice = -1;
	double downPayment = -1;
	double interestRate = -1;
	int months = 0;
	double monthlyPayment = -1;
	double loanAmount = -1;
	double totalAmountPaid = -1;
	double totalInterestPaid = -1;
	double lastPayment = 0;

	// Getter and Setter Method for Instance Variables
	public double getCarPrice()
	{
		return carPrice;
	}

	public void setCarPrice(double carPrice)
	{
		this.carPrice = carPrice;
	}

	public double getInterestRate()
	{
		return interestRate;
	}

	public void setInterestRate(double interestRate)
	{
		this.interestRate = interestRate;
	}

	public int getMonths()
	{
		return months;
	}

	public void setMonths(int months)
	{
		this.months = months;
	}

	public double getMonthlyPayment()
	{
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment)
	{
		this.monthlyPayment = monthlyPayment;
	}

	public double getTotalAmountPaid()
	{
		return totalAmountPaid;
	}

	public void setTotalAmountPaid(double totalAmountPaid)
	{
		this.totalAmountPaid = totalAmountPaid;
	}

	public double getTotalInterestPaid()
	{
		return totalInterestPaid;
	}

	public void setTotalInterestPaid(double totalInterestPaid)
	{
		this.totalInterestPaid = totalInterestPaid;
	}

	public void setDownPayment(double downPayment)
	{
		this.downPayment = downPayment;
	}

	public void calculate()
	{
		if (monthlyPayment == -1)
		{
			calculateMonthly();
		}
		else if (months == 0 && monthlyPayment != 0)
		{
			months = (int) Math.round(totalAmountPaid / monthlyPayment);
			calculateLastPayment();
		}
		else if (downPayment == -1)
		{
			calculateDownPayment();
		}
		else if (carPrice == -1)
		{
			calculateCarPrice();
		}
		else if (interestRate == -1)
		{
			newton();
		}
	}

	// Solving for car price assuming total amount paid = unknown If total amount
	// paid = known , car price = (total amount paid - total interest paid) +
	// downpayment
	private void calculateCarPrice()
	{
		double i = interestRate / 1200.0;

		if (Math.pow(i + 1, months) != 1)
		{
			double exp = i * Math.pow(i + 1, months) / (Math.pow(i + 1, months) - 1);
			loanAmount = monthlyPayment / exp;
		}
		else
		{
			loanAmount = monthlyPayment * months;

		}
		carPrice = loanAmount + downPayment;
		calculateLastPayment();
	}

	public double getDownPayment()
	{
		return downPayment;
	}

	private void calculateDownPayment()
	{
		double i = interestRate / 1200.0;
		if (i == 0)
		{
			i = 0.0000001;
		}

		double exp = i * Math.pow(i + 1, months) / (Math.pow(i + 1, months) - 1);

		double numerator = carPrice * exp - monthlyPayment;

		downPayment = numerator / exp; // here exp is the denominator;
		calculateLastPayment();
	}

	private void calculateMonthly()
	{
		if (downPayment == -1)
		{
			downPayment = 0;
		}

		loanAmount = carPrice - downPayment;
		double rate = interestRate / 1200.0; // converts APR into monthly interest rate
		if (rate == 0)
		{
			monthlyPayment = loanAmount / months;
		}
		else
		{
			monthlyPayment = (rate / (1 - Math.pow(1 + rate, months * -1))) * loanAmount;
		}

		calculateLastPayment();
		totalInterestPaid = totalAmountPaid - loanAmount;
		if (totalAmountPaid < 0)
		{
			totalInterestPaid = 0;
		}
	}

	private void calculateLastPayment()
	{
		double tmpMonthly = Math.round(monthlyPayment * 100.0) / 100.0;

		if (totalAmountPaid == -1)
		{
			totalAmountPaid = monthlyPayment * months;
		}

		if ((tmpMonthly * months) > totalAmountPaid)
		{
			lastPayment = tmpMonthly - ((tmpMonthly * months) - totalAmountPaid);
		}
		else
		{
			lastPayment = tmpMonthly + (totalAmountPaid - (tmpMonthly * months));
		}
	}

	public double getLoanAmount()
	{
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount)
	{
		this.loanAmount = loanAmount;
	}

	public double getLastPayment()
	{
		return lastPayment;
	}

	public double m(double r)
	{
		return 1 + r / 12;
	}

	public double m_inverse(double r)
	{
		return 12.0 * (r - 1);
	}

	public double f(double m)
	{
		double x = (loanAmount * Math.pow(m, months + 1)) - (loanAmount + monthlyPayment) * Math.pow(m, months)
				+ monthlyPayment;
		return x;
	}

	public double fdash(double m)
	{
		return (loanAmount * (months + 1) * Math.pow(m, months)
				- (loanAmount + monthlyPayment) * months * Math.pow(m, months - 1));
	}

	// Newton raphson method to calculate interest rate
	// Reference Link:
	// https://blog.bossylobster.com/2012/05/reverse-calculating-interest-rate

	private void newton()
	{
		double current = m(1);
		if (loanAmount == -1)
		{
			loanAmount = carPrice - downPayment;
		}
		while (Math.abs(f(current)) > 0.0001)
		{
			current = current - f(current) / fdash(current);
		}

		interestRate = m_inverse(current) * 100;

		calculateLastPayment();
	}
} // end of class body