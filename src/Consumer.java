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
    { int len = queue.size()-1;
        for (int i = 0; i < len; i++)
        {
            try {
                String sparky = queue.element()[0];
                if(sparky.equals("A1"))
                {
                    System.out.println("\n");
                    System.out.println("COMMAND NUMBER: "+ i + " queue.get()  = " + queue.remove()[0] + "for A1");
                    robotWork(queue.element());
                    queue.remove(i);
                }
                else if (sparky.equals("A2"))
                {
                    System.out.println("\n");
                    System.out.println("COMMAND NUMBER: "+ i + "queue.get()  = " + queue.remove()[0] + "for A2");
                    robotWork(queue.element());
                    queue.remove(i);
                }
                else if (sparky.equals("A3"))
                {
                    System.out.println("\n");
                    System.out.println("COMMAND NUMBER: "+ i + "queue.get()  = " + queue.remove()[0] + "for A3");
                    robotWork(queue.element());
                    queue.remove(i);
                }
                else if (sparky.equals("A4"))
                {
                    System.out.println("\n");
                    System.out.println("COMMAND NUMBER: "+ i + "queue.get()  = " + queue.remove()[0] + "for A4");
                    robotWork(queue.element());
                    queue.remove(i);
                }
                else
               {
                    System.out.println("\n");
                    System.out.println("COMMAND NUMBER: "+ i + "Command not found: " + queue.element()[0]);
               }

           // } catch (InterruptedException e) {
                // TODO Auto-generated catch block
         //       e.printStackTrace();
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
