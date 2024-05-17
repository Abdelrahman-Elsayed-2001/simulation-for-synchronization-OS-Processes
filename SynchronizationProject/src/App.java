import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class App {

    public static ArrayList<MyThread> ArrayListThread = new ArrayList<MyThread> ();
    public static TreeMap<Integer, ArrayList<Process>> multiValueMapProcess = new TreeMap<Integer, ArrayList<Process>>();
    
    public static double [] data= {5,3,4,2,7};

    public static void main(String[] args) {

        System.out.println("The array before Altering: ");
        for (int index = 0; index < data.length; index++) {
            System.out.print(data[index]+", ");
        }    
        System.out.println();

        enterProcess();

        System.out.println("\n\nsequence of execution of threads:");


        int c=0;
        for (int i=0; i<multiValueMapProcess.size(); i=i+2){
            MyThread t= new MyThread();
            t.setName(""+i);
            t.start();
            ArrayListThread.add(t);
            c++;
        }


        for (MyThread thread : ArrayListThread) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("The array After Altering: ");
        for (int index = 0; index < data.length; index++) {
            System.out.print(data[index]+", ");
        }    
        System.out.println();


        
System.out.println(multiValueMapProcess);

System.out.println("Number of Threads : "+c);


    }

    public static void enterProcess(){

        Scanner scanner = new Scanner(System.in);
        char finished='n';
        int id=0;

        try {

            while(finished=='n'){
                System.out.println( "\nEnter the index of the array you want to alter for Process: "+id+", type number from 0 to "+ (data.length-1)+" only" );
                int index = scanner.nextInt();
                System.out.println("Enter the priority of Process: "+id);
                int priority = scanner.nextInt();
                System.out.println("Enter the operation of process "+id+" you want to apply on the array at index, you can use {+} or {-} or {*} or {/} only");
                char operation = scanner.next().charAt(0);
                System.out.println("Enter the value that you want to be applied by the operation on the index of the array you choose for process:  "+id);
                Double value = scanner.nextDouble();
                Process p = new Process(priority, id, index, value, operation);
                id++;
                if (!multiValueMapProcess.containsKey(index)) {
                    multiValueMapProcess.put(index, new ArrayList<Process>());
                }
                multiValueMapProcess.get(index).add(p);

                System.out.print("did you finished? \nn=no y=yes : ");
                finished = Character.toLowerCase( scanner.next().charAt(0) );
            }scanner.close();

        } catch (Exception e) {
            System.out.println("Sory Somthing Erorr \n Try Again");
            enterProcess();
        }
        
        Iterator mapIterator = multiValueMapProcess.entrySet().iterator();

        while (mapIterator.hasNext()) {

            Map.Entry mapElement = (Map.Entry) mapIterator.next();
            ArrayList<Process> currentQueue = ((ArrayList<Process>) mapElement.getValue());
            Collections.sort(currentQueue);

        }
    }
}