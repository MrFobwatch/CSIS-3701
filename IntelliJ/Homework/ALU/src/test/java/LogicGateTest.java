import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class LogicGateTest {
    //    abstract LogicGate createLogicGate();
    //    @Mock LinkedList<Signal> testInput;
    //    @Mock LinkedList<Signal> output;
    //    @InjectMocks LogicGate logicGate;

    @Mock Signal testSignal;

    private LogicGate logicGate;
    @Mock LinkedList<Signal> testInput = new LinkedList<>();
    @Mock LinkedList<Signal> testOutput = new LinkedList<>();

    @Before
    public void setUp() {
        testInput.add(new Signal(true));
        testInput.add(new Signal(false));
        testInput.add(new Signal(true));
        testOutput.add(new Signal(true));
        testOutput.add(new Signal(false));
        testOutput.add(new Signal(true));
        testSignal = testInput.getFirst();


        this.logicGate =
                new LogicGate() {
                    Signal currentSignal;
                    @Override
                    public void doOperation() {
//                        logicGate.output = logicGate.input;
                    }

                    @Override
                    public Signal getResult() {
                        return currentSignal;
                    }
                    @Override
                    public void receiveInput(Signal input) {
                        this.currentSignal = input;
                    }
                };
    }

    @Test
    public void testReceiveInputs() {
//        Signal result[] = new Signal[testInput.size()];
//        logicGate.receiveInputs(testInput.listIterator());
//        logicGate.input.toArray(result);
//        assertThat(result, is(equalTo(testInput.toArray())));
    }

    @Test
    public void testGetOutputAtPort() {
//        logicGate.receiveInputs(testInput.listIterator());
//        logicGate.doOperation();
//        Signal result = logicGate.getOutputAtPort(0);
//        assertThat(result.getValue(), is(equalTo(testOutput.get(0).getValue())));
    }

    @Test
    public void testGetOutputs() {
//        logicGate.receiveInputs(testInput.listIterator());
//        logicGate.doOperation();
//        LinkedList<Signal> outputs = logicGate.getOutputs();
//        int index = 0;
//        for (Iterator<Signal> iterator = outputs.iterator(); iterator.hasNext(); ) {
//            Signal result = iterator.next();
//            assertThat(result.getValue(), is(equalTo(testOutput.get(index++).getValue())));
//        }
    }

    @Test
    public void testGetResult(){
        logicGate.receiveInput(testSignal);
        logicGate.doOperation();
        Signal result = logicGate.getResult();
        assertThat(result.isState(), is(equalTo(testSignal.isState())));

    }
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
