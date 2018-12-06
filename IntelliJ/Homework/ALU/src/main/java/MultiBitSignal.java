import java.util.Vector;

public class MultiBitSignal {
    private Vector<Signal> bitVector = new Vector<>();
    private int decimal;


    private void setDecimal() {
    	String binaryValue = bitVector.toArray().toString();
        decimal = Integer.parseInt(binaryValue, 2);
    }

    public MultiBitSignal(Signal... numOfBit) {
        bitVector.setSize(numOfBit.length);
        for (int bitCount = 0; bitCount < numOfBit.length; bitCount++) {
            Signal singleBit = numOfBit[bitCount];
            bitVector.set(bitCount, singleBit);
        }
        setDecimal();
    }

    public void receiveInput(Signal... numOfBit) {
        bitVector.setSize(numOfBit.length);
        for (int bitCount = 0; bitCount < numOfBit.length; bitCount++) {
            Signal singleBit = numOfBit[bitCount];
            bitVector.set(bitCount, singleBit);
        }
        setDecimal();
    }

    public void receiveInput(String numberInBinary) {
        bitVector.setSize(numberInBinary.length());
        for (int bitCount = 0; bitCount < numberInBinary.length(); bitCount++) {
            char bitValue = numberInBinary.charAt(bitCount);
            if (bitValue == '1') {
                bitVector.elementAt(bitCount).changeState(true);
            } else if (bitValue == '0') {
                bitVector.elementAt(bitCount).changeState(true);
            }
        }
        setDecimal();
    }

    public int getDecimal() {
        return decimal;
    }

    public Vector<Signal> getBitVector() {
        return bitVector;
    }
}
