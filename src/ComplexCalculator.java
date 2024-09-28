public class ComplexCalculator extends AbstractCalculator{
    public ComplexCalculator() {
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
            result.setA(x.getA() + y.getA());
            result.setB(x.getB() + y.getB());
            return result;
        });
    }
    public static CalculateOperation getMultiplyOperation() {
        return ((x, y) ->  {
            Number result = new Number();
            result.setA(x.getA()*x.getB()-y.getA()*y.getB());
            result.setB(x.getA()*y.getB()+x.getB()*y.getA());
            return result;
        });
    }

    public static CalculateOperation getDivOperation() {
        return ((x, y) -> {
            Number result = new Number();
            Number cache = new Number();
            cache.setA(y.getA());
            cache.setB(-y.getB());
            double real = x.getA()*cache.getA()-x.getB()*cache.getB(); //Realteil (i² ist -1)
            double imagine = x.getB()*cache.getA()+x.getA()*cache.getB(); //Imgainärteil
            x.setA(real);
            x.setB(imagine);
            double dividend = y.getA()*y.getA() + y.getB()*y.getB();
            result.setA(x.getA()/dividend);
            result.setB(x.getB()/dividend);
            return result;
        });
    }

    public static CalculateOperation getSubOperation() {
        return ((x, y) -> {
            Number result = new Number();
            result.setA(x.getA() - y.getA());
            result.setB(x.getB() - y.getB());
            return result;
        });
    }
}