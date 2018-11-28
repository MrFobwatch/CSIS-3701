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
    }

    @Override
    public void doOperation() {
        Signal C = new Signal(((A.isState() || B.isState()) && (!A.isState() || !B.isState())));
    }

    @Override
    public Signal getResult() {
        return C;
    }
}
