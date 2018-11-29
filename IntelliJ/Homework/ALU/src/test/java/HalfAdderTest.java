import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HalfAdderTest {
    @Mock Signal A;
    @Mock Signal B;
    @Mock Signal Sum;
    @Mock Signal Cout;
    @Spy
    XorGate XOR;
    @Spy AndGate AND;
    @InjectMocks HalfAdder halfAdder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testReceiveInput() throws Exception {
        Signal testInput = new Signal (true);
        halfAdder.receiveInput(testInput, testInput);
        Signal result = halfAdder.A;
        assertThat(result, sameInstance(testInput));
        result = halfAdder.B;
        assertThat(result, sameInstance(testInput));
    }

    @Test
    public void testDoOperationReturnSum00() throws Exception {
        when(A.isState()).thenReturn(false);
        when(B.isState()).thenReturn(false);
//        doCallRealMethod().when(XOR).doOperation();
//        doCallRealMethod().when(XOR).receiveInput(A, B);
//        doCallRealMethod().when(AND).doOperation();
//        doCallRealMethod().when(AND).receiveInput(A, B);
        halfAdder.doOperation();
        assertThat(halfAdder.getSum().getValue(), is(equalTo(0)));
        assertThat(halfAdder.getCout().getValue(), is(equalTo(0)));
    }

    @Test
    public void testDoOperationReturnSum11() throws Exception {
        Signal Value0 = mock(Signal.class);
        Signal Value1 = mock(Signal.class);
        when(Value0.isState()).thenReturn(true);
        when(Value1.isState()).thenReturn(true);
        halfAdder.receiveInput(Value0, Value1);
        halfAdder.doOperation();
        assertThat(halfAdder.getSum().getValue(), is(equalTo(0)));
        assertThat(halfAdder.getCout().getValue(), is(equalTo(1)));
    }

    @Test
    public void testDoOperationReturnSum10() throws Exception {
        Signal Value0 = mock(Signal.class);
        Signal Value1 = mock(Signal.class);
        when(Value0.isState()).thenReturn(true);
        when(Value1.isState()).thenReturn(false);
        halfAdder.receiveInput(Value0, Value1);
        halfAdder.doOperation();
        assertThat(halfAdder.getSum().getValue(), is(equalTo(1)));
        assertThat(halfAdder.getCout().getValue(), is(equalTo(0)));
    }

    @Test
    public void testDoOperationReturnSum01() throws Exception {
        Signal Value0 = mock(Signal.class);
        Signal Value1 = mock(Signal.class);
        when(Value0.isState()).thenReturn(false);
        when(Value1.isState()).thenReturn(true);
        halfAdder.receiveInput(Value0, Value1);
        halfAdder.doOperation();
        assertThat(halfAdder.getSum().getValue(), is(equalTo(1)));
        assertThat(halfAdder.getCout().getValue(), is(equalTo(0)));
    }

    //    @Test
    //    public void testDoOperationReturnCout() throws Exception {
    //        when(XOR.getOutputAtPort(anyInt())).thenReturn(A);
    //        when(AND.getOutputAtPort(anyInt())).thenReturn(B);
    //        halfAdder.doOperation();
    //        assertThat(halfAdder.getCout().getValue(), is(equalTo(1)));
    //    }
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
