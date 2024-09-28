import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NumberTester tester = new NumberTester("numbers.txt");
        tester.testFile();
        RationalCalculator rationalCalculator = new RationalCalculator();
        ComplexCalculator complexCalculator = new ComplexCalculator();
        VectorCalculator vectorCalculator = new VectorCalculator();
        runMenu();
    }
    private static void runMenu() {
        System.out.println("Welcome to the Rational Calculator!");
        System.out.println("1 - Rational Calculator");
        System.out.println("2 - Complex Calculator");
        System.out.println("3 - Vector Calculator");
        System.out.println("4 - Exit");
        waitForInput();
    }
    private static void waitForInput() {
        Scanner scanner = new Scanner(System.in);
        int menuNum = scanner.nextInt();

    }
}