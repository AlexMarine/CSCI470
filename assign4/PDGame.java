////////////////////////////////////////////////////////////////////////////
//
//  Program:    PDGame.java
//
//  Author:     Alex Marine (z1863905)
//  Professor:  Dr. James Leon
//  Class:      CSCI 470
//  Date:       November 1, 2020
//
//  Goal of Program:
//    This class represents the game itself and controls the logic. It
//  contains an ArrayList for keeping the user history, another ArrayList
//  of strings for each of the possible CPU strategies, a GameStat null
//  reference object that when filled in will record the game's stats, a
//  Scanner, and an integer to determine the strategy the CPU will use.
//
///////////////////////////////////////////////////////////////////////////

import java.util.ArrayList; //Import the ArrayList class
import java.util.Scanner;   //Import the Scanner class
import java.io.File;        //Import the File class
import java.io.FileNotFoundException;
import java.io.*;

//Class that controls the logic of the Prisoner's Dilemma Game
public class PDGame
{
  //Initiailze GameStat object at 0 for new game
  GameStat gs1 = new GameStat(0, 0, 1);

  //Create wrapper class for int and set to 1
  Integer intPtr = 1;
  
  //Variable declaration
  int strat; //User selected strategy (1/2/3)
  Scanner fileScanner1; //Scanner to read from file
  ArrayList<Integer> UserHistory = new ArrayList<>();  //ArrayList for user's input
  
  //initialize variable to the round number
  int round = gs1.getRoundsPlayed();

  //Default Constructor of class
  public PDGame()
  {
    this.strat = 0;
  }

  //Constructor for input file
  public PDGame(String file)
  {
    //try to open the file
    try
    {
      //Open the file and set the Scanner to it
      File cpuInput = new File(file);
      fileScanner1 = new Scanner(cpuInput);
    }
    //catch if the file was not found
    catch (FileNotFoundException e)
    {
      //alert the user and end program
      System.out.println("ERROR: FILE NOT FOUND");
      System.exit(0);
    }
  }

  //Method that generates the CPU's decision based on strategy
  //selected. Determines the outcome based on the decisions, 
  //and updates the GameStat object
  public String playRound(int userDecision)
  {
    //variable declaration
    int cpuDecision; //decision for cpu (1/2)

    //Create an ArrayList of Integer and add intPtr to it
    ArrayList<Integer> IntList = new ArrayList<Integer>();
    IntList.add(intPtr);
	  
    //If user selected random CPU decisions
    if (strat == 1)
    {
      //Generate random decision for CPU between 1 and 2
      cpuDecision =(int)(Math.random() * 2 + 1);
    }
    //if user selected tit-for-tat
    else if (strat == 2)
    {
      //if the user hasn't made a decision yet
      if (UserHistory.isEmpty())
      {
        //set the cpu's decision to 1
        cpuDecision = 1;
      }
      //if the user has made a decision
      else
      {
	//set the cpu's decision to the user's last decision
        cpuDecision = UserHistory.get(UserHistory.size() - 1);
      }
    }
    //if user selected read from file
    else if (strat == 3)
    {
      //set the cpu decision to the next integer in the file
      cpuDecision = fileScanner1.nextInt();
    } 
    //if an invalid input was entered
    else
    {
      //Set generic start to random decision
      cpuDecision =(int)(Math.random() * 2 + 1);
    }

    //Add the user decision to the history ArrayList
    UserHistory.add(userDecision);
    
    //if both the user and cpu remain silent
    if (userDecision == 1 && cpuDecision == 1)
    {
      //add 2 to each score
      gs1.update(2, 2);

      //initialize variable for the results
      String output = "\nYou and your partner both remained silent.\n" + 
	      "You both get 2 years in prison.\n";

      //return the results
      return output;
    }
    //if the user betrayed but the cpu remained silent
    else if (userDecision == 2 && cpuDecision == 1)
    {
      //add 1 to the user and 5 to the cpu
      gs1.update(1, 5);

      //initialize variable for the results
      String output = "\nYou betrayed your partner while they remained silent.\n" + 
	      "You get 1 year in prison and your partner gets 5.\n";

      //return the results
      return output;
    }
    //if the user remained silent and the cpu betrayed
    else if (userDecision == 1 && cpuDecision == 2)
    {
      //add 5 to the user and 1 to the cpu
      gs1.update(5, 1);

      //initialize variable for the results
      String output = "\nYou remained silent while your partner betrayed you.\n" + 
	      "You get 5 years in prison while your partner gets 1.\n";

      //return the results
      return output;
    }
    //if both the user and the cpu betrayed
    else if (userDecision == 2 && cpuDecision == 2)
    {
      //add 3 to both scores
      gs1.update(3, 3);

      //initialize variable for the results
      String output = "\nYou and your partner betrayed each other.\n" + 
	      "You both get 3 years in prison.\n";

      //return the results
      return output;
    }
    //if there was an invalid input
    else
    {
      //add 0 to both scores
      gs1.update(0, 0);

      //inform the user of the error and return the otuput
      String output = "\nThere was an error.\n";
      return output;
    }

  } //End playRound method

  //Method to return the array list of the potential 
  //strategies of the CPU
  public ArrayList<String> getStrategies()
  {
    //Initialize Strings for strategies in ArrayList
    String str1 = "\nStrat 1: Randomly generated decisions.";
    String str2 = "Strat 2: Tit-For-Tat.";
    String str3 = "Strat 3: File input.\n";

    //Declare an ArrayList
    ArrayList<String> arrayList = new ArrayList<>();

    //Add strings to arrayList
    arrayList.add(str1);
    arrayList.add(str2);
    arrayList.add(str3);

    return arrayList;

  } //End getStrategies method

  //Method to return message of the final scores
  public String getScores()
  {
    //initialize variable to show the scores
    String scores = "The final scores! User: " + gs1.getUserScore() +
		    " CPU: " + gs1.getCpuScore() + "\n";

    //return the scores
    return scores;
  } //End getScores method

  //Method to return pointer to GameStat for current game
  public GameStat getStats()
  {
    return gs1;
  } //End getStats method

  //Method to set the strategy data member, and call the
  //GameStat setter with the string obtained from the
  //ArrayList at the appropriate index
  public void setStrategy(int strategy)
  {
    //Set the strategy
    strat = strategy;

  } //End setStrategy method
 
  //method to return the strategy selected
  public String getStrat()
  {
    //If strategy is set to random
    if (strat == 1)
    {
      //initialize variable for random
      String s1 = "CPU Strategy: Random";

      //return the string
      return s1;
    }
    //if strategy is set to tit-for-tat
    else if (strat == 2)
    {
      //initialize variable for tit-for-tat
      String s1 = "CPU Strategy: Tit-For-Tat";

      //return the string
      return s1;
    }
    //if strategy is set to file
    else if (strat == 3)
    {
      //initialize variable for file
      String s1 = "CPU Strategy: File Input";

      //return the string
      return s1;
    }
    //if something else has occured
    else
    {
      //initialize variable for error
      String s1 = "ERROR";

      //return the error
      return s1;
    }
  }

} //End PDGame class
