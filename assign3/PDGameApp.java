
////////////////////////////////////////////////////////////////////////////
//
//  Program:    PDGameApp.java
//
//  Author:     Alex Marine (z1863905)
//  Professor:  Dr. James Leon
//  Class:      CSCI 470
//  Date:       September 30, 2020
//
//  Goal of Program:
//    This program provides an interface for user input. Within the main(),
//  there's a Scanner to retireve the input from the user, a PDGame object 
//  that controls the play of each game, and a HashMap to store the
//  GameStat objects from each PDGame.
//
///////////////////////////////////////////////////////////////////////////

import java.util.ArrayList; //import the ArrayList class
import java.util.HashMap; //import the HashMap class
import java.util.Scanner; //import the Scanner class
import java.util.Date; //import the Date class
import java.text.SimpleDateFormat; //import the SimpleDateFormat class

//Class that acts as an interface for our Prisoner's Dillema game
class PDGameApp
{
  //Method for allowing user to play Prisoner's Dilemma game
  public static void main(String args[])
  {
    //Scanner declaration for user input
    Scanner scan1 = new Scanner(System.in);

    //Declare PDGame and GameStat objects to fill in later
    PDGame currentGamePtr1 = null;
    GameStat gameStatPtr = null;

    //variable declaration
    int cpuStrat = 0;  //holds the strategy the cpu will use
    int decision = 0;  //holds the user's decision to be silent or betray

    //Define a hashtbale to be filled with the date and a pointer to stat object
    HashMap<String, GameStat> hashMap1 = new HashMap<>();

    //Force into loop to get a session going
    boolean playSession = true;

    //Continue while playSession is true
    while (playSession == true)
    {
      //initialize our objects
      currentGamePtr1 = new PDGame();
      gameStatPtr = new GameStat(0, 0, 1);

      //"Get" pointer to Strategy ArrayList in PDGame
      ArrayList<String> strategieArrayList = currentGamePtr1.getStrategies();

      //For loop to go through each entry in ArrayList
      for (String strat:strategieArrayList)
      {
        //Output the contents of the ArrayList
	System.out.println(strat);
      }

      //try to get the user's input for cpu strategy
      try
      {
        //Prompt the user to Set the strategy and get their input
        System.out.println("What strategy would you like the CPU to use? ");
        cpuStrat = scan1.nextInt();
      }
      //catch if the number is out of range
      catch (IllegalArgumentException e)
      {
        //inform the user of the exception
	System.out.println("EXCEPTION: ARGUMENT OUT OF RANGE\n");
      }

      //Call setStrategy to initialize cpuStrat
      currentGamePtr1.setStrategy(cpuStrat);
      
      //Get pointer to gameStat object out of PDGame
      gameStatPtr = currentGamePtr1.getStats();

      //Fill in hashmap entry with current date/time and the gameStatPtr
      String d1 = new SimpleDateFormat("yyyy.MM.dd.mm.ss").format(new java.util.Date());
      hashMap1.put(d1, gameStatPtr);
      
      //Inform user of the start of the game
      System.out.println("Game Start!\n");

      //Play 5 rounds: in each round get users choice, and call method
      for (int i = 1; i < 6; i++)
      {
	//try to get the user's input for decision
	try
	{
          //Prompt user for decision and get their input
	  System.out.println("Round " + i + ": Remain silent (1) or Betray (2)? ");
	  decision = scan1.nextInt();
	}
	//catch if the input is out of range
	catch (IllegalArgumentException e)
	{
          //inform the user of the exception
          System.out.println("EXCEPTION: ARGUMENT OUT OF RANGE\n");
	}

        //Play round, get back string about outcome of round
        String result = currentGamePtr1.playRound(decision);

	//Output results of the round
	System.out.println(result);
      }

      //Call getScores method to recieve the totals and who won and output it
      String scores = currentGamePtr1.getScores();
      System.out.println(scores);
	
      //Ask the user if the want to keep playing and get their input
      scan1.nextLine(); //dummy space
      System.out.println("Would you like to play another game? (Y/N) ");
      String yOrN = scan1.nextLine();

      //If user answers no, end the current session
      if (yOrN.equals("N") || yOrN.equals("n")) 
      { 
        //inform the user about the stats
        System.out.println("Stats of this session: \n");
        
	//for each key in the hashMap
	for (String i : hashMap1.keySet())
	{
          //outout the key
	  System.out.println(i);

	  //Initialize variable to value in hashMap and output it
	  GameStat gs2 = hashMap1.get(i);
	  System.out.println(gs2.getWinner() + currentGamePtr1.getStrat() + "\n");
	}

	//thank the user for playing
	System.out.println("Thanks for playing!\n");

	//set the playSession to false to end loop
        playSession = false;
      }
      //if the user didn't select no
      else
      {
	//inform the user that the game will restart
        System.out.println("A new game will start!\n");
      }

    } //End while loop

  } //End main mathod

} //End PDGameApp class
