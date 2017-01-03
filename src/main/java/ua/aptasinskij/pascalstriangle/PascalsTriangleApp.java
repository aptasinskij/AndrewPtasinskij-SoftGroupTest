package ua.aptasinskij.pascalstriangle;

import java.util.Scanner;

/**
 * Created by andrew on 29.12.16.
 */
public class PascalsTriangleApp {

    public static void main(String[] args) {
        int triangleLineNumber = new PascalsTriangleApp().getInput();
        String triangleLine = new PascalsTriangle().getTriangleLine(triangleLineNumber);
        System.out.println(triangleLine);
    }

    private int getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the line number: ");
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        int triangleLineNumber = scanner.nextInt();
        scanner.close();
        return triangleLineNumber;
    }
}
