import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class FullAdder implements Component {
    List<Signal> outputList = new ArrayList<>();
    HalfAdder halfAdderA;
    HalfAdder halfAdderB;
    Signal A;
    Signal B;
    Signal Cin = new Signal();
    Signal Sum = new Signal();
    Signal Cout = new Signal();
    OrGate orGate = new OrGate();

    public FullAdder() {
        A = new Signal();
        B = new Signal();
        halfAdderB = new HalfAdder();
        halfAdderA = new HalfAdder();
//        halfAdderA = new HalfAdder(A, B);
//        halfAdderB = new HalfAdder(A, B);
    }

    public FullAdder(Signal a, Signal b, Signal cin) {
        A = a;
        B = b;
        Cin = cin;
        halfAdderA = new HalfAdder(A, B);
        halfAdderB = new HalfAdder(A, B);
//                halfAdderA = new HalfAdder();
//                halfAdderB = new HalfAdder();

    }

    public void receiveInput(Signal inputA, Signal inputB, Signal inputCin) {
        A = inputA;
        B = inputB;
        Cin = inputCin;
    }

    public void receiveInput(Signal inputA, Signal inputB) {
        A = inputA;
        B = inputB;
    }

    @Override
    public void doOperation() {
        halfAdderA.receiveInput(A, B);
        halfAdderA.doOperation();
        halfAdderB.receiveInput(Cin, halfAdderA.getSum());
        halfAdderB.doOperation();
        Sum = halfAdderB.getSum();
        orGate.receiveInput(halfAdderA.getCout(), halfAdderB.getCout());
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
