import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.LinkedList;
import java.util.ListIterator;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.*;

public class FullAdderTest {
    @Mock LinkedList<Signal> outputList;
    @Mock HalfAdder halfAdderA;
    @Mock HalfAdder halfAdderB;
    @Mock Signal A;
    @Mock Signal B;
    @Mock Signal Cin;
    @Mock Signal Sum;
    @Mock Signal Cout;
    @Mock OrGate orGate;
    @InjectMocks FullAdder fullAdder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
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
        when(A.isState()).thenReturn(false);
        when(B.isState()).thenReturn(false);
        when(Cin.isState()).thenReturn(false);
        fullAdder.doOperation();
        assertThat(fullAdder.getSum().getValue(), is(equalTo(0)));
        assertThat(fullAdder.getCout().getValue(), is(equalTo(0)));
    }

    @Test
    public void testDoOperationReturnSum001() throws Exception {
        when(A.isState()).thenReturn(false);
        when(B.isState()).thenReturn(true);
        when(Cin.isState()).thenReturn(true);
        fullAdder.doOperation();
        assertThat(fullAdder.getSum().getValue(), is(equalTo(1)));
        assertThat(fullAdder.getCout().getValue(), is(equalTo(0)));
    }

    @Test
    public void testDoOperationReturnSum010() throws Exception {
        when(A.isState()).thenReturn(false);
        when(B.isState()).thenReturn(true);
        when(Cin.isState()).thenReturn(false);
        fullAdder.doOperation();
        assertThat(fullAdder.getSum().getValue(), is(equalTo(1)));
        assertThat(fullAdder.getCout().getValue(), is(equalTo(0)));
    }

    @Test
    public void testDoOperationReturnSum011() throws Exception {
        when(A.isState()).thenReturn(false);
        when(B.isState()).thenReturn(true);
        when(Cin.isState()).thenReturn(true);
        fullAdder.doOperation();
        assertThat(fullAdder.getSum().getValue(), is(equalTo(0)));
        assertThat(fullAdder.getCout().getValue(), is(equalTo(1)));
    }

    @Test
    public void testDoOperationReturnSum100() throws Exception {
        when(A.isState()).thenReturn(true);
        when(B.isState()).thenReturn(false);
        when(Cin.isState()).thenReturn(false);
        fullAdder.doOperation();
        assertThat(fullAdder.getSum().getValue(), is(equalTo(1)));
        assertThat(fullAdder.getCout().getValue(), is(equalTo(0)));
    }

    @Test
    public void testDoOperationReturnSum101() throws Exception {
        when(A.isState()).thenReturn(true);
        when(B.isState()).thenReturn(false);
        when(Cin.isState()).thenReturn(true);
        fullAdder.doOperation();
        assertThat(fullAdder.getSum().getValue(), is(equalTo(0)));
        assertThat(fullAdder.getCout().getValue(), is(equalTo(1)));
    }

    @Test
    public void testDoOperationReturnSum110() throws Exception {
        when(A.isState()).thenReturn(true);
        when(B.isState()).thenReturn(true);
        when(Cin.isState()).thenReturn(false);
        fullAdder.doOperation();
        assertThat(fullAdder.getSum().getValue(), is(equalTo(0)));
        assertThat(fullAdder.getCout().getValue(), is(equalTo(1)));
    }

    @Test
    public void testDoOperationReturnSum111() throws Exception {
        when(A.isState()).thenReturn(true);
        when(B.isState()).thenReturn(true);
        when(Cin.isState()).thenReturn(true);
        fullAdder.doOperation();
        assertThat(fullAdder.getSum().getValue(), is(equalTo(1)));
        assertThat(fullAdder.getCout().getValue(), is(equalTo(1)));
    }


    @Test
    public void testReturnOutputs() throws Exception {
        ListIterator result = fullAdder.returnOutputs();
        Assert.assertEquals(null, result);
    }
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
