////////////////////////////////////////////////////////////////////////////
//
//  Program:    TestLine.java
//
//  Author:     Alex Marine (z1863905)
//  Professor:  Dr. James Leon
//  Class:      CSCI 470
//  Date:       September 16, 2020
//
//  Original Program:
//    Now we will define a driver program below called TestLine with 
//  main() where execution will begin. It is this class, and this code,
//  that will create instances of the Line and call its methods. As a 
//  test module, this code would be improved with additional 
//  System.out.println() statements that explain what is being attempted
//  and what the results should be, for example: "About to change l1 to
//  an invalid value and then redraw it. Line position 
//  should not change: "
//
//  Changes to Program:
//    Try/Catch blocks added to parts of the program that intend either to
//  alter a Line's position or create a new Line. If a Line is created
//  with an invalid value, the program ends with a RC of 88. Code added to
//  test getLength() and getAngle() methods from Line class. Code added to
//  test TwoDPoint class and second constructor from Line class.
//
///////////////////////////////////////////////////////////////////////////

//import package for line
import marinelinepackage.*;

//Driver class to test our Line and TwoDPoint classes
class TestLine
{ 
  //Method for testing Line and TwoDPoint classes
  public static void main(String args[]) 
  { 
    //Declare 3 instances of Line class
    Line l1 = null, l2 = null, l3 = null;

    //Initialize new TwoDPoint objects for testing
    TwoDPoint tdp1 = new TwoDPoint(1, 2);
    TwoDPoint tdp2 = new TwoDPoint(9, 8);

    //Initialize new Line object for second constructor
    Line line1 = new Line(tdp1, tdp2);

    //Try to create Line object and draw
    try
    {
      //Create 1 Line object 
      l1 = new Line (10, 10, 100, 100); 
      //Draw it 
      l1.draw(); 
    }
    //Catch if a number is out of the set range
    catch (IllegalArgumentException e)
    {
      //Inform the user of the exception
      System.out.println("--EXCEPTION: ARGUMENT TO CREATE LINE OUT OF RANGE\n");
    }

    //Try to change the starting postion of Line object and draw
    try
    {
      //Change start point with valid values
      l1.setLine(5, 5, l1.getXTwo(), l1.getYTwo()); 
      //draw it again with new start point 
      l1.draw(); 
    }
    //Catch if a number is out of the set range
    catch (IllegalArgumentException e)
    {
      //Inform the user of the exception
      System.out.println("--EXCEPTION: ARGUMENT TO ALTER LINE OUT OF RANGE\n");
    }

    //Try to change the starting postion of Line object and draw
    try
    {
      //try to change xOne (x1) to an illegal value 
      l1.setXOne(3000); 
      //draw the line...x1 should now be zero 
      l1.draw();
    }
    //Catch if a number is out of the set range
    catch (IllegalArgumentException e)
    {
      //Inform the user of the exception
      System.out.println("--EXCEPTION: ARGUMENT TO ALTER LINE OUT OF RANGE\n");
    }

    //Try to create Line object and draw
    try
    {
      //create a second Line instance, or object 
      l2 = new Line(100, 100, 400, 400); 
      //draw 2nd line 
      l2.draw(); 
    }
    //catch if a number is out of the set range
    catch (IllegalArgumentException e)
    {
      //Inform the user of the exception
      System.out.println("--EXCEPTION: ARGUMENT TO ALTER LINE OUT OF RANGE\n");
    }

    //try to change the starting position of Line object and draw
    try
    {
      //set a new valid yTwo for line 2 
      l2.setYTwo(479); 
      //draw 2nd line again 
      l2.draw();
    }
    //Catch if a number is out of the set range
    catch (IllegalArgumentException e)
    {
      //Inform the user of the exception
      System.out.println("--EXCEPTION: ARGUMENT TO CREATE LINE OUT OF RANGE\n");
    }
    
    //Try to change the starting posion of the Line objects
    try
    {
      //Change start point of instance variables
      l1.setLine(5, 5, l1.getXTwo(), l1.getYTwo());
      l2.setLine(100, 100, 400, 479);
    }
    //Catch if a number is out of the se range
    catch (IllegalArgumentException e)
    {
      //Inform the user of the exception
      System.out.println("--EXCEPTIONl ARGUMENT TO ALTER LINES OUT OF RANGE\n");
    }

    //Output angles and lengths of lines by calling methods
    System.out.println("The angle for line 1 is " + l1.getAngle());
    System.out.println("The angle for line 2 is " + l2.getAngle() + "\n");
    System.out.println("The length for line 1 is " + l1.getLength());
    System.out.println("The length for line 2 is " + l2.getLength() + "\n");

    //Output each variable that is in object line1
    System.out.println("Test 2D point Constructor X1 = " + line1.getXOne() + "\n");
    System.out.println("Test 2D point Constructor X2 = " + line1.getYOne() + "\n");
    System.out.println("Test 2D point Constructor Y1 = " + line1.getXTwo() + "\n");
    System.out.println("Test 2D point Constructor Y2 = " + line1.getYTwo() + "\n");

    //try to initialize Line object
    try
    {
      //Create a instance of Line
      l3 = new Line(5000, 0, 0, 0);
    }
    //Catch if a number is out of the set range
    catch (IllegalArgumentException e)
    {
      //Inform user of the exception and end program
      System.out.println("--EXCEPTION: ARGUMENT TO CREATE LINE OUT OF RANGE");
      System.out.println("--LEAVING WITH RC OF 88");
      System.exit(88);
    }
  }
}
