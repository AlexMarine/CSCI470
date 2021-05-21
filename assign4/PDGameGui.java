////////////////////////////////////////////////////////////////////////////
//
//  Program:    PDGameGui.java
//
//  Author:     Alex Marine (z1863905)
//  Professor:  Dr. James Leon
//  Class:      CSCI 470
//  Date:       November 1, 2020
//
//  Goal of Program:
//    This program creates a GUI that allows the user to play the
//  Prisoner's Dilemma game. The user will click on a strategy from the
//  combo box, then start the game. They can then choose between silent
//  or testify and the game will calculate the scores accordingly.
//
///////////////////////////////////////////////////////////////////////////

import java.util.ArrayList; //import the ArrayList class
import java.util.HashMap; //import the HashMap class
import java.util.Scanner; //import the Scanner class
import java.util.Date; //import the Date class
import java.text.SimpleDateFormat; //import the SimpleDateFormat class
import javax.swing.border.TitledBorder;  //import the TitledBorder class
import javax.swing.*; //import all swing classes
import java.awt.*;  //import all awt classes
import java.awt.event.*;  //import all awt.event classes

//Class that acts as an interface for our Prisoner's Dillema game
public class PDGameGui extends JFrame implements ActionListener
{
   //Create object for PDGameGui class
   static PDGameGui guiPtr = new PDGameGui();

   //Variable declaration for our GUI
   JButton newGameB;  //JButton that starts a new game
   JButton silentB;   //JButton that allows the user to remain silent
   JButton testifyB;  //JButton that allows the user to testify
   JComboBox<String> stratCB;  //ComboBox for the CPU strategy selection
   JTextArea textArea1;  //TextArea where the game is displayed

  //Method for allowing user to play Prisoner's Dilemma game
  public static void main(String args[])
  { 
    //Call method to create the GUI
    guiPtr.createGui();

  } //End main mathod

  //Method to start the game
  void gameStart()
  {
    //initialize String to file input name
    String file1 = "cpuInput.txt";

    //Initialize PDGame and GameStat objects
    PDGame currentGamePtr1 = new PDGame(file1);
    GameStat gameStatPtr = new GameStat(0, 0, 1);

    //variable declaration
    int cpuStrat = 0;  //holds the strategy the cpu will use
    int decision = 0;  //holds the user's decision to be silent or betray

    //Define a hashtbale to be filled with the date and a pointer to stat object
    HashMap<String, GameStat> hashMap1 = new HashMap<>();
      
    //Get pointer to gameStat object out of PDGame
    gameStatPtr = currentGamePtr1.getStats();

    //Fill in hashmap entry with current date/time and the gameStatPtr
    String d1 = new SimpleDateFormat("yyyy.MM.dd.mm.ss").format(new java.util.Date());
    hashMap1.put(d1, gameStatPtr);

    //Play 5 rounds: in each round get users choice, and call method
    for (int i = 1; i < 6; i++)
    {
      //Prompt user for decision and get their input
      String whatToDo = "Remain silent or Testify. What will you do?";
      textArea1.append(whatToDo);

      //Want the user to click silent or testify button
      //and call their functions depending on which is clicked

    }

    //Call getScores method to recieve the totals and who won and output it
    String scores = currentGamePtr1.getScores();
    textArea1.append(scores);

    //for each key in the hashMap
    for (String i : hashMap1.keySet())
    {
      //outout the key
      textArea1.append(i);
    
      //Initialize variable to value in hashMap and output it
      GameStat gs2 = hashMap1.get(i);
      textArea1.append(gs2.getWinner() + currentGamePtr1.getStrat());
    }

    //thank the user for playing
    String goodBye = "Thanks for playing!";
    textArea1.append(goodBye);
  }

