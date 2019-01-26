/*
 This program shows students how operations in Java can be used to make a digital calculator
 */

import java.util.Scanner;

public class InteractiveCalculator
{
  public static void main(String[] args){ 

    Scanner scan = new Scanner(System.in);
    double number1 = 0;
    double number2 = 0;
    String operand = "";
    
    //while loop continues looping the program until the user  enters "q" to quit the program)
    while (operand != "q"){
      System.out.println("\n********** INTERACTIVE CALCULATOR PROGRAM  **********");

      //Number 1
      System.out.println("\nPlease enter the first number: ");
      //tests if the user has entered a valid integer or not.
      try{
        number1 = scan.nextInt();
      }
      catch (Exception e){
        System.out.println(e.toString());
        System.out.println("ERROR INVALID INPUT: PROGRAM TERMINATING.");
        System.exit(0);
      }
      System.out.println("You've entered: " + number1);

      //Number 2
      System.out.println("\nPlease enter the second number: ");
      try{
        number2 = scan.nextInt();
      }
      catch (Exception e){
        System.out.println(e.toString());
        System.exit(0);
      }
      
      scan.nextLine();
      System.out.println("You've entered: " + number2);

      //Get the desired operation
      System.out.println("\nWhat operation would you like to perform? (+,-,/,*,%,^): ");
      operand = scan.nextLine().toLowerCase();

      //determine if the user has provided correct input for the operation. 
      //If the input is incorrect, the program is terminated.
      if ((operand.equals("+")) || (operand.equals("-")) || (operand.equals("/")) || (operand.equals( "*" )) || (operand.equals( "%" )) || (operand.equals( "^" )) || (operand.equals( "q" ))){
        System.out.println("You've entered: "   +   operand   );
        //addition function
        if (operand.equals("+")){
          System.out.println("\n$$$$$$$$$$ The answer of the calculation is: " + number1 + " + " + number2 + " = " + (number1 + number2) + " $$$$$$$$$$");
          System.out.println("\nTHE CALCULATION HAS COMPLETED!"); 
        }
        
        //subtraction function
        else if (operand.equals("-")){
          System.out.println("\n$$$$$$$$$$ The answer of the calculation is: "   +  number1 + " - " + number2 + " = " + (number1 - number2) + " $$$$$$$$$$");
          System.out.println("\nTHE CALCULATION HAS COMPLETED!");
        }
        
        //division function
        else if (operand.equals("/")){
          System.out.println("\n$$$$$$$$$$ The answer of the calculation is: "   + number1 + " /  " + number2 + " = " + (number1 / number2) + " $$$$$$$$$$");
        }
        
        //multiplication function
        else if(operand.equals("*")){
          System.out.println("\n$$$$$$$$$$ The answer of the calculation is:  " + number1 + " * " + number2 + " = " + (number1 * number2) + " $$$$$$$$$$");
          System.out.println("\nTHE CALCULATION HAS COMPLETED!");
        }
        
        //modulus function
        else if(operand.equals("%")){
          System.out.println("\n$$$$$$$$$$ The answer of the calculation is:  " + number1 + " % " + number2 + " = " +  (number1 % number2)   +   " $$$$$$$$$$"   );
          System.out.println("\nTHE CALCULATION HAS COMPLETED!");
        }
        
        //exponential function
        else if(operand.equals("^")){
          System.out.println("\n$$$$$$$$$$ The answer of the calculation is:  " + number1 + " ^ " + number2 + " = " + (Math.pow(number1,number2)) + " $$$$$$$$$$");
          System.out.println("\nTHE CALCULATION HAS COMPLETED!");
        }
        
        //quits the program if the user inputs 'q'
        else if(operand.equals("q")){
          System.out.println("Quitting program...");
          System.exit(0);
        }
      }
      //terminates the program if the user enters an incorrect input
      else{
        System.exit(0);
      }
      
    }
    scan.close(); //close the scanner
  }
}