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
    public LockClass(int num1, int num2, int num3)
    {
        x = num1;
        y = num2;
        z = num3;
        lockStatus = true;
    }

    public LockClass()
    {
        x=y=z=0;
        lockStatus = true;
    }

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
     private void changeCombination(int in1,int in2,int in3) //testing class same as above just doesn't take user input
     {
         System.out.println("Enter your first number for the combination");
         x = in1;
         System.out.println("Enter your second number for the combination");
         y = in2;
         System.out.println("Enter your third number for the combination");
         z = in3;
     }

     public void resetEnter()
     {
         combinationCounter=3;
         System.out.println("You have turned the lock one full revolution clockwise");
     }
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
     public void turnKnob(int number,int d) { //testing class just doesn't take user input otherwise same
         int n;
         do {
             System.out.println("Enter what number you would like to turn the knob to 0-39");
             n = number;
         }
         while (!(n >= 0 && n<40));
         int dir = 0;
         do{
             System.out.println("Enter what direction you would like the knob to be turned\n" + "1 for Clockwise or 2 for Counter Clockwise");
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
    private void checkOpening(int prev)
    {
        switch(combinationCounter)
        {
            case 3:
                if (currentTop == x && direction == "clockwise" && currentTop>=prev) //checks if first code is entered correctly
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
    public void closeLock()
    {
        System.out.println("Lock is now closed");
        lockStatus = false;
    }

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

    public boolean inquireStatus()
    {
        return lockStatus;
    }

    public int numberOnTop()
    {
        return currentTop;
    }

}
