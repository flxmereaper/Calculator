public class VectorCalculator  extends AbstractCalculator {
    public VectorCalculator() {
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
            result.setB(x.getB()+y.getB());
            return result;
        });
    }
    public static CalculateOperation getMultiplyOperation() {
        return ((x, y) ->  {
            Number result = new Number();
            result.setA(x.getA()*y.getA() + x.getB()*y.getB());
            return result;
        });
    }

    public static CalculateOperation getDivOperation() {
        return ((x, y) -> {
            Number result = new Number();
            result.setA(x.getA()*y.getB() - x.getB()*y.getA());
            return result;
        });
    }

    public static CalculateOperation getSubOperation() {
        return ((x, y) -> {
            Number result = new Number();
            result.setA(x.getA()-y.getA());
            result.setB(x.getB()-y.getB());
            return result;
        });
    }
}
