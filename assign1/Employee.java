//////////////////////////////////////////////////////////////////////////////////////////
//
//	Program Name:	Employee.java
//
//	Author:		Alex Marine (z1863905)
//	Professor:	Dr. James Leon
//	Class:		CSCI 470
//	Date:		September 6, 2020
//
//	Goal of Program:
//		Create a class that has 3 instance variables for first name, last name, 
//	and monthly salary. Make a constructor that initializes the 3 variables. Use a set 
//	and get method for each variable. If monthly salary is not positive, do not set 
//	its value.
//
//////////////////////////////////////////////////////////////////////////////////////////

//Create Employee class
public class Employee
{
	//variable declaration
	String firstName;	//Employee's first name
	String lastName;	//Employee's last name
	double monthlySalary;	//Employee's monthly salary

	//Constructor to initialize variables
	public Employee(String inFirstName, String inLastName, double inMonthlySalary)
	{
		//Initialize variables
		this.firstName = inFirstName;
		this.lastName = inLastName;
		this.monthlySalary = inMonthlySalary;
	}

	//Set method for first name
	public void setFirstName(String inFirstName)
	{
		//Initialize first name
		this.firstName = inFirstName;
	}

	//Get method for first name
	public String getFirstName()
	{
		//Return first name
		return this.firstName;
	}

	//Set method for last name
	public void setLastName(String inLastName)
	{
		//Initialize last name
		this.lastName = inLastName;
	}

	//Get method for last name
	public String getLastName()
	{
		//Return last name
		return this.lastName;
	}

	//Set method for monthly salary
	public void setMonthlySalary(double inMonthlySalary)
	{
		//If the monthly salary is less than 0
		if (monthlySalary < 0)
		{
			//Initialize monthly salary to 0
			this.monthlySalary = 0;

			//Inform the user
			System.out.println("Invalid input: Monthly salary can not be negative.");
		}
		//if the monthly salary is not less than 0
		else
		{
			//Initialize monthly salary
			this.monthlySalary = inMonthlySalary;
		}
	}

	//Get method for monthly salary
	public double getMonthlySalary()
	{
		//Return last name
		return this.monthlySalary;
	}
}
