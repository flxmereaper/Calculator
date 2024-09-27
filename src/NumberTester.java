import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberTester {
    private String fileName;
    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;

    public NumberTester (String fileName) {
        this.fileName = fileName;
    }

    public void testFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineArr = line.split(" ");
                switch (lineArr[0]) {
                    case "1": handleOddTest(Integer.parseInt(lineArr[1])); break;
                    case "2": handlePrimeTest(Integer.parseInt(lineArr[1])); break;
                    case "3": handlePalindromeTest(Integer.parseInt(lineArr[1])); break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setOddTester(NumberTest oddTester) {
        this.oddTester = oddTester;
    }
    public void setPrimeTester( NumberTest primeTester) {
        this.primeTester = primeTester;
    }
    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }
    private void handlePalindromeTest(int number) {
        if(palindromeTester == null) {
            setPalindromeTester(cache -> {
                String numberString = cache+"";
                for (int i = 0; i < numberString.length()/2; i++) {
                    if(!(numberString.charAt(i)==numberString.charAt(numberString.length()-i-1))) {
                        return false;
                    }
                }
                return true;
            });
        }
        if(palindromeTester.testNumber(number)) {
            System.out.println(number + " is a palindrome!");
        } else {
            System.out.println(number + " is not a palindrome!");
        }
    }
    private void handleOddTest(int number) {
        if(oddTester == null) {
            setOddTester(cache -> {
                if(cache % 2 == 0) {
                    return true;
                }
                return false;
            });
        }
        if(oddTester.testNumber(number)) {
            System.out.println(number + " is odd!");
        } else {
            System.out.println(number + " is not odd!");
        }
    }
    private void handlePrimeTest(int number) {
        if(primeTester == null) {
            setPrimeTester(cache -> {
                for (int i = 2; i < cache; i++) {
                    if(cache%i == 0) {
                        return false;
                    }
                }
                return true;
            });
        }
        if(primeTester.testNumber(number)) {
            System.out.println(number + " ist a prime number!");
        } else {
            System.out.println(number + " ist not a prime number!");
        }
    }
}
