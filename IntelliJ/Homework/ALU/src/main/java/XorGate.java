
public class XorGate extends LogicGate {
	Signal A;
	Signal B;
	Signal C;

	public XorGate() {
		super(2);
		C = new Signal();
		B = new Signal();
		A = new Signal();
	}

	public XorGate(int inputPortCount) {
		super(inputPortCount);
		C = new Signal();
		B = new Signal();
		A = new Signal();

	}

	public void receiveInput(Signal inputA, Signal inputB) {
		A = inputA;
		B = inputB;
		doOperation();
	}

	@Override
	public void doOperation() {
		C.changeState((A.isState() || B.isState()) && (!A.isState() || !B.isState()));
	}

	@Override
	public Signal getResult() {
		return C;
	}
}
