import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class NandGateTest {
	@Spy LinkedList<Signal> testInput;
	@Spy LinkedList<Signal> testOutput;
	@InjectMocks
	NandGate nandGate;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		testInput.add(new Signal(true));
		testInput.add(new Signal(true));
		testOutput.add(new Signal(false));
	}

//    @Test
//    public void testReceiveInputs() {
//        LinkedList<Signal> result = nandGate.receiveInputs(testInput.listIterator());
//        assertThat(result, is(equalTo(testInput)));
//    }

	@Test
	public void testDoOperation() {
		nandGate.receiveInputs(testInput.listIterator());
		nandGate.doOperation();
		Signal result = nandGate.getOutputAtPort(0);
		assertThat(result.getValue(), is(equalTo(testOutput.get(0).getValue())));
	}

//    @Test
//    public void testGetOutputAtPort() {
//        nandGate.receiveInputs(testInput.listIterator());
//        nandGate.doOperation();
//        Signal result = nandGate.getOutputAtPort(0);
//        assertThat(result.getValue(), is(equalTo(testOutput.get(0).getValue())));
//    }

//    @Test
//	public void testGetOutputs(){
//    	nandGate.receiveInputs(testInput.listIterator());
//    	nandGate.doOperation();
//    	LinkedList<Signal> result = nandGate.getOutputs();
//    	assertThat(result.getLast().getValue(), is(equalTo(testOutput.getLast().getValue())));
//    }
}
