import java.util.LinkedList;
import java.util.ListIterator;

public abstract class LogicGate {
   LinkedList<Signal> input = new LinkedList<>();
   LinkedList<Signal> output = input;

    private int inputCount;
    private int outputCount;

    //    public abstract void setInputs();

    public abstract void doOperation();

    public LogicGate() {
        inputCount = 1;
        outputCount = 1;
    }

    public LogicGate(int inputPortCount, int outputPortCount) {
        inputCount = inputPortCount;
        outputCount = outputPortCount;
    }

    public LinkedList<Signal> getOutputs() {
        return output;
    }

    public LinkedList<Signal> receiveInputs(ListIterator<Signal> incomingSignals) {
        while (incomingSignals.hasNext()) {
            input.add(incomingSignals.next());
        }
        return input;
    }

    public Signal getOutputAtPort(int port) {
        return output.get(port);
    }

}
