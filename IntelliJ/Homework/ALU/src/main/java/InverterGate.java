public class InverterGate extends LogicGate {
    Signal Q;
    Signal notQ;

    public InverterGate() {
        super(1);
    }

    public void receiveInput(Signal inputQ) {
        Q = inputQ;
    }

    public void doOperation() {
        notQ = new Signal(!Q.isState());
    }

    @Override
    public Signal getResult() {
        return notQ;
    }
}
