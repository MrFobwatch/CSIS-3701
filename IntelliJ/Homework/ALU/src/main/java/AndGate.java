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
        while (index < this.input.size()) {
            Signal inputA = this.input.get(index++);
            Signal inputB = this.input.get(index++);
            boolean condition = inputA.isState() && inputB.isState();
            Signal outputC = new Signal(condition);
            this.output.add(outputC);
        }
    }
}
