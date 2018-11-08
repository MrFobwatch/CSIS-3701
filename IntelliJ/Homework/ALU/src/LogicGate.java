import java.util.LinkedList;
import java.util.ListIterator;

public abstract class LogicGate {
	private LinkedList<Signal> input = new LinkedList<>();
	private LinkedList<Signal> output = new LinkedList<>();

	public ListIterator<Signal> getOutputs(){
		return output.listIterator();
	}
}
