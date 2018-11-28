public class XnorGate extends XorGate {

    @Override
    public void doOperation() {
        C.changeState(((A.isState() || B.isState()) && (!A.isState() || !B.isState())));
        C.changeState(!C.isState());
    }
}
