import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        MultiBitAdderSubtractor FourBitAdderSubtractor = new MultiBitAdderSubtractor(4);
        int firstNum = 11;
        int secondNum= 10;
        MultiBitSignal firstNumSignal = new MultiBitSignal(Integer.toBinaryString(firstNum)); //Convert Decimal Numbers to Binary
        MultiBitSignal secondNumSignal = new MultiBitSignal(Integer.toBinaryString(secondNum));
        List<Signal> fullInputList = new ArrayList<>();
        fullInputList.addAll(firstNumSignal.getBitList());
        fullInputList.addAll(secondNumSignal.getBitList());
        FourBitAdderSubtractor.receiveInputs(fullInputList);
        FourBitAdderSubtractor.enableAddition();
        FourBitAdderSubtractor.doOperation();
        FourBitAdderSubtractor.returnOutputs();
            }
}
