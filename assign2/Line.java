
/////////////////////////////////////////////////////////////////////////////
//
//  Program:    Line.java
//
//  Author:     Alex Marine (z1863905)
//  Professor:  Dr. James Leon
//  Class:      CSCI 470
//  Date:       September 16, 2020
//
//  Original Program:
//    This program demonstrates a simple "Line" class. Here, a Line class
//  is defined with its properties and interface (i.e., its methods). 
//  A main method (in TestLine) then creates instances of this Line
//  class and calls on the methods to demonstrate its behavior.
//
//  Changes to Program:
//    Second constructor added that accepts two TwoDPoint objects and
//  chains itself to the first constructor. getLength() and getAngle()
//  added to calcualate the length and angle, respectively, of the
//  coordinates provided.
//
////////////////////////////////////////////////////////////////////////////

package marinelinepackage;  //Place in package
import java.lang.Math;      //For use of sqrt
import java.io.*;           //For input/output streams

//Class to operate with points of 2 different lines
public class Line
{
  //Coordinates of the line constructor
  private int x1, y1, x2, y2;

  //Receives 4 integers which are the Line's start and end points. 
  public Line(int xOne, int yOne, int xTwo, int yTwo)
  { 
    //Each of these validates its argument
    setXOne(xOne); 
    setYOne(yOne); 
    setXTwo(xTwo); 
    setYTwo(yTwo);
  }

  //Constructor takes in 2 TwoDPoint objects which take pair of x & y
  public Line(TwoDPoint obj1, TwoDPoint obj2)
  {    
    //Chain constructors and initialize variables
    this(obj1.x, obj1.y, obj2.x, obj2.y);
  }
 
  //method draw() calls another method called drawLine(), 
  //which is assumed to be a graphics primitive on the 
  //system. However, since this program will be 
  //run in console mode, a text description of the Line 
  //will be displayed.
  public void draw() 
  { 
    drawLine(x1, y1, x2, y2);
  }

  //method drawLine() simulates drawing of a line for console mode. 
  //It should describe all the important attributes of the line. 
  //In a graphics mode program, we would delete this and use the 
  //system's Graphics library drawLine(). // 
  private void drawLine(int x1, int y1, int x2, int y2) 
  { 
    System.out.println("Draw a line from x of " + x1 + " and y of " + y1); 
    System.out.println("to x of " + x2 + " and y of " + y2 + "\n");
  }
                  
  //Method setLine() allows user to change the points of the 
  //already existing Line. 
  public void setLine(int xOne, int yOne, int xTwo, int yTwo) 
  { 
    setXOne(xOne);
    setYOne(yOne);
    setXTwo(xTwo);
    setYTwo(yTwo);
  }

  // -- the individual setXXXX methods that prevent 
  //  any line's coordinate from being offscreen.  
  //  In the event of an invalid (offscreen) value,  
  //  that value is (silently) set to 0. 
  public void setXOne(int xOne) 
  {
    if (xOne < 0 || xOne > 639)
      throw new IllegalArgumentException("Invalid input");
    else
      x1 = xOne;
  } 
  public void setYOne(int yOne) 
  {    
    if (yOne < 0 || yOne > 479)
      throw new IllegalArgumentException("Invalid input");
    else
      y1 = yOne;
  } 
  public void setXTwo(int xTwo) 
  {    
    if (xTwo > 639 || xTwo < 0)
      throw new IllegalArgumentException("Invalid input");
    else
      x2 = xTwo;
  } 
  public void setYTwo(int yTwo) 
  {    
    if (yTwo > 479 || yTwo < 0)
      throw new IllegalArgumentException("Invalid input");
    else
      y2 = yTwo;
  } 

  //Now for some "get" Access methods to get individual values 
  public int getXOne() 
  {  
    return x1; 
  }  
  public int getYOne() 
  {  
    return y1; 
  }  
    public int getXTwo()
  {
    return x2; 
  } 
  public int getYTwo() 
  { 
    return y2; 
  }

  //Method to get the length of a line
  public double getLength()
  {
    //Return the length of line following the formula
    return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
  }

  //Method to get the angle of a line
  public double getAngle()
  {
    //return the angle of a line following the formula
    return Math.asin((y2-y1)/getLength());
  }
}
