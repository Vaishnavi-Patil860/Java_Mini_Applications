import java.util.*;
class BankProgram
{
    static String name;
    static String email;
    static String address;
    static double bal;
    static int pin;
    static String contact;
    static Long adhar;
    static String pancard;
    static Long accountNumber;
    static String ifscCode;
    static ArrayList<String>  statement = new ArrayList<String>();
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        welcomeLoop:
        for (; ;)
        {
            System.out.println();
            System.out.println("     WELCOME");
            System.out.println("    LAXMI CHIT FUND       ");
            System.out.println();
            System.out.println("     1. Create Account    ");
            System.out.println("     2. Existing User     ");
            System.out.println();
            System.out.print("     Enter your option :     ");

            switch (sc.nextInt())
             {
                case 1:{

                          System.out.println();
                          System.out.print("   Create your account  ");
                          System.out.println();

                          sc.nextLine();
                          System.out.println();
                          System.out.print("    Username :");
                          name = sc.nextLine();
                          System.out.println();
                          System.out.print("    Email :  ");
                          email = sc.next();
                          System.out.println();
                          System.out.print("    Address : ");
                          sc.nextInt();
                          System.out.println();

                          address = sc.nextLine();
                          System.out.print("    Adhar Number:  ");

                          adhar = sc.nextLong();
                          System.out.println();

                          System.out.print("    Pan Number: ");
                          pancard = sc.next();
                          System.out.println();

                          System.out.print("    Contact Number:  ");
                          contact = sc.next();
                          System.out.println();

                          System.out.print("     Pin:   ");
                          pin = sc.nextInt();
                          System.out.println();

                          System.out.print("     Enter an ammount (Deposit)  : ");
                          bal = sc.nextDouble();
                          System.out.println();

                          statement.add("  Deposit : "  + bal + "rs   (Account Creation)");
                          System.out.println();
                          System.out.println("  Account created successfully");
                          System.out.println();
                          break;

                    }

                case 2 :{
                          if (name == null)
                          {
                            System.out.println();
                            System.out.println("  Create your account first ");
                            break;
                          }
                          System.out.println();
                          System.out.println("    LOGIN ");
                          for (int i = 3; i >= 1; i--)
                          {
                            System.out.println();
                            System.out.print("   username/Phone:");
                            String cred1 = new Scanner(System.in).next();
                            System.out.print("   Pin : " );


                            int cred2 = new Scanner(System.in).nextInt();
                            System.out.println();
                            if((cred1.equals(name)||cred1.equals(contact)) && cred2 == pin){

                              homePage:
                              for (;;)
                              {
                                System.out.println();
                                System.out.println("home page");
                                System.out.println();
                                System.out.println("1. Deposit ammount");
                                System.out.println("2. Withdraw ammount");
                                System.out.println("3. Check balance ");
                                System.out.println("4. Statement");
                                System.out.println("5. Loan");
                                System.out.println("6. Profile");
                                System.out.println("7. Logout");
                                System.out.println();
                                System.out.print("   Enter your option :");
                                int opt = new Scanner(System.in).nextInt();
                                System.out.println();

                         switch(opt)
                         {
                             case 1 :{
                                   System.out.print("   Deposit ammount :");
                                   System.out.println();
                                   System.out.print("   Enter the ammount: ");
                                   double depAmt = new Scanner(System.in).nextDouble();
                                   bal += depAmt;
                                   System.out.print("   Amount deposited Successfully");
                                   statement.add("deposit :"  + depAmt + "rs");
                                   break;
                                  }
                              case 2 :
                              {
                                   System.out.print(" Withdraw module");
                                   System.out.println();
                                   System.out.print(" ENTER YOUR AMMOUNT :");
                                   double withAmt = new Scanner(System.in).nextDouble();
                                   System.out.print(" ENTER THE PIN: ");
                                   int pin1 = new Scanner(System.in).nextInt();
                                       if(pin1 == pin){
                                          if(withAmt <= bal)
                                            {
                                              bal -= withAmt;
                                              System.out.print("ACCOUNT DEBITED SUCCESSFULLY");
                                              statement.add("debited :" + withAmt + "rs");
                                            }
                                         else 
                                           {
                                             System.out.println("");
                                            }
                                          }
                                        else {
                                            System.out.println("Invalid pin");
                                             }
                                             break;
                                            }

                                  
                                
                              case 3:{
                                  System.out.println("CHECK BALANCE MODULE");
                                  for(int j= 3; j>= 1; j--)
                                  {
                                  System.out.println();
                                  System.out.print("ENTER YOUR PIN");
                                  int pin1 = new Scanner(System.in).nextInt();
                                  if(pin == pin1){
                                   System.out.print("YOUR ACCOUNT BALANCE IS :" + bal);
                                   continue homePage;


                                   }
                                   else {
                                  System.out.println("INVALID PIN ");
                                  System.out.print("ATTEMPT LEFT :" + (j-1));

                                    }

                                  }

                                    System.out.println("ITS NOT YOUR ACCOUNT");
                                    System.out.println("ACCOUNT IS BLOCKED FOR 24 HOURS");
                                    System.exit(0);
                                    break;
                                  }
                             case 4 :{
                                    System.out.println("STATEMENT MODULE");
                                   System.out.println();
                                   for (String s : statement ){
                                   System.out.println(s);

                                   }
                                    break;
                                }

                            case 5 :{
                                     System.out.println("LOAN MODULE");
                                     break;
                                    }
                            
                            case 6 :{
                                     System.out.println(" PROFILE MODULE");
                                     System.out.print("USERNAME :" + name);
                                     System.out.print("USERNAME :" + contact);
                                     System.out.print("USERNAME :" + email);
                                     System.out.print("USERNAME :" + address);



                                     break;
                                      }
                            case 7 :{
                                     System.out.println("THANKYOU VISIT AGAIN");
                                     System.out.println();
                                     System.exit(0);
                                     break;
                                      }

                            default:{
                                      System.out.println("INVALID OPTION");
                                      break;
                      
                                     }
                                   }
                                 }
                               }
                        else {
                            System.out.println("INVALID CRED");
                            System.out.println("ATTEMPT LEFT : " + (i-1));

                          }
                        }
        
                           System.out.println("THANKYOU AND NAVAR VISIT AGAIN");
                           System.out.println("YOUR ACCOUNT IS DEACTIVATED FOR 48 HOURS");
                           System.exit(0);
                        }

                        default :{
                            System.out.println("INVALID OPTION");
                            break;

                          }
                       }
                    }
                 }
              }  
        
      






