import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class HalfAdderTest {
    @Mock Signal A;
    @Mock Signal B;
    @Mock Signal Sum;
    @Mock Signal Cout;
    @Mock XorGate XOR;
    @Mock AndGate AND;
    Signal trueTestSignal;
    Signal falseTestSignal;
    @InjectMocks HalfAdder halfAdder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        trueTestSignal = new Signal(true);
        falseTestSignal = new Signal(false);
    }

    @Test
    public void testReceiveInput() throws Exception {
        Signal testInput = new Signal(true);
        halfAdder.receiveInput(testInput, testInput);
        Signal result = halfAdder.A;
        assertThat(result, sameInstance(testInput));
        result = halfAdder.B;
        assertThat(result, sameInstance(testInput));
    }

    @Test
    public void testDoOperationReturnSum00() throws Exception {
//        doReturn(falseTestSignal).when(XOR).getResult();
//        doReturn(falseTestSignal).when(AND).getResult();
        halfAdder.receiveInput(falseTestSignal, falseTestSignal);
        halfAdder.doOperation();
        assertThat(halfAdder.getSum().getValue(), is(equalTo(0)));
        assertThat(halfAdder.getCout().getValue(), is(equalTo(0)));
    }

    @Test
    public void testDoOperationReturnSum11() throws Exception {
//        doReturn(falseTestSignal).when(XOR).getResult();
//        doReturn(trueTestSignal).when(AND).getResult();
        halfAdder.receiveInput(trueTestSignal, trueTestSignal);
        halfAdder.doOperation();
        assertThat(halfAdder.getSum().getValue(), is(equalTo(0)));
        assertThat(halfAdder.getCout().getValue(), is(equalTo(1)));
    }

    @Test
    public void testDoOperationReturnSum10() throws Exception {
//        doReturn(trueTestSignal).when(XOR).getResult();
//        doReturn(falseTestSignal).when(AND).getResult();
        halfAdder.receiveInput(trueTestSignal,falseTestSignal);
        halfAdder.doOperation();
        assertThat(halfAdder.getSum().getValue(), is(equalTo(1)));
        assertThat(halfAdder.getCout().getValue(), is(equalTo(0)));
    }

    @Test
    public void testDoOperationReturnSum01() throws Exception {
//        doReturn(trueTestSignal).when(XOR).getResult();
//        doReturn(falseTestSignal).when(AND).getResult();
        halfAdder.receiveInput(falseTestSignal,trueTestSignal);
        halfAdder.doOperation();
        assertThat(halfAdder.getSum().getValue(), is(equalTo(1)));
        assertThat(halfAdder.getCout().getValue(), is(equalTo(0)));
    }

    @Test
    public void testDoOperationReturnCout() throws Exception {
        halfAdder.receiveInput(trueTestSignal,trueTestSignal);
        halfAdder.doOperation();
        assertThat(halfAdder.getCout().getValue(), is(equalTo(1)));
    }
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
