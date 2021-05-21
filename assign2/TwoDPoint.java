////////////////////////////////////////////////////////////////////
//
//  Program:    TwoDPoint.java
//
//  Author:     Alex Marine (z1863905)
//  Professor:  Dr. James Leon
//  Class:      CSCI 470
//  Date:       September 16, 2020
//
//  Goal of Program:
//    This program is a class that is used by Line.java to store 
//  both an x and y coordinate for ease of use in calculations.
//
///////////////////////////////////////////////////////////////////

//Place in package
package marinelinepackage;

//Class for the 2 points of a line
public class TwoDPoint
{
  //Variable declaration
  int x, y;	//two points of line

  //Constructor to initialize variables
  public TwoDPoint(int x, int y)
  {
    //Initialize variables
    this.x = x;
    this.y = y;
  }
}
