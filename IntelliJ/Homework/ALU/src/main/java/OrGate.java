public class OrGate extends LogicGate {
    Signal A;
    Signal B;
    Signal C;

    public OrGate() {
        super(2);
        C = new Signal();
        B = new Signal();
        A = new Signal();
    }

    public OrGate(int inputPortCount) {
        super(inputPortCount);
        C = new Signal();
        B = new Signal();
        A = new Signal();
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
