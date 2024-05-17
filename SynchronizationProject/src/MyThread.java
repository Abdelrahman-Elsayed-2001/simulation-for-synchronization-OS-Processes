import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class MyThread extends Thread {


@Override
public void run(){

    Iterator mapIterator = App.multiValueMapProcess.entrySet().iterator();

    ArrayList<Integer> keys=new ArrayList<Integer>();

    while (mapIterator.hasNext()) {

        Map.Entry mapElement = (Map.Entry) mapIterator.next();
        keys.add((int) mapElement.getKey());

    }
    
    

    int ThredID= Integer.parseInt(Thread.currentThread().getName());


    try {
        System.out.println("Thread with ID: "+ThredID 
        +", is responsible for Execution of the Process's operations on the array at indecies: "
        +keys.get(ThredID)+" and "+keys.get(ThredID+1));
    } catch (Exception e) {
        System.out.println("Thread with ID: "+ThredID
        +", is responsible for Execution of the Process's operations on the array at index: "
        +keys.get(ThredID));
    }


    try {
        ImplementOperation(App.multiValueMapProcess.get(keys.get(ThredID)),keys.get(ThredID));
    } catch (Exception e) {}

    try {
        ImplementOperation(App.multiValueMapProcess.get(keys.get(ThredID+1)),keys.get(ThredID+1));
    } catch (Exception e) {}


}

    private void ImplementOperation(ArrayList<Process> currentQueue,int index){
    
            for (int i = 0; i < currentQueue.size(); i++) {
                char o=currentQueue.get(i).getOperation();
                switch (o) {
                    case '+':
                    App.data[index]=currentQueue.get(i).getValue()+App.data[index];
                    System.out.println("the Thread with ID: "+Thread.currentThread().getName() +" changed the value in index of array "+index);
                        break;
    
                    case '-':
                    App.data[index]=App.data[index]-currentQueue.get(i).getValue();
                    System.out.println("the Thread with ID: "+Thread.currentThread().getName() +" changed the value in index of array "+index);
                        break;
    
                    case '/':
                    App.data[index]=App.data[index]/currentQueue.get(i).getValue();
                    System.out.println("the Thread with ID: "+Thread.currentThread().getName() +" changed the value in index of array "+index);
                        break;
    
                    case '*':
                    App.data[index]=currentQueue.get(i).getValue()*App.data[index];
                    System.out.println("the Thread with ID: "+Thread.currentThread().getName() +" changed the value in index of array "+index);
                        break;
    
                    default:
                    System.out.println("Sory Somthing Erorr \n Try Again");
                        break;
                }
            }
    }
}