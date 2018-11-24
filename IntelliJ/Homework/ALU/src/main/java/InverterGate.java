public class InverterGate extends LogicGate {
    public InverterGate() {
        super(1, 1);
    }

    public void doOperation() {
        output.clear();
        int index = 0;
        for (Signal currentInput : this.input) {
            boolean currentState = currentInput.isState();
            Signal output = new Signal(!currentState);
            this.output.add(index++, output);
        }
    }
}
