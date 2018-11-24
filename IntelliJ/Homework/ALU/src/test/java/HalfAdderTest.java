import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.LinkedList;
import java.util.ListIterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class HalfAdderTest {
    @Spy LinkedList<Signal> outputList;
    @Mock Signal A;
    @Mock Signal B;
    @Mock Signal Sum;
    @Mock Signal Cout;
    @Mock XorGate XOR;
    @Mock AndGate AND;
    @InjectMocks HalfAdder halfAdder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(A.isState(), thenReturn(true));
    }

    @Test
    public void testReceiveInput() throws Exception {
        halfAdder.receiveInput(new Signal(true), new Signal(true));
        assertThat(A.isState(),is(equalTo(true)));
        assertThat(B.isState(), is(equalTo(true)));
    }

    @Test
    public void testReturnOutputs() throws Exception {
//        ListIterator result = halfAdder.returnOutputs();
	    int index = 0;
	    for (ListIterator outputs = halfAdder.returnOutputs(); outputs.hasNext(); ) {
		    Signal result = (Signal) outputs.next();
		    Assert.assertThat(result, is(equalTo(true)));
	    }
    }


    @Test
    public void testDoOperation() throws Exception {
        when(XOR.getOutputAtPort(anyInt())).thenReturn(new Signal(true));
        when(AND.getOutputAtPort(anyInt())).thenReturn(new Signal(true));
//        when(A.getValue().thenReturn(1));

        halfAdder.doOperation();
        assertThat(Sum.isState(), is(equalTo(true)));
        assertThat(Cout.isState(), is(equalTo(true)));
    }
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
