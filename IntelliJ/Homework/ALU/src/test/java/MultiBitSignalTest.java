import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;

public class MultiBitSignalTest {
    @Mock
    List<Signal> signalList;
    Signal trueTestSignal;
    Signal falseTestSignal;
    MultiBitSignal multiBitSignal;

    @Before
    public void setUp() {
        trueTestSignal = new Signal(true);
        falseTestSignal = new Signal(false);
        this.multiBitSignal = new MultiBitSignal(trueTestSignal, trueTestSignal);

    }


    @Test
    public void testReceiveInput() throws Exception {
        Signal testInput = new Signal(true);
        multiBitSignal.receiveInput(testInput, testInput);
        Signal result = multiBitSignal.getBitList().get(1);
        assertThat(result, sameInstance(testInput));
    }

    @Test
    public void testReceiveInputString() throws Exception {
        Signal trueTestSignal = new Signal(true);
        MultiBitSignal testMultiBitSignal = new MultiBitSignal(trueTestSignal, trueTestSignal, trueTestSignal, trueTestSignal);
        String fifteen = "1111";
        multiBitSignal.receiveInput(fifteen);
        List<Signal> result = multiBitSignal.getBitList();
        assertThat(result.toString(), is(equalTo( testMultiBitSignal.toString())));
    }

    @Test
    public void testGetDecimal() throws Exception {
        String fifteen = "1111";
        multiBitSignal.receiveInput(trueTestSignal, trueTestSignal, trueTestSignal, trueTestSignal);
        int result = multiBitSignal.getDecimal();
        assertThat(result, is(equalTo(15)));
    }
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
