import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;
import java.util.ListIterator;

public class LogicGateTest {
    @Mock
    LinkedList<Signal> input;
    @Mock
    LinkedList<Signal> output;
    @InjectMocks
    LogicGate logicGate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetOutputs() throws Exception {
        ListIterator<Signal> result = logicGate.getOutputs();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetOutputAtPort() throws Exception {
        Signal result = logicGate.getOutputAtPort(0);
        Assert.assertEquals(new Signal(true), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
