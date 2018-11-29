import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.when;

public class NorGateTest {
    @Mock Signal A;
    @Mock Signal B;
    @Mock Signal C;
//    Signal C = mock(Signal.class, withSettings().verboseLogging());
    @Mock LinkedList<Signal> ports;
    @InjectMocks NorGate norGate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoOperation00() throws Exception {
        when(A.isState()).thenReturn(false);
        when(B.isState()).thenReturn(false);
        doCallRealMethod().when(C).changeState(anyBoolean());
        doCallRealMethod().when(C).isState();
        norGate.doOperation();
        Signal result = norGate.C;
        assertThat(result.isState(), is(equalTo(true)));
    }

    @Test
    public void testDoOperation01() throws Exception {
        when(A.isState()).thenReturn(false);
        when(B.isState()).thenReturn(true);
        doCallRealMethod().when(C).changeState(anyBoolean());
        doCallRealMethod().when(C).isState();
        norGate.doOperation();
        Signal result = norGate.C;
        assertThat(result.isState(), is(equalTo(false)));
    }

    @Test
    public void testDoOperation10() throws Exception {
        when(A.isState()).thenReturn(true);
        when(B.isState()).thenReturn(false);
        doCallRealMethod().when(C).changeState(anyBoolean());
        doCallRealMethod().when(C).isState();
        norGate.doOperation();
        Signal result = norGate.C;
        assertThat(result.isState(), is(equalTo(false)));
    }

    @Test
    public void testDoOperation11() throws Exception {
        when(A.isState()).thenReturn(true);
        when(B.isState()).thenReturn(true);
        doCallRealMethod().when(C).changeState(anyBoolean());
        doCallRealMethod().when(C).isState();
        norGate.doOperation();
        Signal result = norGate.C;
        assertThat(result.isState(), is(equalTo(false)));
    }

    @Test
    public void testReceiveInput() throws Exception {
        Signal testInput = new Signal(true);
        norGate.receiveInput(testInput, testInput);
        Signal result = norGate.A;
        assertThat(result, sameInstance(testInput));
        result = norGate.B;
        assertThat(result, sameInstance(testInput));
    }

}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
