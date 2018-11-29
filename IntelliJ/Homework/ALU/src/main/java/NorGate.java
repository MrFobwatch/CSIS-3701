public class NorGate extends OrGate {

    @Override
    public void doOperation() {
        C.changeState(!(A.isState() || B.isState()));
    }
}
