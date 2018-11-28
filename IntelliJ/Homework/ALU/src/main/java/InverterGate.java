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
        //        output.clear();
        //        int index = 0;
        //        for (Signal currentInput : this.input) {
        //            boolean currentState = currentInput.isState();
        //            Signal output = new Signal(!currentState);
        //            this.output.add(index++, output);
        //        }
        notQ = new Signal(!Q.isState());
    }

    @Override
    public Signal getResult() {
        return notQ;
    }
}
