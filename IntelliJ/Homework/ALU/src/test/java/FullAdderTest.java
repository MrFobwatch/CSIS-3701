import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.ListIterator;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.when;

public class FullAdderTest {
    @Mock List<Signal> outputList;
    @Mock HalfAdder halfAdderA;
    @Mock HalfAdder halfAdderB;
    @Mock OrGate orGate;
    @Mock Signal A;
    @Mock Signal B;
    @Mock Signal Cin;
    @Mock Signal Sum;
    @Mock Signal Cout;
    Signal trueTestSignal;
    Signal falseTestSignal;

    @InjectMocks FullAdder fullAdder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        trueTestSignal = new Signal(true);
        falseTestSignal = new Signal(false);
    }

    @Test
    public void testReceiveInput() throws Exception {
        Signal testInput = new Signal(true);
        fullAdder.receiveInput(testInput, testInput, testInput);
        Signal result = fullAdder.A;
        assertThat(result, sameInstance(testInput));
        result = fullAdder.B;
        assertThat(result, sameInstance(testInput));
        result = fullAdder.Cin;
        assertThat(result, sameInstance(testInput));
    }

    @Test
    public void testDoOperationReturnSum000() throws Exception {
        when(halfAdderA.getSum()).thenReturn(falseTestSignal); // A XOR B
        when(halfAdderB.getSum()).thenReturn(falseTestSignal); // HalfAdderA.Sum XOR Cin
        when(halfAdderA.getCout()).thenReturn(falseTestSignal); // A AND B
        when(halfAdderB.getCout()).thenReturn(falseTestSignal); // HalfAdderA.Cout AND Cin
        when(orGate.getResult()).thenReturn(falseTestSignal); // HalfAdderB.Cout OR HalfAdderA.Cout
        fullAdder.doOperation();
        assertThat(fullAdder.getSum().getValue(), is(equalTo(0)));
        assertThat(fullAdder.getCout().getValue(), is(equalTo(0)));
    }

    @Test
    public void testDoOperationReturnSum001() throws Exception {
        when(halfAdderA.getSum()).thenReturn(falseTestSignal); // A XOR B
        when(halfAdderB.getSum()).thenReturn(trueTestSignal); // HalfAdderA.Sum XOR Cin
        when(halfAdderA.getCout()).thenReturn(falseTestSignal); // A AND B
        when(halfAdderB.getCout()).thenReturn(falseTestSignal); // HalfAdderA.Sum AND Cin
        when(orGate.getResult()).thenReturn(falseTestSignal); // HalfAdderB.Cout OR HalfAdderA.Cout
        fullAdder.doOperation();
        assertThat(fullAdder.getSum().getValue(), is(equalTo(1)));
        assertThat(fullAdder.getCout().getValue(), is(equalTo(0)));
    }

    @Test
    public void testDoOperationReturnSum010() throws Exception {
        when(halfAdderA.getSum()).thenReturn(trueTestSignal); // A XOR B
        when(halfAdderB.getSum()).thenReturn(trueTestSignal); // HalfAdderA.Sum XOR Cin
        when(halfAdderA.getCout()).thenReturn(falseTestSignal); // A AND B
        when(halfAdderB.getCout()).thenReturn(falseTestSignal); // HalfAdderA.Sum AND Cin
        when(orGate.getResult()).thenReturn(falseTestSignal); // HalfAdderB.Cout OR HalfAdderA.Cout
        fullAdder.doOperation();
        assertThat(fullAdder.getSum().getValue(), is(equalTo(1)));
        assertThat(fullAdder.getCout().getValue(), is(equalTo(0)));
    }

    @Test
    public void testDoOperationReturnSum011() throws Exception {
        when(halfAdderA.getSum()).thenReturn(trueTestSignal); // A XOR B
        when(halfAdderB.getSum()).thenReturn(falseTestSignal); // HalfAdderA.Sum XOR Cin
        when(halfAdderA.getCout()).thenReturn(falseTestSignal); // A AND B
        when(halfAdderB.getCout()).thenReturn(trueTestSignal); // HalfAdderA.Sum AND Cin
        when(orGate.getResult()).thenReturn(trueTestSignal); // HalfAdderB.Cout OR HalfAdderA.Cout
        fullAdder.doOperation();
        assertThat(fullAdder.getSum().getValue(), is(equalTo(0)));
        assertThat(fullAdder.getCout().getValue(), is(equalTo(1)));
    }

    @Test
    public void testDoOperationReturnSum100() throws Exception {
        when(halfAdderA.getSum()).thenReturn(trueTestSignal); // A XOR B
        when(halfAdderB.getSum()).thenReturn(trueTestSignal); // HalfAdderA.Sum XOR Cin
        when(halfAdderA.getCout()).thenReturn(falseTestSignal); // A AND B
        when(halfAdderB.getCout()).thenReturn(falseTestSignal); // HalfAdderA.Sum AND Cin
        when(orGate.getResult()).thenReturn(falseTestSignal); // HalfAdderB.Cout OR HalfAdderA.Cout
        fullAdder.doOperation();
        assertThat(fullAdder.getSum().getValue(), is(equalTo(1)));
        assertThat(fullAdder.getCout().getValue(), is(equalTo(0)));
    }

    @Test
    public void testDoOperationReturnSum101() throws Exception {
        when(halfAdderA.getSum()).thenReturn(trueTestSignal); // A XOR B
        when(halfAdderB.getSum()).thenReturn(falseTestSignal); // HalfAdderA.Sum XOR Cin
        when(halfAdderA.getCout()).thenReturn(falseTestSignal); // A AND B
        when(halfAdderB.getCout()).thenReturn(trueTestSignal); // HalfAdderA.Sum AND Cin
        when(orGate.getResult()).thenReturn(trueTestSignal); // HalfAdderB.Cout OR HalfAdderA.Cout
        fullAdder.doOperation();
        assertThat(fullAdder.getSum().getValue(), is(equalTo(0)));
        assertThat(fullAdder.getCout().getValue(), is(equalTo(1)));
    }

    @Test
    public void testDoOperationReturnSum110() throws Exception {
        when(halfAdderA.getSum()).thenReturn(falseTestSignal); // A XOR B
        when(halfAdderB.getSum()).thenReturn(falseTestSignal); // HalfAdderA.Sum XOR Cin
        when(halfAdderA.getCout()).thenReturn(trueTestSignal); // A AND B
        when(halfAdderB.getCout()).thenReturn(falseTestSignal); // HalfAdderA.Sum AND Cin
        when(orGate.getResult()).thenReturn(trueTestSignal); // HalfAdderB.Cout OR HalfAdderA.Cout
        fullAdder.doOperation();
        assertThat(fullAdder.getSum().getValue(), is(equalTo(0)));
        assertThat(fullAdder.getCout().getValue(), is(equalTo(1)));
    }

    @Test
    public void testDoOperationReturnSum111() throws Exception {
        when(halfAdderA.getSum()).thenReturn(falseTestSignal); // A XOR B
        when(halfAdderB.getSum()).thenReturn(trueTestSignal); // HalfAdderA.Sum XOR Cin
        when(halfAdderA.getCout()).thenReturn(trueTestSignal); // A AND B
        when(halfAdderB.getCout()).thenReturn(falseTestSignal); // HalfAdderA.Sum AND Cin
        when(orGate.getResult()).thenReturn(trueTestSignal); // HalfAdderB.Cout OR HalfAdderA.Cout
        fullAdder.doOperation();
        assertThat(fullAdder.getSum().getValue(), is(equalTo(1)));
        assertThat(fullAdder.getCout().getValue(), is(equalTo(1)));
    }

    @Test
    public void testReturnOutputs() throws Exception {
        ListIterator result = fullAdder.returnOutputs();
        Assert.assertNull(result);
    }
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
