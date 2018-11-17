import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AndGateTest {
    @Spy LinkedList<Signal> testInput;
    @Spy LinkedList<Signal> testOutput;
    @InjectMocks AndGate andGate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        testInput.add(new Signal(true));
        testInput.add(new Signal(true));
        testOutput.add(new Signal(true));
    }

//    @Test
//    public void testReceiveInputs() {
//        LinkedList<Signal> result = andGate.receiveInputs(testInput.listIterator());
//        assertThat(result, is(equalTo(testInput)));
//    }

    @Test
    public void testDoOperation() {
        andGate.receiveInputs(testInput.listIterator());
        andGate.doOperation();
        Signal result = andGate.getOutputAtPort(0);
        assertThat(result.getValue(), is(equalTo(testOutput.get(0).getValue())));
    }

//    @Test
//    public void testGetOutputAtPort() {
//        andGate.receiveInputs(testInput.listIterator());
//        andGate.doOperation();
//        Signal result = andGate.getOutputAtPort(0);
//        assertThat(result.getValue(), is(equalTo(testOutput.get(0).getValue())));
//    }

//    @Test
//	public void testGetOutputs(){
//    	andGate.receiveInputs(testInput.listIterator());
//    	andGate.doOperation();
//    	LinkedList<Signal> result = andGate.getOutputs();
//    	assertThat(result.getLast().getValue(), is(equalTo(testOutput.getLast().getValue())));
//    }
}
