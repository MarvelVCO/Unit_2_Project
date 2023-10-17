import java.text.DecimalFormat;
import java.util.Scanner;

public class LinearEquation {
    public LinearEquation() { }

    private String dis(double x1, double y1, double x2, double y2) {
        return format(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    private String format(double num) {
        DecimalFormat df = new DecimalFormat("##.00");
        return df.format(num);
    }

    private double yIntercept(double x1, double y1, double x2, double y2) {
        return (y1 - (((y2 - y1) / (x2 - x1)) * x1));
    }

    private double slopeDec(double x1, double y1, double x2, double y2) {

        return ((y2 - y1) / (x2 - x1));
    }

    private String slopeFrac(double x1, double y1, double x2, double y2) {
        double slope = slopeDec(x1, y1, x2, y2);
        if(slope == 0.0) { return "0";}
        if(slope <= 0) {
            return "-" + (Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1));
        }
        return ((y2 - y1) + "/" + (x2 - x1));
    }

    private String equation(double x1, double y1, double x2, double y2) {

        double slope = slopeDec(x1, y1, x2, y2);
        String response = "y = ";

        if(slope != 0) {
            if(slope == (int) slope) {
                if (slope == 1) {
                }
                if (slope == -1) {
                }
            }
        }
        if(slope == 1) {
            return "y = x + " + yIntercept(x1, y1, x2, y2);
        }
        if(slope == -1) {
            return "y = -x + " + yIntercept(x1, y1, x2, y2);
        }
        if(slope == (int) slope) {
            slope = (int) slope;
        }
        if(slope == 0 && yIntercept(x1, y1, x2, y2) == 0) {
            return "y = 0";
        }
        if(yIntercept(x1, y1, x2, y2) == 0) {
            response += slope + "x";
        }
        return "";
    }

    public String coordForX(double x1, double y1, double x2, double y2) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter an x value to see what the corresponding y value would be: ");
        double x = scan.nextDouble();
        return "(" + x + ", " + (slopeDec(x1, y1, x2, y2) * x + yIntercept(x1, y1, x2, y2)) + ")";
    }

    public String lineInfo(double x1, double y1, double x2, double y2) {

        return "Line info:\n" +
                "Distance between points: " +  dis(x1, y1, x2, y2) +
                "\nSlope: " + slopeFrac(x1, y1, x2, y2) +
                "\ny-intercept: " + yIntercept(x1, y1, x2, y2) +
                "\nEquation: " + equation(x1, y1, x2, y2);
    }

}
