import java.util.Scanner;

class CalculatorProgram{
               public static void main(String[] args) {
                
                Scanner sc = new Scanner(System.in);
                System.out.println(" --------CALCULATOR--------");
                System.out.println();
                   
               System.out.println("enter the first number : ");
                double num1 = sc.nextInt();

                System.out.println("enter the second number : ");
                double num2 =  sc.nextInt();


               
                System.out.println("product       : " + num1 * num2);

                System.out.println("sum           : " + (num1 + num2));

                System.out.println("Substraction  : " + (num1 - num2));

                System.out.println("Division      : " + (num1 / num2));


                }
        }

            
                         
                     
                   public static void main(String[] args) {
                       new CalculatorProgram();
                   }
               }
               
