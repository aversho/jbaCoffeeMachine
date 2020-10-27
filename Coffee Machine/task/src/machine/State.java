package machine;

public enum State {
    MENU, BUY, FILL;
    private int step;

    State() {
        step = 1;
    }

    public int getStep() {
        return step;
    }

    public void nextStep() {
        step++;
    }

    public void resetStep() {
        step = 1;
    }
}
