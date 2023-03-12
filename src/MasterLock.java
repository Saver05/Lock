import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MasterLock
{
    public static void main(String[] args) throws InterruptedException {
        master(); //runs the main branch for the program
        //test(); //runs the testing for the program
    }

    private static void master() throws InterruptedException { //main initialization for the lock
        int num1,num2,num3;
        Scanner scan = new Scanner(System.in);
        do{
        System.out.println("Enter your first number for the combination 0-39");
        num1 = scan.nextInt();
        }
        while (!(num1 >= 0 && num1<40)); //while the number is not between 0 and 39 repeat
        do{
        System.out.println("Enter your second number for the combination 0-39");
        num2 = scan.nextInt();
        }
        while (!(num2 >= 0 && num2<40)); //while the number is not between 0 and 39 repeat
        do{
        System.out.println("Enter your third number for the combination 0-39");
        num3 = scan.nextInt();
        }
        while (!(num3 >= 0 && num3<40)); //while the number is not between 0 and 39 repeat
        LockClass l = new LockClass(num1,num2,num3);
        funct(l); //goes to main function to run lock program
    }

    private static void test() throws InterruptedException { //testing class
        LockClass l = new LockClass();
        Test test = new Test(l);
        test.mainTesting(); //runs the testing method
    }

    /**
     * main function for the lock
     * @param l the class the lock is running under
     * @throws InterruptedException used for the sleep counter should never error
     */
    private static void funct(LockClass l) throws InterruptedException {
        boolean exit = false; //repeater variable
        Scanner scan = new Scanner(System.in);
        while (!exit) //repeats forever
        {
            System.out.println("Enter the option number of your choice");
            System.out.println("1. Alter lock's combination");
            System.out.println("2. Turn knob in given direction");
            System.out.println("3. Inquire status of lock");
            System.out.println("4. See what number is currently on top");
            System.out.println("5. Attempt to open lock");
            System.out.println("6. Reset (This turns the lock an entire revolution clockwise resetting the entering sequence to allow you to start " +
                    "entering the combination from the beginning)");
            System.out.println("7. Close Lock");
            System.out.println("8. Exit program");
            int answer = scan.nextInt();
            switch (answer)
            {
                case 1:
                    l.alterCombination();
                    TimeUnit.SECONDS.sleep(1);
                    break;
                case 2:
                    l.turnKnob();
                    TimeUnit.SECONDS.sleep(1);
                    break;
                case 3:
                    if(l.inquireStatus())
                    {
                        System.out.println("The lock is currently open");
                        TimeUnit.SECONDS.sleep(1);
                        break;
                    }
                    System.out.println("The lock is currently closed");
                    TimeUnit.SECONDS.sleep(1);
                    break;
                case 4:
                    System.out.println("The number currently on top is "+l.numberOnTop());
                    TimeUnit.SECONDS.sleep(1);
                    break;
                case 5:
                    l.tryOpenLock();
                    TimeUnit.SECONDS.sleep(1);
                    break;
                case 6:
                    l.resetEnter();
                    TimeUnit.SECONDS.sleep(1);
                    break;
                case 7:
                    l.closeLock();
                    TimeUnit.SECONDS.sleep(1);
                    break;
                case 8:
                    int n;
                    do {
                        System.out.println("Are you sure you want to exit the program yes=1 or no=2");
                        n = scan.nextInt();
                    }while(!(n==1 || n==2)); //while n != 1 or 2 repeat
                    if (n==1) {
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("Please enter one of the given option's numbers 1-6");
                    TimeUnit.SECONDS.sleep(1);
                    break;
            }
        }
    }
}

