public class AndGate extends LogicGate {
    Signal A;
    Signal B;
    Signal C;

    public AndGate() {
        super(2);
    }

    public AndGate(int inputPortCount) {
        super(inputPortCount);
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
