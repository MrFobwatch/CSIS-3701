public class NandGate extends AndGate {

    @Override
    public void doOperation() {
        C.changeState(A.isState() && B.isState());
        C.changeState(!C.isState());

    }
}
