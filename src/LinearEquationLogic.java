import java.util.Dictionary;
import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner scan;
    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }

    public void start() {
        boolean cont = true;

            LinearEquation le = new LinearEquation();

            System.out.println();
            System.out.println("Welcome to the linear equation calculator!");

        while (cont) {
            System.out.print("Please input a coordinate pair (eg: (1, 3.4)): ");
            double[] arrCoords = getCoordValues();
            double x1 = arrCoords[0];
            double y1 = arrCoords[1];

            System.out.print("Please input a second coordinate pair: ");
            arrCoords = getCoordValues();
            double x2 = arrCoords[0];
            double y2 = arrCoords[1];

            System.out.println();
            System.out.println(le.lineInfo(x1, y1, x2, y2));

            String ans = "";
            while (!ans.equals("stop")) {
                System.out.println();
                System.out.print("Enter an x value to see what the corresponding y value would be (enter stop to stop): ");
                ans = scan.nextLine();
                if (!ans.equals("stop")) {
                    System.out.println(le.coordForX(Double.parseDouble(ans), x1, y1, x2, y2));
                }
            }

            System.out.println();
            System.out.print("Would you like to choose another line? y/n: ");
            cont = scan.nextLine().equals("y");
        }
    }

    public double[] getCoordValues() {
        String coords = scan.nextLine();
        coords = coords.substring(1).substring(0, coords.length() - 2);
        double x1 = Double.parseDouble(coords.split(", ")[0]);
        double y1 = Double.parseDouble(coords.split(", ")[1]);
        return new double[]{x1, y1};
    }
}
