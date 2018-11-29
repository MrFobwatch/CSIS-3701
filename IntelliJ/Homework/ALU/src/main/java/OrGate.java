public class OrGate extends LogicGate {
    Signal A;
    Signal B;
    Signal C;

    public OrGate() {
        super(2);
    }

    public OrGate(int inputPortCount) {
        super(inputPortCount);
    }

    @Override
    public void doOperation() {
        C.changeState(A.isState() || B.isState());
    }

    @Override
    public Signal getResult() {
        return C;
    }

    public void receiveInput(Signal inputA, Signal inputB) {
        this.A = inputA;
        this.B = inputB;
    }
}
