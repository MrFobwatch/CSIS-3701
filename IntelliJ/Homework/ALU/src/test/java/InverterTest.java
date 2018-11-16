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

public class InverterTest {
	@Spy
	LinkedList<Signal> testInput;
	@Spy
	LinkedList<Signal> testOutput;
	@InjectMocks
	Inverter inverter;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		testInput.add(new Signal(true));
		testOutput.add(new Signal(true));
	}

	@Test
	public void testDoOperation() {
		Signal correctOutput = new Signal(false);
		inverter.receiveInputs(testInput.listIterator());
		inverter.doOperation();
		// test the output List directly vs using the class method
		Signal result = inverter.getOutputAtPort(0);
		assertThat(result.getValue(), is(equalTo(correctOutput.getValue())));
	}

	@Test
	public void testReceiveInputs() {
		LinkedList<Signal> result = inverter.receiveInputs(testInput.listIterator());
		assertThat(result, is(equalTo(testInput)));
	}

	@Test
	public void testGetOutputAtPort() {
//		inverter.input.add(new Signal(true));
		inverter.receiveInputs(testInput.listIterator());
		Signal result = inverter.getOutputAtPort(0);
		assertThat(result.getValue(), is(equalTo(testInput.get(0).getValue())));
	}

	@Test
	public void testGetOutputs() {
		inverter.receiveInputs(testInput.listIterator());
		LinkedList<Signal> result = inverter.getOutputs();
		assertThat(result, is(equalTo(testInput)));
	}
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
