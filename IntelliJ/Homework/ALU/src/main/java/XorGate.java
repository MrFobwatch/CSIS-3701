public class XorGate extends LogicGate {
    Signal A;
    Signal B;
    Signal C;

    public XorGate() {
        super(2);
    }

    public XorGate(int inputPortCount) {
        super(inputPortCount);
    }

    public void receiveInput(Signal inputA, Signal inputB) {
        A = inputA;
        B = inputB;
        C = new Signal(true);
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
