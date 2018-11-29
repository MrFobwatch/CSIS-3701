import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class XnorGateTest {
	@Mock Signal A;
	@Mock Signal B;
	@Mock Signal C;
	@Mock LinkedList<Signal> ports;
	@InjectMocks XnorGate xnorGate;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testReceiveInput() throws Exception {
		Signal testInput = new Signal(true);
		xnorGate.receiveInput(testInput, testInput);
		Signal result = xnorGate.A;
		assertThat(result, sameInstance(testInput));
		result = xnorGate.B;
		assertThat(result, sameInstance(testInput));
	}

	@Test
	public void testDoOperation00() throws Exception {
		when(A.isState()).thenReturn(false);
		when(B.isState()).thenReturn(false);
		doCallRealMethod().when(C).changeState(anyBoolean());
		doCallRealMethod().when(C).isState();
		xnorGate.doOperation();
		Signal result = xnorGate.C;
		assertThat(result.isState(), is(equalTo(true)));
	}

	@Test
	public void testDoOperation01() throws Exception {
		when(A.isState()).thenReturn(false);
		when(B.isState()).thenReturn(true);
		doCallRealMethod().when(C).changeState(anyBoolean());
		doCallRealMethod().when(C).isState();
		xnorGate.doOperation();
		Signal result = xnorGate.C;
		assertThat(result.isState(), is(equalTo(false)));
	}

	@Test
	public void testDoOperation10() throws Exception {
		when(A.isState()).thenReturn(true);
		when(B.isState()).thenReturn(false);
		doCallRealMethod().when(C).changeState(anyBoolean());
		doCallRealMethod().when(C).isState();
		xnorGate.doOperation();
		Signal result = xnorGate.C;
		assertThat(result.isState(), is(equalTo(false)));
	}

	@Test
	public void testDoOperation11() throws Exception {
		when(A.isState()).thenReturn(true);
		when(B.isState()).thenReturn(true);
		doCallRealMethod().when(C).changeState(anyBoolean());
		doCallRealMethod().when(C).isState();
		xnorGate.doOperation();
		Signal result = xnorGate.C;
		assertThat(result.isState(), is(equalTo(true)));
	}
}
