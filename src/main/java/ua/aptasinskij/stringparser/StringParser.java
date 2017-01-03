package ua.aptasinskij.stringparser;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Arrays;

/**
 * Created by andrew on 30.12.16.
 */
public class StringParser {

    public void parseString(String stringToParse) {
        stringToParse = stringToParse.replaceAll("[^0-9+-/*]", " ");
        stringToParse = stringToParse.replaceAll("\\s+", " ");
        stringToParse = stringToParse.trim();
        String[] expressions = stringToParse.split(" ");
        int[] numbers = new int[expressions.length];
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JS");
        for (int i = 0; i < expressions.length; i++){
            try {
                Number number = (Number) engine.eval(expressions[i]);
                if (number != null){
                    numbers[i] = number.intValue();
                }
            } catch (ScriptException e) {
                System.err.println("Error with evaluation \"" + expressions[i] + "\" expression");
            }
        }
        if (numbers.length > 0){
            System.out.println("Numbers:");
            for (int i : numbers){
                System.out.println(i);
            }
            Arrays.sort(numbers);
            System.out.println("Max: " + numbers[numbers.length - 1]);
            System.out.println("Min: " + numbers[0]);
        }
    }

}
