import java.util.Scanner;

public class FactorialMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number : ");

        int num = scanner.nextInt();

        for (int i = 1; i <=num ; i++) {
            System.out.println("Factorial of "+i+" = "+getFactorial(i));
        }
    }

    private static long getFactorial(final int n){
        int num = 1;
        for (int i = n; i >= 1; i--) {
            num = num*i;
        }
        return num;
    }
}
