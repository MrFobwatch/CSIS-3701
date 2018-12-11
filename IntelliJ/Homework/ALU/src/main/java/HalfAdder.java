import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class HalfAdder implements Component {
    List<Signal> outputList = new ArrayList<>();
    Signal A = new Signal();
    Signal B= new Signal();
    Signal Sum;//= new Signal();
    Signal Cout;// = new Signal();
    XorGate XOR = new XorGate();
    AndGate AND = new AndGate();

    public HalfAdder(){
    	A = new Signal();
    	B = new Signal();
    	XOR.receiveInput(A, B);
    	AND.receiveInput(A, B);

    }

    public HalfAdder(Signal a, Signal b) {
    	A.receive(a.getValue());
        B.receive(b.getValue());
//	    XOR.receiveInput(A, B);
//	    AND.receiveInput(A, B);

        //        XOR =  new XorGate();
        //        AND = new AndGate();
    }

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
