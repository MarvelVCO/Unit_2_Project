import java.text.DecimalFormat;

public class LinearEquation {
    public LinearEquation() { }

    private String dis(double x1, double y1, double x2, double y2) {
        return roundedToHundreth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    private String roundedToHundreth(double toRound) {
        DecimalFormat df = new DecimalFormat("##.00");
        return df.format(toRound);
    }

    private double yIntercept(double x1, double y1, double x2, double y2) {
        return x1 == x2 ? 0 : Double.parseDouble(roundedToHundreth(y1 - (((y2 - y1) / (x2 - x1)) * x1)));
    }

    private double slopeDec(double x1, double y1, double x2, double y2) {

        return ((y2 - y1) / (x2 - x1)) == 0 ? 0 : ((y2 - y1) / (x2 - x1));
    }

    private String slopeFrac(double x1, double y1, double x2, double y2) {
        double slope = slopeDec(x1, y1, x2, y2);
        if(slope == 0.0 ) {
            return "0";
        }
        if(slope <= 0) {
            return "-" + (Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1));
        }
        return (Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1));
    }

    private String equation(double x1, double y1, double x2, double y2) {

        double slope = slopeDec(x1, y1, x2, y2);
        String response = "y = ";
        if ( x1 != x2) {
            if (slope != 0) {
                if (slope == (int) slope) {
                    slope = (int) slope;
                    if (slope == 1) {
                        response += "x ";
                    } else if (slope == -1) {
                        response += "-x ";
                    } else {
                        response += slope + "x ";
                    }
                } else {
                    response += slopeFrac(x1, y1, x2, y2) + "x ";
                }

            }
            if (y1 != y2) {
                if (yIntercept(x1, y1, x2, y2) > 0) {
                    response += "+ " + yIntercept(x1, y1, x2, y2);
                } else if (yIntercept(x1, y1, x2, y2) < 0) {
                    response += "- " + Math.abs(yIntercept(x1, y1, x2, y2));
                }
                if (slope == 0) {
                    if (yIntercept(x1, y1, x2, y2) == 0) {
                        response += "0";
                    } else {
                        if (yIntercept(x1, y1, x2, y2) > 0) {
                            response += "+ " + yIntercept(x1, y1, x2, y2);
                        } else if (yIntercept(x1, y1, x2, y2) < 0) {
                            response += "- " + Math.abs(yIntercept(x1, y1, x2, y2));
                        }
                    }
                }
            }
            if (y1 == y2) {
                response += yIntercept(x1, y1, x2, y2);
            }

        }
        if(x1 == x2) {
            if(y1 == y2) {
                response = "Not a line. Point at: (" + x1 + ", " + y1 + ")";
            }
            else {
                response = "x = " + x1;
            }
        }
        return response;
    }

    public String coordForX(double x, double x1, double y1, double x2, double y2) {
        return "(" + x + ", " + (slopeDec(x1, y1, x2, y2) * x + yIntercept(x1, y1, x2, y2)) + ")";
    }

    public String lineInfo(double x1, double y1, double x2, double y2) {

        return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")" +
                "\nThe equation of the line between the points is: " + equation(x1, y1, x2, y2) +
                "\nThe slope of this line is: " + slopeDec(x1, y1, x2, y2) +
                (x1 == x2 ? "\nThis line doesnt have a y-intercept" : "\nThe y-intercept of this line is: " + yIntercept(x1, y1, x2, y2)) +
                "\nThe distance between these two points is: " +  dis(x1, y1, x2, y2);
    }

}
