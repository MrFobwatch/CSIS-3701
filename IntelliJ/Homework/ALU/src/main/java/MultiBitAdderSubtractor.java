import java.util.ListIterator;
import java.util.Vector;

public class MultiBitAdderSubtractor implements Component {
	Vector<FullAdder> fullAdders = new Vector<>();
	Vector<Signal> inputAs = new Vector<>();
    Vector<Signal> inputBs = new Vector<>();
    Signal Cin = new Signal(); //Used for 2s Complement
    Signal Cout;

	public MultiBitAdderSubtractor(int numberOfBits){
		fullAdders.setSize(numberOfBits);
		Cin.changeState(false);

	}

	public void receiveInputs(Signal...inputs ){ //Load Values into Gates

        for (int bitCount = 0; bitCount < inputs.length/2; bitCount++) {
            Signal A = inputs[bitCount];
            Signal B = inputs[bitCount + inputs.length/2];
            FullAdder adder = new FullAdder();
            if (bitCount==0){
            adder.receiveInput(A, B);}
            else
            	adder.receiveInput(A,B,fullAdders.get(bitCount-1).Cout);
        	fullAdders.set(bitCount, adder);
        }
	}



	@Override
	public void doOperation() {



	}



	@Override
	public ListIterator returnOutputs() {
		return null;
	}
}
