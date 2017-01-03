package ua.aptasinskij.pascalstriangle;

public class PascalsTriangle {

    public String getTriangleLine(int triangleLineNumber){
        triangleLineNumber--;
        StringBuilder builder = new StringBuilder();
        int number = 1;
        for (int i = 0; i <= triangleLineNumber; i++) {
            builder.append(String.format("%d ", number));
            number = number * (triangleLineNumber - i) / (i + 1);
        }
        return builder.toString().trim();
    }

}
