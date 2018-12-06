import java.util.ListIterator;
import java.util.Vector;

public class MultiBitAdderSubtractor implements Component {
    Vector<FullAdder> fullAdders = new Vector<>();
    Vector<XorGate> xorGates = new Vector<>();
    Vector<Signal> inputAs = new Vector<>();
    Vector<Signal> inputBs = new Vector<>();
    Signal Cin = new Signal(); // Used for 2s Complement
    Signal Cout;

    public MultiBitAdderSubtractor(int numberOfBits) {
        fullAdders.setSize(numberOfBits);
        xorGates.setSize(numberOfBits);
        Cin.changeState(false);
    }

    public void receiveInputs(Signal... inputs) { // Load Values into Gates

        for (int bitCount = 0; bitCount < inputs.length / 2; bitCount++) {
            Signal A = inputs[bitCount];
            Signal B = inputs[bitCount + inputs.length / 2];
            FullAdder adder = new FullAdder();
            XorGate xorGate = new XorGate();
            if (bitCount == 0) {
                xorGate.receiveInput(B, Cin);
//                xorGate.doOperation(); // running this just to be safe
                adder.receiveInput(A, xorGate.getResult(), Cin);
            } else {
                adder.receiveInput(
                        A,
                        xorGate.getResult(),
                        fullAdders.get(bitCount - 1).Cout); // Get previous Cout and pipe to Cin
            }
            xorGates.set(bitCount, xorGate);
            fullAdders.set(bitCount, adder);
        }
    }

    public void enableSubtraction() {
        Cin.changeState(true);
    }

    public void enableAddition(){
    	Cin.changeState(false);
    }

    @Override
    public void doOperation() { //should only be called after receiveInput
    	for (XorGate xorGate : xorGates){
    		xorGate.doOperation();
	    }
    	for (FullAdder fullAdder : fullAdders){
    		fullAdder.doOperation();
	    }
    }

    @Override
    public ListIterator returnOutputs() {
        return null;
    }
}
