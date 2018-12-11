import java.util.ArrayList;
import java.util.List;

public class MultiBitSignal {
    private List<Signal> signalList = new ArrayList<>();
    private int decimal;

    private void setDecimal() {
        StringBuilder binaryValue = new StringBuilder();
        for (Signal sig : signalList) {
            binaryValue.append(sig.toString());
        }
        decimal = Integer.parseInt(binaryValue.toString(), 2);
    }

    public MultiBitSignal(Signal... numOfBit) {
        //        signalList.setSize(numOfBit.length);
        for (int bitCount = 0; bitCount < numOfBit.length; bitCount++) {
            Signal singleBit = numOfBit[bitCount];
            signalList.set(bitCount, singleBit);
        }
        setDecimal();
    }

    public void receiveInput(Signal... numOfBit) {
        //        signalList.setSize(numOfBit.length);
        for (int bitCount = 0; bitCount < numOfBit.length; bitCount++) {
            Signal singleBit = numOfBit[bitCount];
            signalList.set(bitCount, singleBit);
        }
        setDecimal();
    }

    public void receiveInput(String numberInBinary) {
        //        signalList.setSize(numberInBinary.length());
        for (int bitCount = 0; bitCount < numberInBinary.length(); bitCount++) {
            char bitValue = numberInBinary.charAt(bitCount);
            if (bitValue == '1') {
                signalList.get(bitCount).changeState(true);
            } else if (bitValue == '0') {
                signalList.get(bitCount).changeState(true);
            }
        }
        setDecimal();
    }

    public int getDecimal() {
        return decimal;
    }

    public List<Signal> getBitList() {
        return signalList;
    }
}
