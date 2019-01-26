/*
This Java Program demonstrates how object-orientated programming 
in conjunction with class constructors can be used to create an ATM for a Bank
with full scale transactions such as withdrawal, deposits, and interest rates factored in.
Each Bank Savings and Checking Accounts comes with unique user IDs and passwords that can be updated if needed.
*/

import java.util.Scanner;

public class BankAccount{
  //PRIVATE VARIABLES HERE
  private String user, password, typeOfAccount; //variables for user, password, and type of account: Checking or Savings only
  private int accountId; //variable for account number --> random 6 digit integer, use Math.random 
  private double balance; //variable for balance
  private double interestRate; //variable for savings only
  //ignore other types of accounts such as investment, money market, CDs, and debit card account for this assignment.
  
  //Constructor for setting up a bank account -- all parameters must be initialized here
  public BankAccount(String user, String password, String typeOfAccount, double balance){
    //set the user
    this.user = user;
    //set the password
    this.password = password;
    //generate a random account id using the 
    this.accountId = generateRandomIdNumber(100000, 999999);
    //set the type of account
    this.typeOfAccount = typeOfAccount;
    //set the balance
    this.balance = balance;
    //If the user has a savings account (do a string equals check) set the interest rate to .001
    if(typeOfAccount.toUpperCase().equals("SAVINGS")){
      this.interestRate = .001;
      //If the balance of the savings account is more than or equal to $25,000, give the user "elite" membership by increasing the interest rate to 1.25%
      if(this.balance >= 25000){
        this.interestRate = .0125;
      }
    }
  }//end of constructor
  
  
  //DO OBJECT INITIALIZATION AND TESTING HERE!!!
  //SAMPLE TEST CASE PROVIDED BELOW
  public static void main (String args[]){

    //Default user starts with nothing in the bank account
    BankAccount b = new BankAccount("Test User", "Password123", "SAVINGS", 0);
    
    Scanner scan = new Scanner(System.in);
    boolean continueFlag = true;
    double amountToDeposit;
    double amountToWithdraw;
    do{
      displayMenuOptions();
      int userTypedInteger = scan.nextInt();
      switch(userTypedInteger){
        //Display the user account info
        case 1:
          b.displayInfo();
          break;
        //initial deposit
        case 2:
          System.out.println("Enter the amount you would like to deposit: ");
          amountToDeposit = scan.nextDouble();
          b.makeDeposit(amountToDeposit);
          break;
       //initial withdrawal
        case 3:
          System.out.println("Enter the amount you would like to withdraw: ");
          amountToWithdraw = scan.nextDouble();
          b.makeWithdrawal(amountToWithdraw);
          //Ask user how they would like their bills
          System.out.println("ATM: How would you like your bills?\n1: $20 dollar bills\n2: $50 dollar bills\n3: $100 dollar bills");
            int userInputForBill = scan.nextInt();
            //Currency variables
            int numberOfTwentyDollarBills, numberOfFiftyDollarBills, numberOfHundredDollarBills;
            int numberOfNickels, numberOfDimes, numQuarters;
            double remainderForQuarters, remainderForDimes;
            //Switch statement of menu options
            switch(userInputForBill){
              //For 20 dollar bills
              case 1:
                numberOfTwentyDollarBills = ((int)amountToWithdraw/20);
                remainderForQuarters = (amountToWithdraw % 20)%(.25);
                numQuarters = (int)((amountToWithdraw % 20 - remainderForQuarters) / .25);
                remainderForDimes = remainderForQuarters % .10;
                numberOfDimes = (int)((remainderForQuarters - remainderForDimes) / .10);
                numberOfNickels = (int)((remainderForDimes / .05) + 0.1);
                System.out.print("You received " + numberOfTwentyDollarBills + " $20 bill(s), ");
                System.out.print(numQuarters + " quarter(s), ");
                System.out.print(numberOfDimes + " dime(s), and ");
                System.out.println(numberOfNickels + " nickel(s). ");
                break;

              //For 50 dollar bills
              case 2:
                numberOfFiftyDollarBills = ((int)amountToWithdraw/50);
                remainderForQuarters = (amountToWithdraw % 50)%(.25);
                numQuarters = (int)((amountToWithdraw % 50 - remainderForQuarters) / .25);
                remainderForDimes = remainderForQuarters % .10;
                numberOfDimes = (int)((remainderForQuarters - remainderForDimes) / .10);
                numberOfNickels = (int)((remainderForDimes / .05) + 0.1);
                System.out.print("You received " + numberOfFiftyDollarBills + " $50 bill(s), ");
                System.out.print(numQuarters + " quarter(s), ");
                System.out.print(numberOfDimes + " dime(s), and ");
                System.out.print(numberOfNickels + " nickel(s). ");
                break;

              //For 100 dollar bills
              case 3:
                numberOfHundredDollarBills = ((int)amountToWithdraw/100);
                remainderForQuarters = (amountToWithdraw % 100)%(.25);
                numQuarters = (int)((amountToWithdraw % 100 - remainderForQuarters) / .25);
                remainderForDimes = remainderForQuarters % .10;
                numberOfDimes = (int)((remainderForQuarters - remainderForDimes) / .10);
                numberOfNickels = (int)((remainderForDimes / .05) + 0.1);
                System.out.print("You received " + numberOfHundredDollarBills + " $100 bill(s), ");
                System.out.print(numQuarters + " quarter(s), ");
                System.out.print(numberOfDimes + " dime(s), and ");
                System.out.print(numberOfNickels + " nickel(s). ");
                break;
          }
          
        break;

      //Closes the user account
      case 4:
        b.makeWithdrawal(b.getBalance());
        System.out.println("NOTICE: Your Account has been closed. The current balance is " + b.getBalance());
      break;

      //Changes the username
      case 5:
        System.out.println("Enter the new username you would like to use (without spaces): ");
        String newUsername = scan.next();
        b.changeUserName(newUsername);
        System.out.println();
        break;
      //Changes the password
      case 6:
        System.out.println("Enter the new password you would like to use (without spaces): ");
        String newPassword = scan.next();
        b.changePassword(newPassword);
        System.out.println();
        break;

      case 7://User exits
        System.exit(0);
        break;

    default:
      break;

      }
    }
    while(continueFlag);
    
    scan.close();
    
  } //end of main
  
  

  ///HELPER METHODS  
  
  //This method will generate a random number withing the range of the specified minimum and maximum
  public int generateRandomIdNumber(int min, int max) {
    return (int) Math.floor(Math.random() * (max - min + 1)) + min;
  }    
  
  
  //GETTER METHODS (should be private, not public methods for security):   
  
  //This method gets and print out the username of the account
  private String getUserName(){
    //System.out.println("The username of the account is: " + this.user);
    return this.user;
  }   
  
  //This method gets and print out the password of the account
  private String getPassword(){
    //System.out.println("The password of the account is: " + this.password);
    return this.password;
  }  
  
  //This method gets and print out the username of the account
  private Double getBalance(){
    //System.out.println("The balance of the account is: " + this.balance);
    return this.balance;
  }   
  
  //This method gets the type of the account: checking or savings
  private String getTypeOfAccount(){
    //System.out.println("The account is a " + this.typeOfAccount + " account");
    return this.typeOfAccount;
  } 
  
  //This method gets the account id (randomized 6 digit integer)
  private int getAccountId(){
    //System.out.println("The account id is " + this.accountId);
    return this.accountId;
  }
  
  //This method gets the interest rate if the type of the account is savings
  private double getInterestRate(){
    if(getTypeOfAccount().equals("SAVINGS")){
      return this.interestRate;
    }
    else{
      return -1;
    }
  }
  
  
  
  //SETTER METHODS:
  private void changeUserName(String newUsername){
    String previousUsername = getUserName();
    this.user = newUsername;
    System.out.println("UPDATE -- The username of the account has changed from " 
                         + previousUsername + " to " + this.user + ".");
  }  
  
