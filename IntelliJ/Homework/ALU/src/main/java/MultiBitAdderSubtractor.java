import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MultiBitAdderSubtractor implements Component {
    List<FullAdder> fullAdders = new ArrayList<>();
    List<XorGate> xorGates = new ArrayList<>();
    List<Signal> inputAs = new ArrayList<>();
    List<Signal> inputBs = new ArrayList<>();
    Signal Cin = new Signal(); // Used for 2s Complement
    Signal Cout;

    public MultiBitAdderSubtractor(int numberOfBits) {
        Cin.changeState(false);
    }

    public void receiveInputs(Signal... inputs) { // Load Values into Gates
        xorGates.clear();
        fullAdders.clear();
        inputAs.clear();
        inputBs.clear();
        for (int bitCount = 0; bitCount < (inputs.length / 2); bitCount++) {
            Signal A = inputs[bitCount];
            Signal B = inputs[bitCount + inputs.length / 2];
            setGateInputs(bitCount, A, B, Cin, fullAdders, xorGates);
            inputAs.add(A);
            inputBs.add(B);
        }
    }

    private static void setGateInputs(
            int bitCount,
            Signal a,
            Signal b,
            Signal cin,
            List<FullAdder> fullAdders,
            List<XorGate> xorGates) {
        FullAdder adder = new FullAdder();
        XorGate xorGate = new XorGate();
        if (bitCount == 0) {
            xorGate.receiveInput(b, cin);
            xorGate.doOperation();
            //                xorGate.doOperation(); // running this just to be safe
            adder.receiveInput(a, xorGate.getResult(), cin);
        } else {
            adder.receiveInput(
                    a,
                    xorGate.getResult(),
                    fullAdders.get(bitCount - 1).Cout); // Get previous Cout and pipe to Cin
        }
        xorGates.add(xorGate);
        fullAdders.add(adder);
    }

    public void receiveInputs(List<Signal> inputs) {
        xorGates.clear();
        fullAdders.clear();
        for (int bitCount = 0; bitCount < inputs.size() / 2; bitCount++) {
            Signal A = inputs.get(bitCount);
            Signal B = inputs.get(bitCount + inputs.size() / 2);
            setGateInputs(bitCount, A, B, Cin, fullAdders, xorGates);
            inputAs.add(A);
            inputBs.add(B);
        }
    }

    public void enableSubtraction() {
        Cin.changeState(true);
    }

    public void enableAddition() {
        Cin.changeState(false);
    }

    @Override
    public void doOperation() { // should only be called after receiveInput
        for (XorGate thisXorGate : xorGates) {
            thisXorGate.doOperation();
        }
        for (FullAdder thisfullAdder : fullAdders) {
            thisfullAdder.doOperation();
        }
    }

    @Override
    public ListIterator returnOutputs() {
        return fullAdders.listIterator();
    }

    public Signal getCout() {
        return Cout;
    }

    public List<Signal> getInputAs() {
        return inputAs;
    }

    public List<Signal> getInputBs() {
        return inputBs;
    }

    @Override
    public String toString() {
        return "MultiBitAdderSubtractor{" +
                       "fullAdders=" + fullAdders +
                       ", xorGates=" + xorGates +
                       ", inputAs=" + inputAs +
                       ", inputBs=" + inputBs +
                       ", Cin=" + Cin +
                       ", Cout=" + Cout +
                       '}';
    }
}