  //method that creates the GUI for our game
  public void createGui()
  {
    //Set up the Frame
    JFrame frame1 = new JFrame();
    frame1.setTitle("Prisoner's Dilemma Game Gui");
    frame1.setSize(800, 300);
    frame1.setVisible(true);
    frame1.setLayout(new BorderLayout());

    //Set up the containter
    Container container1 = frame1.getContentPane();
    container1.setBackground(Color.black);

    //Set up panel1 in the WEST region of the frame
    JPanel panel1 = new JPanel();
    panel1.setLayout(new BorderLayout());
    panel1.setBackground(Color.blue);
    panel1.setPreferredSize(new Dimension(400, 300));
    container1.add(panel1, BorderLayout.WEST);

    //Set up panel2 in the EAST region of the frame
    JPanel panel2 = new JPanel();
    panel2.setBackground(Color.red);
    panel2.setPreferredSize(new Dimension(400, 300));
    container1.add(panel2, BorderLayout.EAST);

    //Set up panel3 in the SOUTH region of panel1
    JPanel panel3 = new JPanel();
    panel3.setLayout(new GridLayout(5, 2));
    panel3.setBackground(Color.green);
    panel3.setPreferredSize(new Dimension(100, 150));
    panel1.add(panel3, BorderLayout.SOUTH);

    //Set up list1 isnide scrollPane1 with a titled border in the NORTH region of panel1
    TitledBorder title1;
    title1 = BorderFactory.createTitledBorder("Session History");
    title1.setTitlePosition(TitledBorder.ABOVE_TOP);
    JList list1 = new JList();
    list1.setBackground(Color.cyan);
    JScrollPane scrollPane1 = new JScrollPane(list1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPane1.setPreferredSize(new Dimension(100, 150));
    scrollPane1.setBorder(title1);
    panel1.add(scrollPane1, BorderLayout.NORTH);

    //Set up panel4 in the NORTH region of panel2
    JPanel panel4 = new JPanel();
    panel4.setLayout(new GridLayout(2, 1));
    panel4.setBackground(Color.pink);
    panel4.setPreferredSize(new Dimension(400, 75));
    panel2.add(panel4, BorderLayout.NORTH);

    //Set up textArea1 inside scrollPane2 in the SOUTH region of panel2
    textArea1 = new JTextArea(15,35);
    textArea1.setBackground(Color.orange);    
    JScrollPane scrollPane2 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPane2.setPreferredSize(new Dimension(400, 225));
    panel2.add(scrollPane2, BorderLayout.SOUTH);

    //Set up panel5 & 6 with Flow layouts to panel4
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    panel5.setLayout(new FlowLayout());
    panel6.setLayout(new FlowLayout());
    panel5.setBackground(Color.magenta);
    panel6.setBackground(Color.yellow);
    panel4.add(panel5);
    panel4.add(panel6);

    //Add label6, newGameB, and comboBox1 to panel5
    JLabel label6 = new JLabel("Computer Strategy");
    newGameB = new JButton("Start new game");
    newGameB.addActionListener(this);
    String[] statString = {"Random", "Tit-For-Tat", "File"};
    stratCB = new JComboBox<String>(statString);
    stratCB.addActionListener(this);
    panel5.add(label6);
    panel5.add(stratCB);
    panel5.add(newGameB);

    //Add label7, silentB, and testifyB to panel6
    JLabel label7 = new JLabel("What will you do?");
    silentB = new JButton("Remain Silent");
    silentB.addActionListener(this);
    testifyB = new JButton("Testify");
    testifyB.addActionListener(this);
    panel6.add(label7);
    panel6.add(silentB);
    panel6.add(testifyB);

    //Add label1-5 and textField1-5 to panel3
    JLabel label1 = new JLabel("Rounds Played");
    JTextField textField1 = new JTextField();
    JLabel label2 = new JLabel("Computer Strategy");
    JTextField textField2 = new JTextField();
    JLabel label3 = new JLabel("Player Sentence");
    JTextField textField3 = new JTextField();
    JLabel label4 = new JLabel("Computer Sentence");
    JTextField textField4 = new JTextField();
    JLabel label5 = new JLabel("Winner");
    JTextField textField5 = new JTextField();
    panel3.add(label1);
    panel3.add(textField1);
    panel3.add(label2);
    panel3.add(textField2);
    panel3.add(label3);
    panel3.add(textField3);
    panel3.add(label4);
    panel3.add(textField4);
    panel3.add(label5);
    panel3.add(textField5);
  }

  //method that calls other methods based on what was clicked
  public void actionPerformed(ActionEvent e)
  {
    //If item is selected, call corresponding method
    if (e.getSource() == newGameB) { startGame(); }
    else if (e.getSource() == silentB) { remainSilent(); }
    else if (e.getSource() == testifyB) { testify(); }
    else if (e.getSource() == stratCB) { selectStrat(); }
  }

  //method to start a game of PD
  public void startGame()
  {
    //Show string in text area
    String newGame = "New game will start!";
    textArea1.append(newGame);

    //call method to start a new game
    guiPtr.gameStart();
  }

  //method if the user remain silent
  public void remainSilent()
  {
    //initialize object for PDGame
    PDGame gamePtr = new PDGame();

    //get result of round and inform user
    String result = gamePtr.playRound(1);
    textArea1.append(result);
  }

  //method if the user testified
  public void testify()
  {
    //initialize objct for PDGame
    PDGame gamePtr = new PDGame();

    //get result pf round and inform user
    String result = gamePtr.playRound(2);
    textArea1.append(result);
  }

  //method to pick the strategy of the CPU
  public void selectStrat()
  {
    //initialize object for PDGame
    PDGame currentGamePtr1 = new PDGame();

    //set variable to what was selected in ComboBox
    Object selected = stratCB.getSelectedItem();

    //Set the strategy to whatever strat the user selected, default to random
    if (selected.toString().equals("Random")) { currentGamePtr1.setStrategy(1); }
    else if (selected.toString().equals("Tit-For-Tat")) { currentGamePtr1.setStrategy(2); }
    else if (selected.toString().equals("File")) { currentGamePtr1.setStrategy(3); }
    else { currentGamePtr1.setStrategy(1); } 
  }
}
