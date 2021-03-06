public class Signal {
    private boolean state;
    private boolean highZ;

    public Signal(boolean state) {
        this.state = state;
        highZ = false;
    }

    public Signal() {
        state = false;
        highZ = false;
    }

    public boolean isHighZ() {
        return highZ;
    }

    public void setHighZ(boolean highZ) {
        this.highZ = highZ;
    }

    public int getValue() {
        int value = -1;
        if (state) {
            value = 1;
        } else if (!state) {
            value = 0;
        }
        return value;
    }

    public void receive(int incomingSignal) {
        if (incomingSignal == 1) {
            state = true;
        } else if (incomingSignal == 0) {
            state = false;
        }
    }

    boolean isState() {
        return state;
    }
}
