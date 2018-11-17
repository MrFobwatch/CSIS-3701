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
		testOutput.add(new Signal(false));
	}

	@Test
	public void testDoOperation() {
		inverter.receiveInputs(testInput.listIterator());
		inverter.doOperation();
		Signal result = inverter.getOutputAtPort(0);
		assertThat(result.getValue(), is(equalTo(testOutput.get(0).getValue())));
	}

	@Test
	public void testReceiveInputs() {
		LinkedList<Signal> result = inverter.receiveInputs(testInput.listIterator());
		assertThat(result, is(equalTo(testInput)));
	}

	@Test
	public void testGetOutputAtPort() {
		inverter.input.add(new Signal(true));
		inverter.doOperation();
		//		inverter.receiveInputs(testInput.listIterator());
		Signal result = inverter.getOutputAtPort(0);
		assertThat(result.getValue(), is(equalTo(testOutput.get(0).getValue())));
	}

	@Test
	public void testGetOutputs() {
		inverter.receiveInputs(testInput.listIterator());
		inverter.doOperation();
		LinkedList<Signal> result = inverter.getOutputs();
		assertThat(
				result.getLast().getValue(),
				is(equalTo(testOutput.getLast().getValue())));
	}
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
