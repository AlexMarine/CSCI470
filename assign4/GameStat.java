////////////////////////////////////////////////////////////////////////////
//
//  Program:    GameStat.java
//
//  Author:     Alex Marine (z1863905)
//  Professor:  Dr. James Leon
//  Class:      CSCI 470
//  Date:       November 1, 2020
//
//  Goal of Program:
//    This program uses the GameStat class to keep track of multiple
//  statistics during the Prisoner's Dilemma game. It has methods to
//  return the CPU's strategy, update the game's scores, and return the
//  person who won the game, the user or the CPU.
//
///////////////////////////////////////////////////////////////////////////

//Class that keeps track of various statistics of the
//Prisoner's Dilemma game
public class GameStat
{
  //Variable declaration
  private int userYears;   //Number of years the user has
  private int cpuYears;    //Number of years the cpu has
  private int roundsPlayed; //Counts the number of rounds played

  //Constructor to initialize variables
  public GameStat(int uYears, int cYears, int rPlayed)
  {
    //initialize the variables
    this.userYears = uYears;
    this.cpuYears = cYears;
    this.roundsPlayed = rPlayed;

  } //end constructor

  //Method to increment the stats and is called from PDGame
  public void update(int userSentence, int cpuSentence)
  {
    //add new scores to the totals for user and CPU and add 1 to round
    userYears += userSentence;
    cpuYears += cpuSentence;
    roundsPlayed += 1;

  } //End update method

  //Method that returns the winner of the game by comparing
  //the scores of the user and CPU
  public String getWinner()
  {
    //variable declaration
    String result;  //result of who won the game

    //if the game is a tie
    if (userYears == cpuYears)
    {
      //initialize the string for the tie
      result = "This game is a tie.\n";

      //return the result
      return result;
    }
    //if the user wins
    else if (userYears < cpuYears)
    {
      //initialize the string for the win
      result = "This game's winner is the user!\n";

      //return the result
      return result;
    }
    //if the cpu wins
    else if (userYears > cpuYears)
    {
      //initialize the variable for the loss
      result = "This game's winner is the CPU!\n";

      //return the result
      return result;
    }
    //if something else happened
    else
    {
      //initialize the string for the error
      result = "ERROR";

      //return the error
      return result;
    }

  } //End getWinner method

  //method to return the user's score
  public int getUserScore()
  {
    //return the user's score
    return userYears;
  }

  //method to return the cpu's score
  public int getCpuScore()
  {
    //return the cpu's score
    return cpuYears;
  }

  //method to return the rounds played
  public int getRoundsPlayed()
  {
    //return the rounds played
    return roundsPlayed;
  }

} //End GameStat class
