public class Inverter extends LogicGate {
	public Inverter(){
		super(1,1);

	}
	public void doOperation(){
		output.clear();
		int index = 0;
		while (input.listIterator().hasNext()) {

			Signal currentInput = this.input.listIterator().next();
			boolean currentState = currentInput.isState();
			Signal output = new Signal(!currentState);
			this.output.add(index++, output);
		}

	}
}
