import java.util.Scanner;

public class PasswordProgram {
   
    public static void main(String[] args)  throws InterruptedException {
        
        Scanner sc = new Scanner(System.in);
        int storedPin = 1234;
        int duration = 3000;
        outerLoop:
        for(;;)
        {
            int attempt = 3;
            do{
                System.out.println();
                System.out.println("Enter your pin : ");
                int userPin = sc.nextInt();
                if(userPin == storedPin)
                {
                    System.out.println("Phone Unlocked");
                    break outerLoop;
                }
                
                else {
                    System.out.println("WRONG PIN ENTERED : ");
                    System.out.println("attempt left :" +(attempt-1));
                }
                attempt--;

            }
            while (attempt>=1);
            System.out.println();
            System.out.println("Phone is been locked for : " + (duration/1000)+ "  seconds");
            Thread.sleep(duration);
            duration *= 2;

        }
    }
}
