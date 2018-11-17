public class OrGate extends LogicGate {

    @Override
    public void doOperation() {
        output.clear();

        Signal inputA = this.input.get(0);
        Signal inputB = this.input.get(1);
        Signal outputC = new Signal((inputA.isState() || inputB.isState()));
        this.output.add(outputC);
    }
}
