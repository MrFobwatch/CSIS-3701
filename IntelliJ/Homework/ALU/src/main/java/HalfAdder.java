import java.util.LinkedList;
import java.util.ListIterator;

public class HalfAdder implements Component {
    LinkedList<Signal> outputList = new LinkedList<>();
    Signal A;
    Signal B;
    Signal Sum;
    Signal Cout;
    XorGate XOR;
    AndGate AND;

    public void receiveInput(Signal inputA, Signal inputB) {
        A = inputA;
        B = inputB;
    }

    @Override
    public ListIterator returnOutputs() {
        return outputList.listIterator();
    }

    @Override
    public void doOperation() {
        XOR.receiveInput(A, B);
        XOR.doOperation();
        Sum = XOR.getResult();
        AND.receiveInput(A, B);
        AND.doOperation();
        Cout = AND.getResult();
    }

    public Signal getSum() {
        return Sum;
    }

    public Signal getCout() {
        return Cout;
    }
}
