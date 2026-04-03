package lab5.advanced;

public abstract class ACalculator {
    protected Object state;
    protected abstract void init();
    public Object result() {
        return state;
    }
    public ACalculator clear() {
        this.init();
        return this;
    }
}
