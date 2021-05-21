////////////////////////////////////////////////////////////////////////////
//
//  Program:    AnimationPanel.java
//
//  Author:     Alex Marine (z1863905)
//  Professor:  Dr. James Leon
//  Class:      CSCI 470
//  Date:       December 4, 2020
//
//  Goal of Program:
//    Program that contains methods for when the start and stop button are
//  clicked. Implements the Runnable interface that paints to the Panel
//  in a loop while the thread is not null. When it is the first time
//  calling paint, add Ball objects to the array list. Then, call move and
//  draw methods from Ball class for each Ball in array list.
//
///////////////////////////////////////////////////////////////////////////

import java.awt.*; //import all awt classes
import java.awt.event.*; //import all awt.event classes
import javax.swing.*; //import all swing classes
import java.util.*; //import all util classes

//class that has start and stop methods, as well as run and paint methods
public class AnimationPanel extends JPanel implements Runnable
{
  //initialize ArrayList of Ball objects
  ArrayList<Ball> ballAL = new ArrayList<>();

  //reference to a Dimension object this is set to null
  Dimension dimPtr = null;

  //reference to a Thread object that is set to null
  Thread threadPtr = null;

  //default constrcutor
  public AnimationPanel()
  {
    //set Dimension to the size of ballPanel
    dimPtr = new Dimension(300, 250);

    //set preferred size to dimPtr and background to white
    this.setPreferredSize(dimPtr);
    this.setBackground(Color.white);
  }
  
  //method that runs when start button is clicked
  public void start()
  {
    //if the Thread pointer is null
    if (threadPtr == null)
    {
      //new up the Thread object and call the start method
      System.out.println("Start button clicked.");
      threadPtr = new Thread(this, "Bouncing Ball");
      threadPtr.start();
    }
  }

  //method that runs when stop button is clicked
  public void stop()
  {
    //set the Thread object to null
    System.out.println("Stop button clicked.");
    threadPtr = null;
  }

  //run method for interface
  public void run()
  {
    //while the Thread object is not null
    while (threadPtr != null)
    {
      System.out.println("running");

      try
      {
	//wait for 200 miliseconds
        Thread.sleep(200);
      }
      catch (InterruptedException e)
      {
	//Outout exception error
        System.out.println("EXCEPTION HAS OCCURED");
      }

      //call repaint method
      this.repaint();
    }
  }
  
  //method that paints to the GUI
  @Override
  protected void paintComponent(Graphics g)
  {
    //call to super
    super.paintComponent(g);

    System.out.println("paint");

    //Initialize Ball objects
    Ball ball1Ptr = new Ball(Color.green, (dimPtr.width*2/3), 
		    (dimPtr.height-28), -2, -4, 20);
    Ball ball2Ptr = new Ball(Color.blue, (dimPtr.width*1/2),
		    (dimPtr.height-12), 4, 6, 14);

    //if the Dimension pointer is null
    if (dimPtr == null)
    {
      System.out.println("Dimension is null");

      //add ball objects to Arraylist
      ballAL.add(ball1Ptr);
      ballAL.add(ball2Ptr);

      //set the Dimension pointer
      dimPtr = this.getSize();
    }
    
    //call move method for each ball in arraylist
    ball1Ptr.move(dimPtr);
    //ball2Ptr.move(dimPtr);
    //ballAL.forEach((e) -> {
    //  e.move(dimPtr);
    //});

    //call draw method for each ball in arraylist
    ball1Ptr.draw(g);
    //ball2Ptr.draw(g);
    //ballAL.forEach((e) -> {
    //  e.draw(g);
    //});
  }
}
