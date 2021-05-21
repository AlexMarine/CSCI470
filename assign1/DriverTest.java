//////////////////////////////////////////////////////////////////////////////////////////
//
//	Program Name:	DriverTest.java
//
//	Author:		Alex Marine (z1863905)
//	Professor:	Dr. James Leon
//	Class:		CSCI 470
//	Date:		September 6, 2020
//
//	Goal of Program:
//		Driver application that demonstrates class Employee's and Date's 
//	capabilties. Creates two Employee objects and displays each objects yearly salary.
//	Give each Employee a 10% raise and display each Employee's yearly salary again.
//	Informs the user about my some days that are not my birthday, then tells them what 
//	it actually is.
//
//////////////////////////////////////////////////////////////////////////////////////////

//for 2 decimal places
import java.text.DecimalFormat;

//Create DriverTest class
public class DriverTest
{
	//formats decimals to 2 decimal places
	private static DecimalFormat df2 = new DecimalFormat("#.00");

	//Method for testing my Classes
	public static void main(String[] args)
	{
		//Initialize Employee objects
		Employee emp1 = new Employee("John", "Smith", 1500.00);
		Employee emp2 = new Employee("Sarah", "Johnson", 5000.00);
	
		//Output emp1's and emp2's yearly salary
		System.out.println("\n" + emp1.getFirstName() + " " + emp1.getLastName() + 
			"'s yearly salary: " + df2.format(emp1.getMonthlySalary() * 12));
		System.out.println(emp2.getFirstName() + " " + emp2.getLastName() + 
			"'s yearly salary: " + df2.format(emp2.getMonthlySalary() * 12) + "\n");

		//Give emp1 and emp2 a 10% raise on their monthly salary
		emp1.setMonthlySalary(emp1.getMonthlySalary() * 1.1);
		emp2.setMonthlySalary(emp2.getMonthlySalary() * 1.1);

		//inform user of the raise
		System.out.println("A 10% has been given to all employees! \n");

		//Output emp1's and emp2's new yearly salary
		System.out.println(emp1.getFirstName() + " " + emp1.getLastName() + 
			"'s new yearly salary: " + df2.format(emp1.getMonthlySalary() * 12));
		System.out.println(emp2.getFirstName() + " " + emp2.getLastName() + 
			"'s new yearly salary: " + df2.format(emp2.getMonthlySalary() * 12) + "\n");

		//Initialize Date object
		Date d1 = new Date(3, 17, 2001);
		
		//Inform user about a date that is not my birthday
		System.out.println("My birthday is not ");
		d1.displayDate();

		//Set month, day, and year to another date that is not my birthday
		d1.setMonth(8);
		d1.setDay(3);
		d1.setYear(1995);

		//Inform user about a month, day, and year that my birthday isn't in
		System.out.println("I was not born in the month " + d1.getMonth());
		System.out.println("I was not born in the day " + d1.getDay());
		System.out.println("I was not born in the year " + d1.getYear() + "\n");

		//Set month, day, and year to my birthday
		d1.setMonth(10);
		d1.setDay(30);
		d1.setYear(1998);

		//Inform user about my birthday
		System.out.println("My birthday is ");
		d1.displayDate();
	}
}
