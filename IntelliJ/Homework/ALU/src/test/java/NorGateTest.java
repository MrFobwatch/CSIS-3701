import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Arrays;
import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class NorGateTest {
    @Spy LinkedList<Signal> testInput;
    @Spy LinkedList<Signal> testOutput;
    @InjectMocks NorGate norGate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        testInput.add(new Signal(true));
        testInput.add(new Signal(true));
        testOutput.add(new Signal(false));
    }

    @Test
    public void testDoOperation() throws Exception {
	    norGate.receiveInputs(testInput.listIterator());
	    norGate.doOperation();
	    Signal result = norGate.getOutputAtPort(0);
	    assertThat(result.getValue(), is(equalTo(testOutput.get(0).getValue())));
    }

}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
