import java.util.Scanner;
//This ChatBot program shows how user input can be utilized by the "smart" chatbot to provide custom responses

public class ChatBot
{
  public static void main(String args[])
  {

    System.out.println("Hi there, I am a Chatbot. What's your name?");
    Scanner scan = new Scanner(System.in);
    String whatUserTypedInString = scan.nextLine();
    System.out.println("Hello " + whatUserTypedInString + ", nice chatting with you. What are some of your hobbies?");
    whatUserTypedInString = scan.nextLine();
    System.out.println("What a coincidence! " + whatUserTypedInString + " happen to be some of my hobbies as well.\nBy the way, how are you feeling today? (happy, confused, sad, or angry)");
    String mood = scan.nextLine();    
    
    //CALLING THE METHOD HERE
    getMood(mood); //call method for type void
    System.out.println("Well, I enjoyed our conversation very much. I need to go and recharge my batteries. Let's talk some other time. Have a great day!");
    
    scan.close(); //done with scanner, can now close it
  }//end of main
  
  
   public static void getMood(String mood){
    
    switch(mood.toUpperCase()){
      case "HAPPY":
        System.out.println("I am feeling happy as well! :)");
        //return ":)";
        break;
      case "SAD":
        System.out.println("Sorry to hear that :(");
        break;
      case "CONFUSED":
       System.out.println("Everyday is winding road, hang in there :?");
       break;
      case "ANGRY":
        System.out.println("I feel thy rage >:(");
        break;
        
      default:
        System.out.println("._.");
        break;
        
    } //end of method
  
  
  } //end of class
  
  
  
}