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
import static org.mockito.Mockito.when;

public class InverterGateTest {
    @Mock Signal Q;
    @Mock Signal notQ;
    @Mock LinkedList<Signal> ports;
    @InjectMocks InverterGate inverterGate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testReceiveInput() throws Exception {
        Signal testInput = new Signal(true);
        inverterGate.receiveInput(testInput);
        Signal result = inverterGate.Q;
        assertThat(result, sameInstance(testInput));
    }

    @Test
    public void testDoOperation() throws Exception {
        when(Q.isState()).thenReturn(true);
        inverterGate.doOperation();
        Signal result = inverterGate.notQ;
        assertThat(result.isState(), is(equalTo(false)));
    }

    @Test
    public void testGetResult() {
        when(notQ.isState()).thenReturn(true);
        Signal result = inverterGate.getResult();
        assertThat(result, sameInstance(inverterGate.notQ));
    }
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
