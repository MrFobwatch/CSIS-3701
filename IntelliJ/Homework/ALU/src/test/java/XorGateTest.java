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

public class XorGateTest {
    @Mock Signal A;
    @Mock Signal B;
    @Mock Signal C;
    @Mock LinkedList<Signal> ports;
    @InjectMocks XorGate xorGate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testReceiveInput() throws Exception {
        Signal testInput = new Signal(true);
        xorGate.receiveInput(testInput, testInput);
        Signal result = xorGate.A;
        assertThat(result, sameInstance(testInput));
        result = xorGate.B;
        assertThat(result, sameInstance(testInput));
    }

    @Test
    public void testDoOperation00() throws Exception {
        when(A.isState()).thenReturn(false);
        when(B.isState()).thenReturn(false);
        doCallRealMethod().when(C).changeState(anyBoolean());
        doCallRealMethod().when(C).isState();
        xorGate.doOperation();
        Signal result = xorGate.C;
        assertThat(result.isState(), is(equalTo(false)));
    }

    @Test
    public void testDoOperation01() throws Exception {
        when(A.isState()).thenReturn(false);
        when(B.isState()).thenReturn(true);
        doCallRealMethod().when(C).changeState(anyBoolean());
        doCallRealMethod().when(C).isState();
        xorGate.doOperation();
        Signal result = xorGate.C;
        assertThat(result.isState(), is(equalTo(true)));
    }

    @Test
    public void testDoOperation10() throws Exception {
        when(A.isState()).thenReturn(true);
        when(B.isState()).thenReturn(false);
        doCallRealMethod().when(C).changeState(anyBoolean());
        doCallRealMethod().when(C).isState();
        xorGate.doOperation();
        Signal result = xorGate.C;
        assertThat(result.isState(), is(equalTo(true)));
    }

    @Test
    public void testDoOperation11() throws Exception {
        when(A.isState()).thenReturn(true);
        when(B.isState()).thenReturn(true);
        doCallRealMethod().when(C).changeState(anyBoolean());
        doCallRealMethod().when(C).isState();
        xorGate.doOperation();
        Signal result = xorGate.C;
        assertThat(result.isState(), is(equalTo(false)));
    }

    @Test
    public void testGetResult() throws Exception {
        when(C.isState()).thenReturn(true);

        Signal result = xorGate.getResult();
        assertThat(result, sameInstance(xorGate.C));
    }
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
