import java.util.LinkedList;
import java.util.ListIterator;

public class HalfAdder implements Component {
	LinkedList<Signal> outputList = new LinkedList<>();
	Signal A;
	Signal B;
	Signal Sum;
	Signal Cout;
	XorGate XOR;
	AndGate AND;


	public void receiveInput(Signal inputA, Signal inputB)  {
		A = inputA;
		B = inputB;
	}

	@Override
	public ListIterator returnOutputs() {
		return outputList.listIterator();
	}

	@Override
	public void doOperation() {
		XOR.input.clear();
		XOR.input.add(A);
		XOR.input.add(B);
		XOR.doOperation();
		Sum = XOR.getOutputAtPort(0);

		AND.input.clear();
		AND.input.add(A);
		AND.input.add(B);
		AND.doOperation();
		Cout = AND.getOutputAtPort(0);
	}

	public Signal getSum() {
		return Sum;
	}

	public Signal getCout() {
		return Cout;
	}
}
