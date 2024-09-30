import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        NumberTester tester = new NumberTester("numbers.txt");
        tester.testFile();
        System.out.println();
        System.out.println("Welcome to the calculator!");
        while(true) {
            runMenu();
        }
    }
    private static void runMenu() {
        System.out.println();
        System.out.println("1 - Rational calculator");
        System.out.println("2 - Complex calculator");
        System.out.println("3 - Vector calculator");
        System.out.println("4 - Exit");
        handleInput();
    }
    private static void handleInput() {
        int menuNum = scanner.nextInt();
        switch (menuNum) {
            case 1: handleRational(); break;
            case 2: handleComplex(); break;
            case 3: handleVector(); break;
            case 4: System.out.println("Exiting calculator..."); System.exit(0);
        }
    }
    private static void handleRational() {
        AbstractCalculator rationalCalculator = new RationalCalculator();
        Number x = new Number();
        Number y = new Number();
        System.out.println("Enter number x:");
        x.setA(scanner.nextInt());
        System.out.println("Enter number y:");
        y.setA(scanner.nextInt());
        Number result = showMenuAndCalc(rationalCalculator, x, y);
        if(result != null) {
            System.out.println("Result: " + result.getA());
        } else {
            System.out.println("Invalid input!");
        }
    }
    private static void handleComplex() {
        Number x = new Number();
        Number y = new Number();
        System.out.println("Enter number xa:");
        x.setA(scanner.nextInt());
        System.out.println("Enter number xb:");
        x.setB(scanner.nextInt());
        System.out.println("Enter number ya:");
        y.setA(scanner.nextInt());
        System.out.println("Enter number yb:");
        y.setB(scanner.nextInt());
        AbstractCalculator complexCalculator = new ComplexCalculator();
        Number result = showMenuAndCalc(complexCalculator, x, y);
        if(result != null) {
            if (result.getB() < 0) {
                System.out.println("Result: " + result.getA()+" - "+result.getB()+"i");
            } else {
                System.out.println("Result: " + result.getA()+" + "+result.getB()+"i");
            }
        } else {
            System.out.println("Invalid input!");
        }
    }
    private static void handleVector() {
        Number x = new Number();
        Number y = new Number();
        System.out.println("Enter number xa:");
        x.setA(scanner.nextInt());
        System.out.println("Enter number xb:");
        x.setB(scanner.nextInt());
        System.out.println("Enter number ya:");
        y.setA(scanner.nextInt());
        System.out.println("Enter number yb:");
        y.setB(scanner.nextInt());
        AbstractCalculator vectorCalculator = new VectorCalculator();
        showMenuAndCalc(vectorCalculator, x, y);
    }
    private static Number showMenuAndCalc(AbstractCalculator calculator, Number x, Number y) {
        System.out.println("Choose Operation:");
        System.out.println("1 - add");
        System.out.println("2 - subtract");
        System.out.println("3 - Multiply");
        System.out.println("4 - Divide");
        if(calculator instanceof VectorCalculator) {
            Number result;
            switch (scanner.nextInt()) {
                case 1: result = calculator.add(x, y); System.out.println("Result: (" + result.getA() + "|" + result.getB() + ")"); return result;
                case 2: result = calculator.subtract(x, y); System.out.println("Result: (" + result.getA() + "|" + result.getB() + ")"); return result;
                case 3: result = calculator.multiply(x, y); System.out.println("Result: (" + result.getA() + "|" + result.getB() + ")"); return result;
                case 4: result = calculator.divide(x, y); System.out.println("Result: (" + result.getA() + "|" + result.getB() + ")"); return result;
                default: return null;
            }
        } else {
            return switch (scanner.nextInt()) {
                case 1 -> calculator.add(x, y);
                case 2 -> calculator.subtract(x, y);
                case 3 -> calculator.multiply(x, y);
                case 4 -> calculator.divide(x, y);
                default -> null;
            };
        }
    }
}