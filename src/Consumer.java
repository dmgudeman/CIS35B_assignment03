import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

class Consumer implements Runnable
{
    LinkedBlockingQueue<String[]> queue;
    ArrayList<String[]> list = new ArrayList<>();
   // CommandEnumerationTask task = new CommandEnumerationTask(queue, list);

    Consumer(LinkedBlockingQueue<String[]> queue, ArrayList<String[]> list) throws InterruptedException
    {
        this.queue = queue;
        this.list = list;


        new Thread(this).start();
    }
    public void run()
    { int len = list.size()-1;
        for (int i = 0; i < len; i++)
        {
            try {
                String sparky = queue.element()[0];
                if(sparky.equals("A1"))
                {
                    System.out.println("queue.get()  = " + queue.remove()[0] + "for A1");
                    System.out.println("this A1");
                    robotWork(queue.element());
                    queue.remove(i);
                }
                else if (queue.remove()[0] == "A2")
                {
                    Thread.sleep(100);
                    System.out.println("this A2");
                }
                 else if (queue.remove()[0] == "A3")
                {
                    Thread.sleep(100);
                    System.out.println("this A3");
                }
                 else if (queue.remove()[0] == "A4")
                {
                    Thread.sleep(100);
                    System.out.println("this A4");
                }
                else
               {
                    System.out.println("Command not found: " + queue.element()[0]);
               }

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }catch (NoSuchElementException f)
            {
                System.out.println("");
            }
        }
    }
    public void robotWork (String[] command)
    {
        try
        {
            System.out.println(command[0] + " arm is working");
            System.out.println(command[1]);
            System.out.println(command[2]);
            System.out.println(command[3]);
            System.out.println(command[4]);
            System.out.println("Sleeping " + command[5] + "milliseconds");
            Thread.sleep(Integer.parseInt(command[5]));
        } catch (InterruptedException e)
        {
            System.out.println("Interrupted Exception caught");
        }
    }

}