public class OrGate extends LogicGate {
    private Signal inputA;
    private Signal inputB;
    private Signal outputC;

    public OrGate() {
        super(2);
    }

    public OrGate(int inputPortCount) {
        super(inputPortCount);
    }

    @Override
    public void doOperation() {
        //        output.clear();
        //        inputA = this.input.get(0);
        //        inputB = this.input.get(1);
        //        outputC = new Signal((inputA.isState() || inputB.isState()));
        //        this.output.add(outputC);
    }

    @Override
    public Signal getResult() {
        return outputC;
    }

    public void receiveInputs(Signal inputA, Signal inputB) {
        this.inputA = inputA;
        this.inputB = inputB;
    }
}
