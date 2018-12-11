import java.util.LinkedList;

public abstract class LogicGate {
    //    LinkedList<Signal> input = new LinkedList<>();
    //    LinkedList<Signal> output = new LinkedList<>();
    LinkedList<Signal> ports = new LinkedList<Signal>();
    private int inputPortCount;

    public LogicGate() {}

    public LogicGate(int inputPortCount) {
        this.inputPortCount = inputPortCount;
        for (int portNumber = 0; portNumber < inputPortCount + 1; portNumber++) {
            ports.add(new Signal());
        }
    }

    public LogicGate(int inputPortCount, int outputPortCount) {
        this.inputPortCount = inputPortCount;
        for (int portNumber = 0; portNumber < inputPortCount + outputPortCount; portNumber++) {
            ports.add(new Signal());
        }
    }

    public abstract void doOperation();

    public abstract Signal getResult();

    public Signal getOutput() {
        return ports.getLast();
    }

    public Signal getOutputAtPort(int port) {
        return ports.get(inputPortCount + port);
    }

    public void receiveInput(Signal inputSignal) {
        ports.set(0, inputSignal);
    }
}
