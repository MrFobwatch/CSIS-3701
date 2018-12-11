//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.List;
//import java.util.ListIterator;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.when;
//
//public class MultiBitAdderSubtractorTest {
//    @Mock List<FullAdder> fullAdders;
//    @Mock List<XorGate> xorGates;
//    @Mock List<Signal> inputAs;
//    @Mock List<Signal> inputBs;
//    @Mock Signal Cin;
//    @Mock Signal Cout;
//    Signal trueTestSignal;
//    Signal falseTestSignal;
//    @InjectMocks MultiBitAdderSubtractor multiBitAdderSubtractor;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        trueTestSignal = new Signal(true);
//        falseTestSignal = new Signal(false);
//
////        this.multiBitAdderSubtractor = new MultiBitAdderSubtractor();
//        multiBitAdderSubtractor = new MultiBitAdderSubtractor(anyInt());
//    }
//
//    @Test
//    public void testReceiveInputs() throws Exception {
//        when(multiBitAdderSubtractor.getInputAs()).thenCallRealMethod();
//        when(multiBitAdderSubtractor.getInputBs()).thenCallRealMethod();
//        Signal testInput = new Signal(true);
//        MultiBitSignal testMultiBitInput =
//                new MultiBitSignal(testInput, testInput, testInput, testInput);
//        multiBitAdderSubtractor.receiveInputs(testMultiBitInput.getBitList());
//        List<Signal> result = multiBitAdderSubtractor.getInputAs();
//        result.addAll(multiBitAdderSubtractor.getInputBs());
//        assertThat(result, is(equalTo(testMultiBitInput.getBitList())));
//    }
//
//    @Test
//    public void testEnableSubtraction() throws Exception {
//        multiBitAdderSubtractor.enableSubtraction();
//        Signal result = multiBitAdderSubtractor.Cin;
//        assertThat(result.isState(), is(equalTo(true)));
//    }
//
//    @Test
//    public void testEnableAddition() throws Exception {
//        multiBitAdderSubtractor.enableAddition();
//        Signal result = multiBitAdderSubtractor.Cin;
//        assertThat(result.isState(), is(equalTo(false)));
//    }
//
//    @Test
//    public void testDoOperation() throws Exception {
//        multiBitAdderSubtractor.doOperation();
//    }
//
//    @Test
//    public void testReturnOutputs() throws Exception {
//        ListIterator result = multiBitAdderSubtractor.returnOutputs();
//        Assert.assertEquals(null, result);
//    }
//
//    @Test
//    public void testToString() throws Exception {
//        String result = multiBitAdderSubtractor.toString();
//        Assert.assertEquals("replaceMeWithExpectedResult", result);
//    }
//}
//
//// Generated with love by TestMe :) Please report issues and submit feature requests at:
//// http://weirddev.com/forum#!/testme
