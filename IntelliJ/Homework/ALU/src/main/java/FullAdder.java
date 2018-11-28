import java.util.LinkedList;
import java.util.ListIterator;

public class FullAdder implements Component {
    LinkedList<Signal> outputList = new LinkedList<>();
    HalfAdder halfAdderA;
    HalfAdder halfAdderB;
    Signal A;
    Signal B;
    Signal Cin;
    Signal Sum;
    Signal Cout;
    OrGate orGate;

    public void receiveInput(Signal inputA, Signal inputB, Signal inputCin) {
        A = inputA;
        B = inputB;
        Cin = inputCin;
    }

    @Override
    public void doOperation() {
        halfAdderA.receiveInput(A, B);
        halfAdderA.doOperation();
        halfAdderB.receiveInput(Cin, halfAdderA.getSum());
        halfAdderB.doOperation();
        Sum = halfAdderB.getSum();

        orGate.receiveInputs(halfAdderA.getCout(), halfAdderB.getCout());
        orGate.doOperation();
        Cout = orGate.getResult();
    }

    @Override
    public ListIterator returnOutputs() {
        return outputList.listIterator();
    }

    public Signal getCout() {
        return Cout;
    }

    public Signal getSum() {
        return Sum;
    }
}
