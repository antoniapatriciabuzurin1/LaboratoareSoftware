package lab5;

public class AdvancedCalculator extends IntCalculator {
    public AdvancedCalculator(int initialState) {
        super(initialState);
    }
    public AdvancedCalculator divide(int value) {
        if (value != 0) {
            this.state /= value;
        }
        return this;
    }
    public AdvancedCalculator power(int exponent) {
        this.state = (int) Math.pow(this.state, exponent);
        return this;
    }
    public AdvancedCalculator root(int order) {
        this.state = (int) Math.pow(this.state, 1.0 / order);
        return this;
    }
    @Override
    public AdvancedCalculator add(int value) {
        super.add(value);
        return this;
    }
    @Override
    public AdvancedCalculator subtract(int value) {
        super.subtract(value);
        return this;
    }
    @Override
    public AdvancedCalculator multiply(int value) {
        super.multiply(value);
        return this;
    }
}
