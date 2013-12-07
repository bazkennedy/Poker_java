import java.util.*;
public class week4
{
  public static void main(String[] args)
  {
 int deckSize = 52;
 int winType = 0;
 String userMessage = "";
   int[] cards = new int[deckSize];
  for(int i=0; i < deckSize; i++){
    cards[i]=i;
  }
  int[] suits = new int[deckSize];
  int[] values = new int[deckSize];
  int[] hand = new int[5];
  
	generateHand(hand,deckSize);		//Generating the 5 random unique numbers 
  
	determineSuitsAndValues(hand,suits,values); //determine Suits And Values
  
	sort(values);						//Sorting Algoritim 
	
	winType = evaluateHandOfCards(hand,suits,values); //evaluates the hand
    
	displayHand(hand,values,suits); 	//Displaying the cards	
	
	displayTypeOfWinIfAny(winType);   //Display the winning type
	
  }

  //Sorting Algoritim 
  public static void sort(int values[]){
 
  boolean swapped = true;
	int tmp;
			while(swapped){
				swapped = false;
				
				for(int i=1;i <= 4;i++){
					
					if((values[i-1]) < (values[i])) {
						tmp = values[i-1];
						values[i-1] = values[i];
						values[i] = tmp;
						swapped = true;
					
					}
					
				}}
  
  }
  
    
  public static void generateHand(int hand[],int deckSize){
     int uniqueNumbersRequired = 5;
   int aRandomNumber;
   int index = 0;
   int duplicateIndex;

   while (index < uniqueNumbersRequired)
    {
	  aRandomNumber = (int) (Math.random() * deckSize);
	  hand[index] = aRandomNumber;

      duplicateIndex = 0;

      while (hand[duplicateIndex] != aRandomNumber)
        duplicateIndex++;

      if (index == duplicateIndex)
        index++;
    }
	}

	public static void determineSuitsAndValues(int [] hand, int [] suits, int [] values)  {
    for (int i = 0; i < hand.length; i++)
	{
	  suits[i]  = hand[i] / 13;
	  values[i] = hand[i] % 13;
    }
  }	
	
	
    //Displaying the cards	
public static void displayHand(int hand[],int values[],int suits[]){
for (int i = 0; i < hand.length; i++)
	{
	switch(values[i])  
	  {
		case 0:  System.out.print("Two of ");   break;
	    case 1:  System.out.print("Three of "); break;
	    case 2:  System.out.print("Four of ");  break;
	    case 3:  System.out.print("Five of ");  break;
	    case 4:  System.out.print("Six of ");   break;
	    case 5:  System.out.print("Seven of "); break;
	    case 6:  System.out.print("Eight of "); break;
	    case 7:  System.out.print("Nine of ");  break;
	    case 8:  System.out.print("Ten of ");   break;
	    case 9:  System.out.print("Jack of ");  break;
        case 10: System.out.print("Queen of "); break;
        case 11: System.out.print("King of ");  break;
        case 12: System.out.print("Ace of ");   break;
      }
      switch(suits[i])
	  {
		case 0:  System.out.print("Hearts\n");    break;
	    case 1:  System.out.print("Clubs\n"); break;
	    case 2:  System.out.print("Spades\n");   break;
	    case 3:  System.out.print("Diamonds\n");   break;
      }
    } 
      }
  
public static int evaluateHandOfCards(int[] hand, int[] suits, int[] values)
  {
    int winType = 0;  
    if (cardsOfSameSuit(suits))
    {
      if (cardsInConsecutiveDescendingSequence(hand, values))
      {
        if (values[0] == 12) winType = 9;
        else                 winType = 8;
      }
      else                   winType = 7;
    }
    else
    {
      if (cardsInConsecutiveDescendingSequence(hand, values)) 
	    winType = 5;
      else 
	    winType = checkOtherPossibleCombinations(hand, values);  
    }	 
    	return winType;
  }
  
  public static boolean cardsOfSameSuit(int suits[])
  {
    boolean sameSuit = true;
    for (int i = 0; (i < suits.length - 1) && sameSuit; i++)
      if (suits[i] != suits[i + 1])
        sameSuit = false;
   	return sameSuit;
  } 

  public static boolean cardsInConsecutiveDescendingSequence(int hand[],int values[])
  {
    boolean consecutiveCards = true;
    for (int i = 0; i < hand.length - 1 && consecutiveCards; i++)
      if (values[i] != values[i + 1] + 1)
        consecutiveCards = false;
   
   	return consecutiveCards;
  } 
  
  public static int checkOtherPossibleCombinations(int[] hand, int[] values)
  {
    boolean continueCardComparison;
    int sameKind = 0;
    for (int i = 0; (i < hand.length - 1); i++)
    {
      continueCardComparison = true;
      for (int j = i + 1; j < values.length && continueCardComparison; j++)
      {
        if (values[i] == values[j])
          sameKind++;
        else
          continueCardComparison = false;
      } 
    } 
    return sameKind;
  } 
 
  public static void displayTypeOfWinIfAny(int winType)
  {
	switch(winType)
	{
       case 0: System.out.println("Not a winning hand"); break; 
      case 1: System.out.println("One pair");           break; 
      case 2: System.out.println("Two pair");           break; 
      case 3: System.out.println("Three of a kind");    break; 
      case 4: System.out.println("Full house");         break; 
      case 5: System.out.println("Straight");           break; 
      case 6: System.out.println("Four of a kind");     break; 
      case 7: System.out.println("Flush");              break; 
      case 8: System.out.println("Straight flush");     break; 
      case 9: System.out.println("Royal flush");        break; 
    } 
  } 
    
  
  }