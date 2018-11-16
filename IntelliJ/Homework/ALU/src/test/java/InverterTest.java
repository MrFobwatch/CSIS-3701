// import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class InverterTest {
	@Mock
	LinkedList<Signal> testInput;
	@Mock
	LinkedList<Signal> testOutput;
	@InjectMocks
	Inverter inverter;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		testInput.add(new Signal(true));
		testInput.add(new Signal(false));
		testInput.add(new Signal(true));
	}

	@Test
	public void testDoOperation() {
		inverter.doOperation();
		// test the output List directly vs using the class method
		Signal result = testOutput.peekFirst();
		assertThat(result, is(equalTo(new Signal(false))));
	}

	@Test
	public void testReceiveInputs() {
		LinkedList<Signal> result = inverter.receiveInputs(testInput.listIterator());
		assertThat(result, is(equalTo(testInput)));
	}

	@Test
	public void testGetOutputAtPort() {
		Signal result = inverter.getOutputAtPort(0);
		assertThat(result, is(equalTo(new Signal(false))));
	}

	@Test
	public void testGetOutputs() {
		LinkedList<Signal> correctOutput = new LinkedList<>();
		correctOutput.add(new Signal(false));
		correctOutput.add(new Signal(true));
		correctOutput.add(new Signal(false));
		LinkedList<Signal> result = inverter.getOutputs();
		assertThat(result, is(equalTo(correctOutput)));
	}
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
