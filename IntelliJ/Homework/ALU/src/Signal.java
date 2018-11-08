public class Signal {
	private boolean state;
	private boolean highZ;

	public Signal(boolean state) {
		this.state = state;
		highZ = false;
	}

	public Signal(){
		highZ = true;
	}

	public int getValue(){
		int value = -1;
		if (state){
			value = 1;
		}
		else if(!state){
			value = 0;
		}
		return value;
	}

	public void receive(int incomingSignal){
		if (incomingSignal == 1){
			state = true;
		}
		else if(incomingSignal == 0) {
			state = false;
		}
	}
}
