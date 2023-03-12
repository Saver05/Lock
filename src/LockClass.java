import java.util.Scanner;
 class LockClass {
    int x;
    int y;
    int z;
    boolean lockStatus;// true = open false = closed
    int currentTop = 0;
    int combinationCounter = 3; // when it = 0 lock can be opened
    String direction = "clockwise"; //defines the direction of the turn
     // will either be clockwise or counterclockwise

     /**
      * Main constructor
      * @param num1 the first input for the lock
      * @param num2 the second input for the lock
      * @param num3 the third input for the lock
      */
    public LockClass(int num1, int num2, int num3)
    {
        x = num1;
        y = num2;
        z = num3;
        lockStatus = true;
    }

     /**
      * Constructor for testing class
      */
    public LockClass()
    {
        x=y=z=0;
        lockStatus = true;
    }

     /**
      * Checks for the lock being open before beginning lock combination changing
      */
    public void alterCombination()
    {
        if (!lockStatus)
        {
            System.out.println("Please open the lock before changing combination");
            return;
        }
        System.out.println("Starting combination change");
        changeCombination();
        System.out.println("Combination change successfully");
    }

     /**
      * Testing class for alterCombination
      * @param in1 first input for lock
      * @param in2 second input for lock
      * @param in3 third input for lock
      */
     public void alterCombination(int in1,int in2,int in3) //testing class same as above just doesn't take user input
     {
         if (!lockStatus)
         {
             System.out.println("Please open the lock before changing combination");
             return;
         }
         System.out.println("Starting combination change");
         changeCombination(in1,in2,in3);
         System.out.println("Combination change successfully");
     }

     /**
      * Main way to get inputs for changing the combination on the lock
      */
    private void changeCombination()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your first number for the combination");
        x = scan.nextInt();
        System.out.println("Enter your second number for the combination");
        y = scan.nextInt();
        System.out.println("Enter your third number for the combination");
        z = scan.nextInt();
    }

     /**
      * testing method for changeCombination
      * @param in1 first input for lock
      * @param in2 second input for lock
      * @param in3 third input for lock
      */
     private void changeCombination(int in1,int in2,int in3) //testing class same as above just doesn't take user input
     {
         System.out.println("Enter your first number for the combination");
         x = in1;
         System.out.println("Enter your second number for the combination");
         y = in2;
         System.out.println("Enter your third number for the combination");
         z = in3;
     }

     /**
      * resets the lock by turning it one full revolution clockwise
      */
     public void resetEnter()
     {
         combinationCounter=3;
         System.out.println("You have turned the lock one full revolution clockwise");
     }

     /**
      * allows you to turn the knob to a certain number and in a direction
      */
    public void turnKnob() {
        Scanner scan = new Scanner(System.in);
        int n;
        do {
            System.out.println("Enter what number you would like to turn the knob to 0-39");
            n = scan.nextInt();
        }
        while (!(n >= 0 && n<40));
        int dir = 0;
        do{
        System.out.println("Enter what direction you would like the knob to be turned\n" + "1 for Clockwise or 2 for Counter Clockwise");
         dir = scan.nextInt();}
        while(!(dir==1 || dir == 2));
        if (dir==1)
        {
            direction = "clockwise";
        }
        else
        {
            direction = "counterclockwise";
        }
        System.out.println("Turning knob to "+n+" in the "+direction+" direction");
        int prev = currentTop;
        currentTop = n;
        checkOpening(prev);
    }

     /**
      * testing class for turnKnob
      * @param number number we are turning the knob to
      * @param d direction the knob should turn in int form
      */
     public void turnKnob(int number,int d) { //testing class just doesn't take user input otherwise same
         int n;
         do {
             System.out.println("Enter what number you would like to turn the knob to 0-39");
             n = number;
         }
         while (!(n >= 0 && n<40));
         int dir = 0;
         do{
             System.out.println("Enter what direction you would like the knob to be turned"
                     + "1 for Clockwise or 2 for Counter Clockwise");
             dir = d;}
         while(!(dir==1 || dir == 2));
         if (dir==1)
         {
             direction = "clockwise";
         }
         else
         {
             direction = "counterclockwise";
         }
         System.out.println("Turning knob to "+n+" in the "+direction+" direction");
         int prev = currentTop;
         currentTop = n;
         checkOpening(prev);
     }

     /**
      * checks to see if the lock can be opened using the combinationCounter int
      * runs every time the lock is turned checking to see if it is turned to the correct number
      * and in the correct direction
      * @param prev the previous top used for checking if the knob was turned clockwise an entire revolution
      *             on the first turn
      */
    private void checkOpening(int prev)
    {
        switch(combinationCounter)
        {
            case 3:
                if (currentTop == x && direction == "clockwise" && currentTop>=prev)
                    //checks if first code is entered correctly and if lock made a full rotation
                {
                    combinationCounter--;
                    return;
                }
                combinationCounter=3;
                break;
            case 2:
                if (currentTop == y && direction == "counterclockwise")//checks if second code is entered correctly
                {
                    combinationCounter--;
                    return;
                }
                combinationCounter=3;
                break;
            case 1:
                if (currentTop == z && direction == "clockwise") //checks if third code is entered correctly
                {
                    combinationCounter--;
                    return;
                }
                combinationCounter=3;
                break;
            default:
                combinationCounter=3;
        }
    }

     /**
      * Closes the lock unless it is already closed then tells you it is already closed
      */
    public void closeLock()
    {
        if (!inquireStatus())
        {
            System.out.println("The lock is already closed");
            return;
        }
        System.out.println("Lock is now closed");
        lockStatus = false;
    }

     /**
      * This attempts to open the lock
      * if the lock is already open tells you the lock is already open
      * if the combinationCounter is not 0 as would be the case if you entered the correct sequence tells you,
      * you failed to open the lock
      * otherwise the lock opens
      */
    public void tryOpenLock()
    {
        if (lockStatus)
        {
            System.out.println("The lock is already open");
            return;
        }
        if (combinationCounter!=0)
        {
            System.out.println("You failed to open the lock");
            System.out.println("Please enter the correct combination");
            return;
        }
        System.out.println("Lock is now open");
        lockStatus = true;
    }

     /**
      * gives whether the lock is open or closed
      * @return bool true for open false for closed
      */
    public boolean inquireStatus()
    {
        return lockStatus;
    }

     /**
      * gives the number currently on top
      * @return int of the number on top
      */
    public int numberOnTop()
    {
        return currentTop;
    }

}
