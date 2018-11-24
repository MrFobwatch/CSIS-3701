public class XorGate extends LogicGate {

    @Override
    public void doOperation() {
        output.clear();
        int index = 0;
        while (index < this.input.size()) {
            Signal inputA = this.input.get(index++);
            Signal inputB = this.input.get(index++);
            boolean condition =
                    ((inputA.isState() || inputB.isState())
                            && (!inputA.isState() || !inputB.isState()));
            Signal outputC = new Signal(condition);
            this.output.add(outputC);
        }
    }
}
