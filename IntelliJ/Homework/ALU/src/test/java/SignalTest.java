import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class SignalTest {

    @Test
    public void defaultSignalCreationTest(){
        Signal signal = new Signal();
        assertThat(signal.getValue(),is(equalTo(0)));
        assertThat(signal.isHighZ(), is(equalTo(false)));
    }

    @Test
    public void customSignalCreationTest(){
        Signal signal = new Signal(true);
        assertThat(signal.getValue(), is(equalTo(1)));
        assertThat(signal.isHighZ(), is(equalTo(false)));

    }

    @Test
    public void testGetValue() throws Exception {
        Signal signal = new Signal(true);
        assertThat(signal.getValue(), is(equalTo(1)));
    }

    @Test
    public void testReceive() throws Exception {
        Signal signal = new Signal(true);
        signal.receive(0);
        assertThat(signal.getValue(), is(equalTo(0)));
        signal.receive(1);
        assertThat(signal.getValue(), is(equalTo(1)) );
    }
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme
