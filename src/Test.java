import java.util.concurrent.TimeUnit;
public class Test
{
    LockClass lock;
    public Test(LockClass lockClass)
    {
        lock = lockClass;
    }

    public void mainTesting() throws InterruptedException {
        System.out.println("Testing lock status should report open");
        TimeUnit.SECONDS.sleep(2);
        if (lock.inquireStatus())
        {
            System.out.println("Lock is open");
        }
        else
        {
            System.out.println("Lock is closed");
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Testing changing combination should report changed successfully");
        TimeUnit.SECONDS.sleep(2);
        lock.alterCombination(5,10,39);
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Testing closing lock should report closed");
        TimeUnit.SECONDS.sleep(2);
        lock.closeLock();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Testing lock status should report close");
        TimeUnit.SECONDS.sleep(2);
        if (lock.inquireStatus())
        {
            System.out.println("Lock is open");
        }
        else
        {
            System.out.println("Lock is closed");
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Testing opening lock should report failed");
        TimeUnit.SECONDS.sleep(2);
        lock.tryOpenLock();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Now reporting number on top should still be 0");
        TimeUnit.SECONDS.sleep(2);
        System.out.println(lock.numberOnTop());
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Now trying to open lock should fail");
        TimeUnit.SECONDS.sleep(2);
        lock.resetEnter();
        lock.turnKnob(5,2);
        TimeUnit.SECONDS.sleep(5);
        lock.turnKnob(10,2);
        TimeUnit.SECONDS.sleep(5);
        lock.turnKnob(39,1);
        TimeUnit.SECONDS.sleep(5);
        lock.tryOpenLock();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Now trying to open lock should succeed");
        TimeUnit.SECONDS.sleep(2);
        lock.resetEnter();
        lock.turnKnob(1,1);
        TimeUnit.SECONDS.sleep(5);
        lock.turnKnob(5,1);
        TimeUnit.SECONDS.sleep(5);
        lock.turnKnob(10,2);
        TimeUnit.SECONDS.sleep(5);
        lock.turnKnob(39,1);
        TimeUnit.SECONDS.sleep(5);
        lock.tryOpenLock();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Testing lock status should report open");
        TimeUnit.SECONDS.sleep(2);
        if (lock.inquireStatus())
        {
            System.out.println("Lock is open");
        }
        else
        {
            System.out.println("Lock is closed");
        }
        TimeUnit.SECONDS.sleep(5);

    }
}
