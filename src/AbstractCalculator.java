public abstract class AbstractCalculator {
    protected CalculateOperation add;
    protected CalculateOperation subtract;
    protected CalculateOperation multiply;
    protected CalculateOperation divide;

    public AbstractCalculator(CalculateOperation add, CalculateOperation subtract, CalculateOperation divide, CalculateOperation multiply) {
        this.add = add;
        this.subtract = subtract;
        this.divide = divide;
        this.multiply = multiply;
    }

    public abstract Number add(Number a, Number b);

    public abstract Number subtract(Number a, Number b);

    public abstract Number multiply(Number a, Number b);

    public abstract Number divide(Number a, Number b);
}