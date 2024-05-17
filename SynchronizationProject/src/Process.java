import java.util.Comparator;

public class Process implements Comparable {
    private int id;
    private int priotity;
    private int index;
    private Double value;
    private char operation;
    
    public Process(int priotity, int id, int index, Double value, char operation) {
    this.priotity = priotity;
    this.id = id;
    this.index = index;
    this.operation = operation;
    this.value = value;
  }

    public int getId() {
        return id;
    }

    public int getpriotity() {
        return priotity;
    }

    public char getOperation() {
        return operation;
    }

    public Double getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }


    @Override
    public int compareTo(Object t) {
        return Comparator.comparingInt(Process::getpriotity)
              .compare(this, (Process) t); 
    }
    
}