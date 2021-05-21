////////////////////////////////////////////////////////////////////////////
//
//  Program:    Ball.java
//
//  Author:     Alex Marine (z1863905)
//  Professor:  Dr. James Leon
//  Class:      CSCI 470
//  Date:       December 4, 2020
//
//  Goal of Program:
//    This program sets the details for each Ball object including the
//   color, radius, x and y coordinates, and how the ball moves in the x 
//   and y plane. Implements the move method for how each ball moves, as
//   well as the draw method, which draws the balls on the Panel.
//
///////////////////////////////////////////////////////////////////////////

import java.awt.*; //import all awt classes
import java.awt.event.*; //import all awt.event classes
import javax.swing.*; //import all swing classes

class Ball
{
  //variable declaration
  Color color; //Color of ball
  int radius;  //radius of ball
  int x, y;    //coordinates of ball
  int dx, dy;  //movement of ball

  //default constructor
  Ball(Color col, int rad, int x, int y, int dx, int dy)
  {
    //initialize the variables
    this.color = col;
    this.radius = rad;
    this.x = x;
    this.y = y;
    this.dx = dx;
    this.dy = dy;
  }
 
  //emthod that moves the balls in the animation panel
  public void move(Dimension dPanel)
  {
    System.out.println("move");

    //checks to see if ball hits the side of the panel
    if (x <= radius || x >= (dPanel.width - (2 * radius)))
    {
      //switch direction
      dx = -dx;
    }
    //checks to see if ball hits top or botton of the panel
    if (y <= radius || y >= (dPanel.height - (2 * radius)))
    {
      dy = -dy;
    }

    //if not, continue moving ball
    x += dx;
    y =+ dy;
  }

  public void draw(Graphics g)
  {
    System.out.println("draw");

    //sets the color to whatever tbe ball was
    g.setColor(color);

    //draws the ball in the new location
    g.fillOval(x, y, 2 * radius, 2 * radius);
  }
}
