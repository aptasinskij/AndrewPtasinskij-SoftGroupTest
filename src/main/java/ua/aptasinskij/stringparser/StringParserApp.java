package ua.aptasinskij.stringparser;

import java.util.Scanner;

/**
 * Created by andrew on 30.12.16.
 */
public class StringParserApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the input line: ");
        new StringParser().parseString(scanner.nextLine());
        scanner.close();
    }
}
