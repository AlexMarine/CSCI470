////////////////////////////////////////////////////////////////////////////
//
//  Program:    PDGame.java
//
//  Author:     Alex Marine (z1863905)
//  Professor:  Dr. James Leon
//  Class:      CSCI 470
//  Date:       September 30, 2020
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
import java.util.Scanner;   //Import for Scanner class
import java.io.*;

//Class that controls the logic of the Prisoner's Dilemma Game
public class PDGame
{
  //Initiailze GameStat object at 0 for new game
  GameStat gs1 = new GameStat(0, 0, 1);
  
  //Variable declaration
  int strat; //User selected strategy (1/2/3)
  Scanner fileScanner1 = null; //Scanner to read from file
  
  //initialize variable to the round number
  int round = gs1.getRoundsPlayed();

  //Method that generates the CPU's decision based on strategy
  //selected. Determines the outcome based on the decisions, 
  //and updates the GameStat object
  public String playRound(int userDecision)
  {
    //variable declaration
    int cpuDecision; //decision for cpu (1/2)

    //Create wrapper class for int and set to 1
    Integer intPtr = 1;

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
      //add the user's decision to the arraylist
      IntList.add(userDecision);

      //set the cpu's decision to the user's last choice
      cpuDecision = IntList.get(round - 1);
    }
    //if user selected read from file
    else if (strat == 3)
    {
      //try to open the file
      try
      {
	//read the file and scan it for inputs
        File file1 = new File("cpuInput.txt");
	fileScanner1 = new Scanner(file1);
	int cpu1 = fileScanner1.nextInt();
	int cpu2 = fileScanner1.nextInt();
	int cpu3 = fileScanner1.nextInt();
	int cpu4 = fileScanner1.nextInt();
	int cpu5 = fileScanner1.nextInt();

	//set the cpu's decision to the corresponding input
	if (round == 1) { cpuDecision = cpu1; }
	else if (round == 2) { cpuDecision = cpu2; }
	else if (round == 3) { cpuDecision = cpu3; }
	else if (round == 4) { cpuDecision = cpu4; }
	else if (round == 5) { cpuDecision = cpu5; }
	else { cpuDecision = 1; }
	
	//close the file
	fileScanner1.close();
      }
      //if the file was not found
      catch (FileNotFoundException e)
      {
	//return exception and set cpu decision to 1
        System.out.println("The file was not found");
	cpuDecision = 1;
      }
    } 
    //if an invalid input was entered
    else
    {
      //throw exception
      throw new IllegalArgumentException("Invalid input");
    }
    
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
      //throw exception
      throw new IllegalArgumentException("Invalid input");
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
