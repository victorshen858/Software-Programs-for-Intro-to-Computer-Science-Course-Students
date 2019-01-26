//This Java Program illustrates how to read data from a text File using Scanner Class 
//The contents of the data file will be outputted to the console for the user to view.
import java.io.File; 
import java.util.Scanner; 

public class DataFileReader
{ 
  public static void main(String[] args) throws Exception 
  { 
    //List path to the file as a parameter or make sure that the file is included in the same program directory
    File file = new File("data.txt"); 
 //REPLACE WITH THE DESIRED FILENAME HERE (by default will use 'data.txt')
    Scanner scan = new Scanner(file); 
  
    while (scan.hasNextLine()) 
      System.out.println(scan.nextLine()); 
  } 
} 