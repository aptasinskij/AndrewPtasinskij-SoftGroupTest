package ua.aptasinskij.polynomial;

import java.util.Scanner;

/**
 * Created by andrew on 30.12.16.
 */
public class PolynomialApp {

    public static void main(String[] args) {
        PolynomialApp app = new PolynomialApp();
        int a = app.getInputFor("a");
        int b = app.getInputFor("b");
        int n = app.getInputFor("n");
        Polynomial polynomial = new Polynomial(a, b, n);
        System.out.println(polynomial.getExpressionString());
    }

    private int getInputFor(String variable){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the " + variable + ": ");
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        int variableValue = scanner.nextInt();
        return variableValue;
    }

}