  //This method changes the password of the account
  private void changePassword(String newPassword){
    String oldPassword = getPassword();
    //If the old password is not the same as the new password then update the password,
    //otherwise print out an error message letting the user know that they need a new password 
    //that is different than their current one
    if(!(oldPassword.equals(newPassword))){
      this.password = newPassword;
      System.out.println("UPDATE -- The username of the account has changed from " 
                           + oldPassword + " TO " + this.password + ".");
    }
    else{
      System.out.println("ERROR: you need to pick a new password that is different than your current password");
    }
    
  }  
  
  //This method withdraws an amount from the user's account balance
  //NOTE: must check to make sure that amount withdrawn does not EXCEED current balance
  //We can't let the bank go 'bankrupt'! :)
  //Instructions: First print out the type of account, current balance and the amount the user would like to withdraw
  private void makeWithdrawal(Double amountToWithdraw){
    System.out.println("\n----------- WITHDRAWAL -----------");
    System.out.println("Type of Account: " + getTypeOfAccount());
    System.out.println("Your Current Balance: $" + getBalance());
    System.out.println("Amount to Withdraw: $" + amountToWithdraw);
    // if the amount withdrawn is within the permitted limits of the balance 
    //(less than or equal to the balance), then print out a before and after balance with the withdrawal amount deducted
    if(amountToWithdraw <= getBalance()){
      System.out.println("\nWITHDRAWAL SUCCEEDED\n\nBalance BEFORE Withdrawal: $" + getBalance());
      this.balance = this.balance - amountToWithdraw;
      System.out.println("Balance AFTER Withdrawal: $" + getBalance());
    }
    System.out.println("----------------------------------\n");
  }
  
  //This method withdraws an amount from the user's account balance
  private void makeDeposit(Double amountToDeposit){
    System.out.println("\n+++++++++++ DEPOSIT ++++++++++++++");
    System.out.println("Your Current Balance: $" + getBalance());
    System.out.println("Amount to Deposit: $" + amountToDeposit);
    this.balance = this.balance + amountToDeposit;
    System.out.println("\nDEPOSIT SUCCEEDED\n\nBalance BEFORE Deposit: $" + getBalance());
    System.out.println("Balance AFTER Deposit: $" + getBalance());
    //NOTE: In the event that the amount that they add exceeds $25000, update the interest rate
    //and print out a congratulations message letting them know that their savings was upgraded to a higher interest rate.
    if((this.balance >= 25000) && (getTypeOfAccount().equals("SAVINGS"))){
      System.out.println("Congratulations!\nYour total savings has upgraded\nfrom .01% to 1.25%");
      this.interestRate = .125;
    }
    System.out.println("++++++++++++++++++++++++++++++++++\n");
  }
  
  public static void displayMenuOptions(){
  System.out.println("\n################ BANK ATM #################");
   System.out.println("Press 1 to display the account information.");
   System.out.println("Press 2 to make a deposit.");
   System.out.println("Press 3 to make a withdrawal.");
   System.out.println("Press 4 to close the account.");
   System.out.println("Press 5 to change the username.");
   System.out.println("Press 6 to change the password.");
   System.out.println("Press 7 to quit the program.");
   }
  private void displayInfo(){
    System.out.println("\n########### ACCOUNT INFORMATION ###########");
    System.out.println("Account Id: " + getAccountId());
    System.out.println("Name of User: " + getUserName());
    System.out.println("Password: '" + getPassword() + "'");
    System.out.println("Type of Account: " + getTypeOfAccount());
    if(getTypeOfAccount().equals("SAVINGS")){
      System.out.println("Interest Rate (APY %): " + getInterestRate());
    }
    System.out.println("Your Current Balance: $" + getBalance());    
    System.out.println("###########################################\n");
  }
  
  
  
  
  
  
  
  
  
  
}//end of BankAccount Class