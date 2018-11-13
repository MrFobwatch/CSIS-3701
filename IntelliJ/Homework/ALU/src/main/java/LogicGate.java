import java.util.LinkedList;
import java.util.ListIterator;

public abstract class LogicGate {
    private LinkedList<Signal> input = new LinkedList<>();
    private LinkedList<Signal> output = new LinkedList<>();

    private int inputCount;
    private int outputCount;

//    public abstract void setInputs();

    public abstract void doOperation();

    public LogicGate(int inputPortCount, int outputPortCount){
    	inputCount = inputPortCount;
    	outputCount = outputPortCount;
    }
    public ListIterator<Signal> getOutputs() {
        return output.listIterator();
    }

    public Signal getOutputAtPort(int port) {
        return input.get(port);
    }
}
