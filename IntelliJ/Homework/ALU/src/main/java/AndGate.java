public class AndGate extends LogicGate {
    Signal A;
    Signal B;
    Signal C;

    public AndGate() {
        super(2);
        C = new Signal();
        B = new Signal();
        A = new Signal();
    }

    public AndGate(int inputPortCount) {
        super(inputPortCount);
        C = new Signal();
        B = new Signal();
        A = new Signal();
    }

    public void receiveInput(Signal inputA, Signal inputB) {
        A = inputA;
        B = inputB;
    }

    @Override
    public void doOperation() {
	    C.changeState(A.isState() && B.isState());
    }

    @Override
    public Signal getResult() {
        return C;
    }
}
