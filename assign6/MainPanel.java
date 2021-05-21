////////////////////////////////////////////////////////////////////////////
//
//  Program:    MainPanel.java
//
//  Author:     Alex Marine (z1863905)
//  Professor:  Dr. James Leon
//  Class:      CSCI 470
//  Date:       December 4, 2020
//
//  Goal of Program:
//    Program that creates JPanels to add to the JFrame. Add buttons to a
//  toolbar that user can click on and add that to the north panel. Add
//  reset button to the south panel. Add mouse listener to center panel to
//  read in mouse clicks.
//
///////////////////////////////////////////////////////////////////////////

import java.awt.*;  //import all awt classes
import java.awt.event.*;  //import all awt.event classes
import javax.swing.*;  //import all swing classes

public class MainPanel extends JPanel implements ActionListener
{
  //String array of images for toolbar
  String[] imageStringNameA = {"pat1[1].gif", "pat2[1].gif", "pat3[1].gif", "pat4[1].gif", "pat5[1].gif"};

  //image arr holds 5 images we load using toolkit code
  final static Image[] imageA = new Image[5];

  //pointer to toolbar for main panel
  JToolBar tileToolBar = new JToolBar();
  //pointer to area where we will paint items on a tile grid
  TileGridPanel tileGridPanelPtr = new TileGridPanel();

  //declare 5 buttons for images and a reset button
  JButton patch0B;
  JButton patch1B;
  JButton patch2B;
  JButton patch3B;
  JButton patch4B;
  JButton resetB;

  //initialize JPanel for toolbar
  JPanel northPanel = new JPanel();
  JPanel centerPanel = new JPanel();
  JPanel southPanel = new JPanel();

  public MainPanel()
  {
    //code the toolkit that I have shown earlier that loads images into the one dimensional imageA
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    for(int i = 0; i < imageA.length; i++)
    {
      imageA[i] = (Image) Toolkit.getDefaultToolkit().getImage(imageStringNameA[i]);
    }

    //we will add items to north, center, and south on main panel
    this.setLayout(new BorderLayout());

    //prepare north area on main panel, this is how you get a button with an image
    patch0B = new JButton(new ImageIcon(imageA[0]));
    patch1B = new JButton(new ImageIcon(imageA[1]));
    patch2B = new JButton(new ImageIcon(imageA[2]));
    patch3B = new JButton(new ImageIcon(imageA[3]));
    patch4B = new JButton(new ImageIcon(imageA[4]));

    //add buttons to toolbar
    tileToolBar.add(patch0B);
    tileToolBar.add(patch1B);
    tileToolBar.add(patch2B);
    tileToolBar.add(patch3B);
    tileToolBar.add(patch4B);

    //set up buttons for listening
    patch0B.addActionListener(this);
    patch1B.addActionListener(this);
    patch2B.addActionListener(this);
    patch3B.addActionListener(this);
    patch4B.addActionListener(this);

    //add toolbar to the north panel
    northPanel.add(tileToolBar);

    //add a pointer to TileGridPanel to the center panel
    centerPanel.add(tileGridPanelPtr);
    centerPanel.addMouseListener(tileGridPanelPtr);

    //Initialize resetB and add to panel
    resetB = new JButton("Reset");
    resetB.addActionListener(this);
    southPanel.add(resetB);
  }

  //method to create and get the main JPanel
  public JPanel mainPanel()
  {
    //Initialize JPanel to cover the west region of the frame
    JPanel mainPanel = new JPanel();
    mainPanel.setBackground(Color.cyan);
    mainPanel.setPreferredSize(new Dimension(250, 300));
    
    //return the JPanel
    return mainPanel;
  }

  //method to create and get the north JPanel
  public JPanel northPanel()
  {
    //Initialize JPanel for north region
    northPanel.setBackground(Color.orange);
    northPanel.setPreferredSize(new Dimension(250, 40));

    //return the JPanel
    return northPanel;
  }

  //method to create and get the center JPanel
  public JPanel centerPanel()
  {
    //Initialize JPanel for center region
    centerPanel.setBackground(Color.yellow);
    centerPanel.setPreferredSize(new Dimension(250, 220));

    //return the JPanel
    return centerPanel;
  }

  //method to create and get the south JPanel
  public JPanel southPanel()
  {
    //Initialize JPanel for south region
    southPanel.setBackground(Color.red);
    southPanel.setPreferredSize(new Dimension(250, 40));

    //return the JPanel
    return southPanel;
  }
  
  //put in listener method for button clicks on toolbar
  public void actionPerformed(ActionEvent e)
  {
    //if button0 clicked in toolbar
    if (e.getSource() == patch0B)
    {
      //set the variable in tileGridPanel object
      tileGridPanelPtr.selectedTile = 0;
    }
    //if button1 clicked in toolbar
    else if (e.getSource() == patch1B)
    {
      //set the variable in tileGridPanel object
      tileGridPanelPtr.selectedTile = 1;
    }
    //if button2 clicked in toolbar
    else if (e.getSource() == patch2B)
    {
      //set the variable in tileGridPanel object
      tileGridPanelPtr.selectedTile = 2;
    }
    //if button3 clicked in toolbar
    else if (e.getSource() == patch3B)
    {
      //set the variable in tileGridPanel object
      tileGridPanelPtr.selectedTile = 3;
    }
    //if button4 clicked in toolbar
    else if (e.getSource() == patch4B)
    {
      //set the variable in tileGridPanel object
      tileGridPanelPtr.selectedTile = 4;
    }
    //if resetB is clicked
    else if (e.getSource() == resetB)
    {
      //call method to set array to null
      tileGridPanelPtr.ResetGridTile();
    }
  }
}
