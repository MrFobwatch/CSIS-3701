import java.util.LinkedList;
import java.util.ListIterator;

public interface Component {
	ListIterator returnOutputs();
	void doOperation();
}
