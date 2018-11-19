public class AndGate extends LogicGate {

    @Override
    public void doOperation() {
        output.clear();
        int index = 0;
//        for (Signal currentInput: this.input) {
//            boolean currentState = currentInput.isState();
//            Signal output = new Signal(!currentState);
//            this.output.add(index++, output);
//        }

        Signal inputA = this.input.get(0);
        Signal inputB = this.input.get(1);
        boolean condition = inputA.isState() && inputB.isState();
        Signal outputC = new Signal(condition);
        this.output.add(outputC);
    }
}
