////////////////////////////////////////////////////////////////////////////
//
//  Program:    TileGridPanel.java
//
//  Author:     Alex Marine (z1863905)
//  Professor:  Dr. James Leon
//  Class:      CSCI 470
//  Date:       December 4, 2020
//
//  Goal of Program:
//    This program use a mouse listener to know when the user clicks on a
//  patch button, and then click on the center panel to print a 5 x 5 array
//  of an image to the center panel. When the user clicks the reset button,
//  the array is filled with null, effectivaly erasing the image that was
//  painted to the screen.
//
///////////////////////////////////////////////////////////////////////////

import java.awt.*;  //import all awt classes
import java.awt.event.*;  //import all awt.event classes
import javax.swing.*;  //import all swing classes

//class to fill array with the image selected, or null
class TileGridPanel extends JPanel implements MouseListener
{
  //initialize variables
  int selectedTile = -1; //number for tile selcted
  static final int squareSide = 25;
  int gridRow = 5; //number of rows in grid
  int gridCol = 5; //number of columns in grid

  //we take gifs in here and draw in tilegrid
  Image[][] gif2dArray = new Image[gridRow][gridCol];

  //method to clear our array
  public void ResetGridTile()
  {
    //use in/out loop to set all to null
    for (int i = 0; i < gridRow; i++)
    {
      for (int j = 0; j < gridCol; j++)
      {
	//fill the array with null
        gif2dArray[i][j] = null;
      }
    }
    //draw empty grid
    this.repaint();
  }

  //adds mouselistener to center panel, need mouse methods at bottom
  public TileGridPanel()
  {
    //add a mouse listener for mouse clicks
    addMouseListener(this);
  }

  @Override
  //user has clicked a tile on panel, now has clicked in the center panel
  public void mouseClicked(MouseEvent e)
  {
    //initialize object for MainPanel
    MainPanel mainPanelPtr = new MainPanel();

    //code a loop to fill the gif2darray with the selected image out of MainPanel.imageA[]
    for (int i = 0; i < gridRow; i++)
    {
      for (int j = 0; j < gridCol; j++)
      {
	//fill the array with the image selected
        gif2dArray[i][j] = mainPanelPtr.imageA[selectedTile];
      }
    }

    //show new grid with your image from 2d array
    this.repaint();
  }

  //method for mouse exit, do nothing
  @Override
  public void mouseExited(MouseEvent e) { }

  //method for mouse entered, do nothing
  @Override
  public void mouseEntered(MouseEvent e) { }

  //method for mouse pressed, do nothing
  @Override
  public void mousePressed(MouseEvent e) { }

  //method for mouse released, do nothing
  @Override
  public void mouseReleased(MouseEvent e) { }

  //paints the center panel with elements in 2Darray
  @Override
  public void paintComponent(Graphics g)
  {
    //call base constructor
    super.paintComponent(g);

    //need to find center area of the center panel
    int gridWidth = gridCol * squareSide;
    int gridHeight = gridRow * squareSide;
    int panelWidth = getWidth();
    int panelHeight = getHeight();

    //get starting point to draw grid based
    int startX = (panelWidth - gridWidth) / 2;
    int startY = (panelHeight - gridHeight) / 2;
    
    //copy gif image array over to the drawing grid with inner outer loop
    for (int i = 0; i < gridRow; i++)
    {
      for (int j = 0; j < gridCol; j++)
      {
    	//draw the image in the array to the panel
        g.drawImage(gif2dArray[i][j], startX + (squareSide * i),
    		  startY + (squareSide * j), this);
      }
    }
  }
}
