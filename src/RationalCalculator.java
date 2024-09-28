public class RationalCalculator extends AbstractCalculator{
    public RationalCalculator() {
        super(getAddOperation(), getSubOperation(), getDivOperation(), getMultiplyOperation());
    }

    @Override
    public Number add(Number a, Number b) {
        return add.calc(a, b);
    }

    @Override
    public Number subtract(Number a, Number b) {
        return subtract.calc(a, b);
    }

    @Override
    public Number multiply(Number a, Number b) {
        return multiply.calc(a, b);
    }

    @Override
    public Number divide(Number a, Number b) {
        return divide.calc(a, b);
    }
    public static CalculateOperation getAddOperation() {
        return ((x, y) -> {
            Number result = new Number();
            result.setA(x.getA()+y.getA());
            return result;
        });
    }
    public static CalculateOperation getMultiplyOperation() {
        return ((x, y) ->  {
            Number result = new Number();
            result.setA(x.getA()*y.getA());
            return result;
        });
    }

    public static CalculateOperation getDivOperation() {
        return ((x, y) -> {
            Number result = new Number();
            result.setA(x.getA()/y.getA());
            return result;
        });
    }

    public static CalculateOperation getSubOperation() {
        return ((x, y) -> {
            Number result = new Number();
            result.setA(x.getA()-y.getA());
            return result;
        });
    }
}