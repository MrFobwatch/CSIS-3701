import net.bytebuddy.build.ToStringPlugin;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Vector;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.mockito.Mockito.*;

public class MultiBitSignalTest {
    @Mock Vector<Signal> bitVector;
    Signal trueTestSignal = new Signal(true);
    Signal falseTestSignal;
    MultiBitSignal multiBitSignal;

    @Before
    public void setUp() {
        this.multiBitSignal = new MultiBitSignal(trueTestSignal);
//        trueTestSignal = new Signal(true);
        falseTestSignal = new Signal(false);
    }


    @Test
    public void testReceiveInput() throws Exception {
        Signal testInput = new Signal(true);
        multiBitSignal.receiveInput(testInput, testInput);
        Signal result = multiBitSignal.getBitVector().firstElement();
        assertThat(result, sameInstance(testInput));
    }

    @Test
    public void testReceiveInputString() throws Exception {
        Signal trueTestSignal = new Signal(true);
        MultiBitSignal testMultiBitSignal = new MultiBitSignal(trueTestSignal, trueTestSignal, trueTestSignal, trueTestSignal);
        String fifteen = "1111";
        multiBitSignal.receiveInput(fifteen);
        Vector<Signal> result = multiBitSignal.getBitVector();
        assertThat(result.toString(), is(equalTo( testMultiBitSignal.toString())));
    }

    @Test
    public void testGetDecimal() throws Exception {
        String fifteen = "1111";
        multiBitSignal.receiveInput(fifteen);
        int result = multiBitSignal.getDecimal();
        assertThat(result, is(equalTo(15)));
    }
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
