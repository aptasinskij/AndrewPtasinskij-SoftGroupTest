package ua.aptasinskij.polynomial;

import ua.aptasinskij.pascalstriangle.PascalsTriangle;

import static java.lang.Math.pow;

/**
 * Created by andrew on 29.12.16.
 */

public class Polynomial {

    private int a;
    private int b;
    private int n;
    private int[] coefficients;
    private String[] expressionMembers;

    public Polynomial(int a, int b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.coefficients = getCoefficients(n + 1);
        expressionMembers = new String[n + 1];
    }

    public String getExpressionString() {
        int polynomialValue = countPolynomial();
        String fullExpression = constructFullExpression(polynomialValue);
        return fullExpression;
    }

    private String constructFullExpression(int polynomialValue){
        String fullExpression = "";
        for (String member : expressionMembers){
            fullExpression += member;
        }
        fullExpression += "=" + polynomialValue;
        return fullExpression;
    }

    private int countPolynomial() {
        int result = 0;
        for (int i = 0; i <= n; i++) {
            double value = coefficients[i] * pow(a, n - i) * pow(b, i);
            result += value;
            constructExpressionMember(i, value);
        }
        return result;
    }

    private void constructExpressionMember(int iterationCycle, double value) {
        String member = "";
        if (value < 0) {
            member = member + "-";
        } else {
            if (iterationCycle != 0) {
                member = member + "+";
            }
        }
        if (coefficients[iterationCycle] != 1) {
            member = member + coefficients[iterationCycle];
        }
        if (n - iterationCycle > 0) {
            member = member + "a";
            if (n - iterationCycle > 1) {
                member = member + "^" + (n - iterationCycle);
            }
        }
        if (iterationCycle > 0) {
            member = member + "b";
            if (iterationCycle > 1) {
                member = member + "^" + iterationCycle;
            }
        }
        expressionMembers[iterationCycle] = member;
    }

    private int[] getCoefficients(int triangleLineNumber) {
        String[] stringCoefficients = new PascalsTriangle().getTriangleLine(triangleLineNumber).split(" ");
        int[] integerCoefficients = new int[stringCoefficients.length];
        for (int i = 0; i < stringCoefficients.length; i++) {
            integerCoefficients[i] = Integer.parseInt(stringCoefficients[i]);
        }
        return integerCoefficients;
    }

}
