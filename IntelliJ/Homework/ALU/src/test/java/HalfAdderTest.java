import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HalfAdderTest {
    @Spy LinkedList<Signal> outputList;
    @Spy Signal A;
    @Spy Signal B;
    @Spy Signal Sum;
    @Spy Signal Cout;
    @Spy XorGate XOR;
    @Spy AndGate AND;
    @InjectMocks HalfAdder halfAdder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testReceiveInput() throws Exception {
        halfAdder.receiveInput(new Signal(true), new Signal(true));
        assertThat(halfAdder.A.isState(), is(equalTo(true)));
        assertThat(halfAdder.B.isState(), is(equalTo(true)));
    }

    @Test
    public void testDoOperationReturnSum00() throws Exception {
        Signal Value0 = mock(Signal.class);
        Signal Value1 = mock(Signal.class);
        when(Value0.isState()).thenReturn(false);
        when(Value1.isState()).thenReturn(false);
        halfAdder.receiveInput(Value0, Value1);
        halfAdder.doOperation();
        assertThat(halfAdder.getSum().getValue(), is(equalTo(0)));
        assertThat(halfAdder.getCout().getValue(), is(equalTo(1)));
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
