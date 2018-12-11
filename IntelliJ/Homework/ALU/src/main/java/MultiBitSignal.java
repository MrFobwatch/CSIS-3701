import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiBitSignal {
    private List<Signal> signalList = new ArrayList<>();
    private int decimal;

//    public MultiBitSignal(Signal... numOfBit) {
//        Collections.addAll(signalList, numOfBit);
//        setDecimal();
//    }

    private void setDecimal() {
        StringBuilder binaryValue = new StringBuilder();
        for (Signal sig : signalList) {
            binaryValue.append(sig.getValue());
        }
        decimal = Integer.parseInt(binaryValue.toString(), 2);
    }

    public MultiBitSignal(String numberInBinary) {
        for (int bitCount = 0; bitCount < numberInBinary.length(); bitCount++) {
            char bitValue = numberInBinary.charAt(bitCount);
            if (bitValue == '1') {
                signalList.add(new Signal(true));
            } else if (bitValue == '0') {
                signalList.add( new Signal(false));
            }
        }
        setDecimal();
    }

    public void receiveInput(Signal... numOfBit) {
        signalList.clear();
        Collections.addAll(signalList, numOfBit);
        setDecimal();
    }

    public void receiveInput(String numberInBinary) {
//        signalList.clear();
        for (int bitCount = 0; bitCount < numberInBinary.length(); bitCount++) {
            char bitValue = numberInBinary.charAt(bitCount);
            if (bitValue == '1') {
                signalList.set(bitCount, new Signal(true));
            } else if (bitValue == '0') {
                signalList.set(bitCount, new Signal(false));
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
