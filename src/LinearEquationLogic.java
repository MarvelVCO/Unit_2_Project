import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner scan;
    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }

    public void start() {
        boolean cont = true;
        while (cont) {
            LinearEquation le = new LinearEquation();

            System.out.print("Please input a coordinate pair (eg: (1, 3.4)): ");
            String coord1 = scan.nextLine();
            coord1 = coord1.substring(1).substring(0, coord1.length() - 2);
            double x1 = Double.parseDouble(coord1.split(", ")[0]);
            double y1 = Double.parseDouble(coord1.split(", ")[1]);

            System.out.print("Please input a second coordinate pair (eg: (1, 3.4)): ");
            String coord2 = scan.nextLine();
            coord2 = coord2.substring(1).substring(0, coord2.length() - 2);
            double x2 = Double.parseDouble(coord2.split(", ")[0]);
            double y2 = Double.parseDouble(coord2.split(", ")[1]);

            System.out.println(le.lineInfo(x1, y1, x2, y2));

            le.coordForX(x1, y1, x2, y2);

            System.out.print("Would you like to go again? ");
            cont = scan.nextLine().equals("yes");
        }
    }
}
