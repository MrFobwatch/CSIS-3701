import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        MultiBitAdderSubtractor FourBitAdderSubtractor = new MultiBitAdderSubtractor(4);
        int firstNum = 6;
        int secondNum = 8;
        MultiBitSignal firstNumSignal =
                new MultiBitSignal(leftPadInt(firstNum)); // Convert Decimal Numbers to Binary
        MultiBitSignal secondNumSignal = new MultiBitSignal(leftPadInt(secondNum));
        List<Signal> fullInputList = new ArrayList<>();
        fullInputList.addAll(firstNumSignal.getBitList());
        fullInputList.addAll(secondNumSignal.getBitList());
        FourBitAdderSubtractor.receiveInputs(fullInputList);
        FourBitAdderSubtractor.enableAddition();
        FourBitAdderSubtractor.doOperation();
        List<Signal> outputList = FourBitAdderSubtractor.returnOutputList();
        MultiBitSignal answerSignal = new MultiBitSignal(outputList);
        System.out.println("The sum is: " + answerSignal.getDecimal());
    }

    public static String leftPadInt(int num) {
        return org.apache.commons.lang3.StringUtils.leftPad(Integer.toBinaryString(num), 4, '0');
        //        return Integer.toBinaryString(num);
    }
}
