import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer implements Runnable
{
    LinkedBlockingQueue<String[]> queue;
    ArrayList<String[]> list = new ArrayList<>();
    static int LENGTH = 0;

    Producer(LinkedBlockingQueue<String[]> queue, ArrayList<String[]> list) throws InterruptedException
    {
        this.queue = queue;
        this.list = list;
        new Thread(this).start();
        LENGTH = list.size();
        queue = packTheQueue(queue, list);
        System.out.println("IN PRODCUUUUUUUER CONSTRUCTOR LIST.SIZE() = " + list.size());
        System.out.println("IN PRODCUUUUUUUER CONSTRUCTOR QUEUE.SIZE() = " + queue.size());

    }

    public void run()
    {
        System.out.println("RUN IN PRODUCER FIRED");
        try
        {
           while (queue.size() >0)
            {
                for (int i = 0;;i++)
                {
                    queue.put(this.list.get(i));
                    //System.out.println("IN PRODCUER CONSTRUCTOR QUEUE.SIZE() = " + LENGTH);
                  //  System.out.println("STEP i  in run in PRODUCER " + i);
                  //  System.out.println("PRODUCER RUN QUEUE.SIZE =" + queue.size());
                 //   System.out.println("QUEUE.ELEMENT[0] = " + queue.element()[0]);
                //    System.out.println("QUEUE.ELEMENT[1] = " + queue.element()[1]);
                 //   System.out.println("QUEUE.ELEMENT[2] = " + queue.element()[2]);
                 //   System.out.println("QUEUE.ELEMENT[3] = " + queue.element()[3]);
                 //   System.out.println("QUEUE.ELEMENT[4] = " + queue.element()[4]);
                   // System.out.println("QUEUE.ELEMENT[5] = " + queue.element()[5]);
                 //   System.out.println("IN PRODCUER CONSTRUCTOR QUEUE.SIZE() = " + LENGTH);
                 //   System.out.println("\n");
                }
            }
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }
        catch (IndexOutOfBoundsException f)
        {
            System.out.println("FINAL QUEUE>SIZE() = "+ queue.size() + "++++++++++++++++++++++++++++");
            System.out.println("OUT OF BOUNDS EXCEPTION");
        }
        catch (NoSuchElementException g)
        {
            System.out.println("no susch element exception");
        }

    }
    public LinkedBlockingQueue packTheQueue(LinkedBlockingQueue<String[]> queue, ArrayList <String[]> list)
    {
        try
        {
                for (int i = 0;;i++)
                {
                    queue.put(this.list.get(i));
                    //System.out.println("IN PRODCUER CONSTRUCTOR QUEUE.SIZE() = " + LENGTH);
                    //  System.out.println("STEP i  in run in PRODUCER " + i);
                    //  System.out.println("PRODUCER RUN QUEUE.SIZE =" + queue.size());
                    //   System.out.println("QUEUE.ELEMENT[0] = " + queue.element()[0]);
                    //    System.out.println("QUEUE.ELEMENT[1] = " + queue.element()[1]);
                    //   System.out.println("QUEUE.ELEMENT[2] = " + queue.element()[2]);
                    //   System.out.println("QUEUE.ELEMENT[3] = " + queue.element()[3]);
                    //   System.out.println("QUEUE.ELEMENT[4] = " + queue.element()[4]);
                    // System.out.println("QUEUE.ELEMENT[5] = " + queue.element()[5]);
                    //   System.out.println("IN PRODCUER CONSTRUCTOR QUEUE.SIZE() = " + LENGTH);
                    //   System.out.println("\n");
                }
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }
        catch (IndexOutOfBoundsException f)
        {
            System.out.println("FINAL QUEUE>SIZE() = "+ queue.size() + "++++++++++++++++++++++++++++");
            System.out.println("OUT OF BOUNDS EXCEPTION");
        }
        catch (NoSuchElementException g)
        {
            System.out.println("no susch element exception");
        }
        return queue;
    }

}
