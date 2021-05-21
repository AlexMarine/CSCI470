//////////////////////////////////////////////////////////////////////////////////////////
//
//	Program Name:	Date.java
//
//	Author:		Alex Marine (z1863905)
//	Professor:	Dr. James Leon
//	Class:		CSCI 470
//	Date:		September 6, 2020
//
//	Goal of Program:
//		Inlcude 3 instance variables for month, day, and year. Use a constructor 
//	to initialize the variables. Provide a set and get method for each variable. 
//	Provide a method "displayDate" that displayes the month, day, and year seperated 
//	by forward slashes.
//
//////////////////////////////////////////////////////////////////////////////////////////

//Create Date class
public class Date
{
	//Variable declaration
	int month;	//month of transaction
	int day;	//day of transaction
	int year;	//year of transaction

	//Constructor to initialize variables
	public Date(int inMonth, int inDay, int inYear)
	{
		//Initialize variable
		this.month = inMonth;
		this.day = inDay;
		this.year = inYear;
	}

	//Set method for month
	public void setMonth(int inMonth)
	{
		//Initialize month
		this.month = inMonth;
	}

	//Get method for Month
	public int getMonth()
	{
		//Return month
		return this.month;
	}

	//Set method for day
	public void setDay(int inDay)
	{
		//Initialize day
		this.day = inDay;
	}

	//Get method for day
	public int getDay()
	{
		//Return day
		return this.day;
	}

	//Set method for year
	public void setYear(int inYear)
	{
		//Initialize year
		this.year = inYear;
	}

	//Get method for year
	public int getYear()
	{
		//Return year
		return this.year;
	}

	//Method to output formatted date
	public void displayDate()
	{
		//Output the formatted date
		System.out.println(this.month + "/" + this.day + "/" + this.year);
	}
}
