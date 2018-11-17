// import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class InverterGateTest {
    @Spy LinkedList<Signal> testInput;
    @Spy LinkedList<Signal> testOutput;
    @InjectMocks InverterGate inverterGate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        testInput.add(new Signal(true));
        testOutput.add(new Signal(false));
    }

    @Test
    public void testReceiveInputs() {
        LinkedList<Signal> result = inverterGate.receiveInputs(testInput.listIterator());
        assertThat(result, is(equalTo(testInput)));
    }

    @Test
    public void testDoOperation() {
        inverterGate.receiveInputs(testInput.listIterator());
        inverterGate.doOperation();
        // be able to determine output even if output function is broken
        Signal result = inverterGate.output.get(0);
        assertThat(result.getValue(), is(equalTo(testOutput.get(0).getValue())));
    }

    @Test
    public void testGetOutputAtPort() {
        inverterGate.receiveInputs(testInput.listIterator());
        inverterGate.doOperation();
        Signal result = inverterGate.getOutputAtPort(0);
        assertThat(result.getValue(), is(equalTo(testOutput.get(0).getValue())));
    }

    @Test
    public void testGetOutputs() {
        inverterGate.receiveInputs(testInput.listIterator());
        inverterGate.doOperation();
	    LinkedList<Signal> outputs = inverterGate.getOutputs();
	    int index = 0;
	    for (Signal result: outputs) {
		    assertThat(result.getValue(), is(equalTo(testOutput.get(index++).getValue())));
	    }
    }
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
