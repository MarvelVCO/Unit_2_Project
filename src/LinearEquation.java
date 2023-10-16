import java.text.DecimalFormat;
import java.util.Scanner;

public class LinearEquation {
    public LinearEquation() { }

    private String dis(double x1, double y1, double x2, double y2) {
        DecimalFormat df = new DecimalFormat("##.00");

        return df.format(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }
    private double yIntercept(double x1, double y1, double x2, double y2) {
        return (y1 - (((y2 - y1) / (x2 - x1)) * x1));
    }

    private double slope(double x1, double y1, double x2, double y2) {
        return ((y2 - y1) / (x2 - x1));
    }

    private String equation(double x1, double y1, double x2, double y2) {
        return "y = " + ((y2 - y1) / (x2 - x1)) + "x + " + (y1 - (((y2 - y1) / (x2 - x1)) * x1));
    }

    public double coordForX(double x1, double y1, double x2, double y2) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter an x value to see what the corresponding y value would be: ");
        return slope(x1, y1, x2, y2) * scan.nextDouble() + yIntercept(x1, y1, x2, y2);
    }

    public String lineInfo(double x1, double y1, double x2, double y2) {
        return "Line info:\n" +
                "Distance between points: " +  dis(x1, y1, x2, y2) +
                "\nSlope: " + slope(x1, y1, x2, y2) +
                "\ny-intercept: " + yIntercept(x1, y1, x2, y2) +
                "\nEquation: " + equation(x1, y1, x2, y2);
    }

}
