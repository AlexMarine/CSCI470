////////////////////////////////////////////////////////////////////////////
//
//  Program:    GraphicsFrame.java
//
//  Author:     Alex Marine (z1863905)
//  Professor:  Dr. James Leon
//  Class:      CSCI 470
//  Date:       December 4, 2020
//
//  Goal of Program:
//    Program that creates JFrame for our GUI. Calls MainPanel and puts
//    5 panels onto JFrame.
//
///////////////////////////////////////////////////////////////////////////

import java.awt.*;  //import all awt classes
import java.awt.event.*;  //import all awt.event classes
import javax.swing.*;  //import all swing classes

public class GraphicsFrame extends JFrame
{
  //Initialize objects of our classes
  MainPanel mainPanelPtr = new MainPanel();
  BallAnimation ballAnimePtr = new BallAnimation();
  AnimationPanel animePanelPtr = new AnimationPanel();
  static GraphicsFrame graphicsFramePtr = new GraphicsFrame();
  static TileGridPanel tileGridPanelPtr = new TileGridPanel();

  //Initialize JFrame
  JFrame frame = new JFrame();

  //main method
  public static void main(String args[])
  {
    //Call method to create our GUI
    graphicsFramePtr.createAndShowGui();
  }

  //default constructor
  public GraphicsFrame()
  {
    //call super
    super();

    //JPanel to cover the West region of frame
    JPanel mainPanel = mainPanelPtr.mainPanel();
    frame.add(mainPanel, BorderLayout.WEST);

    //JPanel to cover east region of frame
    JPanel ballPanel = ballAnimePtr.ballPanel();
    frame.add(ballPanel, BorderLayout.EAST);

    //JPanel to for start and stop buttons in south region
    JPanel snsPanel = ballAnimePtr.snsPanel();
    ballPanel.add(snsPanel, BorderLayout.SOUTH);

    //JPanel for toolbar in north region
    JPanel northPanel = mainPanelPtr.northPanel();
    mainPanel.add(northPanel, BorderLayout.NORTH);

    //JPanel for drawing area of GUI in center of panel
    JPanel centerPanel = mainPanelPtr.centerPanel();
    mainPanel.add(centerPanel, BorderLayout.CENTER);

    //JPanel for repaint JButton in south region
    JPanel southPanel = mainPanelPtr.southPanel();
    mainPanel.add(southPanel, BorderLayout.SOUTH);
  }

  //call method to create and siplay the frame of our GUI
  public void createAndShowGui()
  {
    //set the title and size of our frame and set visible to true
    frame.setTitle("Assignment 6");
    frame.setSize(500, 300);
    frame.setVisible(true);
  }
}
