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

    private LogicGate logicGate;
    @Mock LinkedList<Signal> testInput = new LinkedList<>();

    @Before
    public void setUp() {
        testInput.add(new Signal(true));
        testInput.add(new Signal(false));
        testInput.add(new Signal(true));

        this.logicGate =
                new LogicGate() {
                    @Override
                    public void doOperation() {
                        logicGate.output = logicGate.input;
                    }
                };
    }

    @Test
    public void testGetOutputs() {
        Signal result[] = new Signal[testInput.size()];
        logicGate.receiveInputs(testInput.listIterator());
        logicGate.getOutputs().toArray(result);
        assertThat(result,is(equalTo( testInput.toArray())));
    }

    @Test
    public void testGetOutputAtPort() {
        logicGate.receiveInputs(testInput.listIterator());
        Signal result = logicGate.getOutputAtPort(0);
        assertThat(result,is(equalTo( testInput.get(0))));
    }

    @Test
    public void testReceiveInputs() {
        Signal result[] = new Signal[testInput.size()];
        logicGate.receiveInputs(testInput.listIterator());
        logicGate.input.toArray(result);
        assertThat(result, is(equalTo(testInput.toArray())));
    }
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
