import java.util.Scanner;
public class MasterLock
{
    public static void main(String[] args)
    {
        master(); //runs the main branch for the program
        //test(); //runs the testing for the program
    }

    private static void master()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your first number for the combination");
        int num1 = scan.nextInt();
        System.out.println("Enter your second number for the combination");
        int num2 = scan.nextInt();
        System.out.println("Enter your third number for the combination");
        int num3 = scan.nextInt();
        LockClass l = new LockClass(num1,num2,num3);
    }
}

