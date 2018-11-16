public class Inverter extends LogicGate {
	public Inverter(){
		super(1,1);

	}
	public void doOperation(){
		output.clear();
		while (input.listIterator().hasNext()) {
			Signal input = this.input.listIterator().next();
			boolean currentState = input.isState();
			Signal output = new Signal(!currentState);
			this.output.add(output);
		}

	}
}
