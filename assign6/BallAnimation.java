////////////////////////////////////////////////////////////////////////////
//
//  Program:    BallAnimation.java
//
//  Author:     Alex Marine (z1863905)
//  Professor:  Dr. James Leon
//  Class:      CSCI 470
//  Date:       December 4, 2020
//
//  Goal of Program:
//    This program creates two JPanels for the area the will have the ball
//  animations, and the other for a start and stop button. When the
//  buttons are clicked, call the methods from the AnimationPanel class.
//
///////////////////////////////////////////////////////////////////////////

import java.awt.*; //import all awt classes
import java.awt.event.*; //import all awt.event classes
import javax.swing.*; //import all swing classes

//class to add JPanels and JButtons to GUI
public class BallAnimation extends JPanel implements ActionListener
{
  //initialize object of tybe AnimationPanel
  AnimationPanel animePanelPtr = new AnimationPanel();

  //declare start and stop buttons
  JButton startB;
  JButton stopB;

  //initialize JPanels
  JPanel ballPanel = new JPanel();
  JPanel snsPanel = new JPanel();

  //default constructor to set up layout and adds listeners for buttons
  public BallAnimation()
  {
    //initialize startB and stopB and add to panel
    startB = new JButton("Start");
    startB.addActionListener(this);
    snsPanel.add(startB);
    stopB = new JButton("Stop");
    stopB.addActionListener(this);
    snsPanel.add(stopB);

    //add pointer to AnimationPanel to ballPanel
    ballPanel.add(animePanelPtr);
  }

  //method to create and get the ball JPanel
  public JPanel ballPanel()
  {
    //Initialize JPanel to cover the east region of the frame
    ballPanel.setBackground(Color.white);
    ballPanel.setPreferredSize(new Dimension(250, 300));
    ballPanel.setLayout(new BorderLayout());

    //return the JPanel
    return ballPanel;
  }

  //method to create and get the sns JPanel
  public JPanel snsPanel()
  {
    //initialize JPanel for start and stop buttons in south region
    snsPanel.setBackground(Color.gray);
    snsPanel.setPreferredSize(new Dimension(250, 40));

    //return the JPanel
    return snsPanel;
  }

  //put in listener method for button clicks
  public void actionPerformed(ActionEvent e)
  {
    //if startB is clicked
    if (e.getSource() == startB)
    {
      //call start method from AnimationPanel
      animePanelPtr.start();
    }
    //if stopB is clicked
    else if (e.getSource() == stopB)
    {
      //call stop method from AnimationPanel
      animePanelPtr.stop();
    }
  }
}
