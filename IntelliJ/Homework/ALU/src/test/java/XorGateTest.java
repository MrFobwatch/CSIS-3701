import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class XorGateTest {
    @Spy LinkedList<Signal> testInput;
    @Spy LinkedList<Signal> testOutput;
    @InjectMocks XorGate xorGate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        testInput.add(new Signal(false));
        testInput.add(new Signal(false)); // two positions at a time are taken

        testInput.add((new Signal(true)));
        testInput.add((new Signal(false)));

        testInput.add((new Signal(false)));
        testInput.add((new Signal(true)));

        testInput.add(new Signal(true));
        testInput.add(new Signal(true));

		testOutput.add(new Signal(false));
		testOutput.add(new Signal(true));
		testOutput.add(new Signal(true));
		testOutput.add(new Signal(false));
	}

    @Test
    public void testDoOperation() throws Exception {
        xorGate.receiveInputs(testInput.listIterator());
        xorGate.doOperation();
        Signal result = xorGate.getOutputAtPort(0);
        assertThat(result.getValue(), is(equalTo(testOutput.get(0).getValue())));
        result = xorGate.getOutputAtPort(1);
        assertThat(result.getValue(), is(equalTo(testOutput.get(1).getValue())));
        result = xorGate.getOutputAtPort(2);
        assertThat(result.getValue(), is(equalTo(testOutput.get(2).getValue())));
        result = xorGate.getOutputAtPort(3);
        assertThat(result.getValue(), is(equalTo(testOutput.get(3).getValue())));
    }

    //    @Test
    //    public void testReceiveInputs() throws Exception {
    //        LinkedList<Signal> result = xorGate.receiveInputs(null);
    //        Assert.assertEquals(new LinkedList<Signal>(Arrays.asList(new Signal(true))), result);
    //    }
    //
    //    @Test
    //    public void testGetOutputAtPort() throws Exception {
    //        Signal result = xorGate.getOutputAtPort(0);
    //        Assert.assertEquals(new Signal(true), result);
    //    }
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
