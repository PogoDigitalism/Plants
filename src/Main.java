import Plants.PlantCatalog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static void askForInput() {
        System.out.println("Please make your choice:  \n" +
                "1 – Show plants that meet all criteria. \n" +
                "2 – Filter plants by size. \n" +
                "3 – Filter plants by flower colour. \n" +
                "4 - Filter plants by edibility. \n" +
                "5 – Reset all criteria. \n" +
                "6 – Simulate global warming. \n" +
                "7 – Quit the application.");
    }

    /**
     * ask user for input of data file
     * @param scanner terminal scanner used for any user interaction
     * @return string of the name of the data file
     */
    private static String askForDataFile(Scanner scanner) {
        System.out.println("Please provide name of the data file;");
        return scanner.next();
    }

    /**
     * ask user for input of plant size filtering
     * @param scanner terminal scanner used for any user interaction
     * @return int of the specified size to filter the ranges by
     */
    private static int askForFilterSize(Scanner scanner) {
        System.out.println("Please provide a size to filter (example: 100).");
        return scanner.nextInt();
    }

    /**
     * ask user for input of plant color filtering
     * @param scanner terminal scanner used for any user interaction
     * @return String of the specified colour to filter the plants by
     */
    private static String askForColourFilter(Scanner scanner) {
        System.out.println("Choose from the following colours:");

        List<String> colourList = PlantCatalog.getDistinctFlowerColours();
        StringBuilder sb = new StringBuilder();
        for (String colour: colourList) {
            sb.append("- ").append(colour).append("\n");
        }
        System.out.println(sb.toString());

        System.out.println("Please provide a flower colour to filter:");
        return scanner.next();
    }

    /**
     * ask user for input of edibility filtering
     * @param scanner terminal scanner used for any user interaction
     * @return boolean whether to filter by edibility or not
     */
    private static boolean askForEdibilityFilter(Scanner scanner) {
        System.out.println("Filter by herbs. Also filter by edibility? yes/no:");
        String result = scanner.next();

        if (result.equalsIgnoreCase("yes")) {
            return true;
        } else if (result.equalsIgnoreCase("no")){
            return false;
        } else {
            return askForEdibilityFilter(scanner);
        }
    }

    /**
     * the start of the plants datamanager
     * @param args passed args when initializing the script from the terminal
     * @throws FileNotFoundException throws this exception if the given input file was not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner terminalScanner = new Scanner(System.in);
        String resource = askForDataFile(terminalScanner);

        PlantCatalog.read(new Scanner(new File(resource)));

        while (true) {
            askForInput();

            int decision = terminalScanner.nextInt();
            switch (decision) {
                case 1: System.out.println(PlantCatalog.outputFilteredPlants()); break;
                case 2: PlantCatalog.setSizeFilter(askForFilterSize(terminalScanner)); break;
                case 3: PlantCatalog.setColorFilter(askForColourFilter(terminalScanner)); break;
                case 4: PlantCatalog.setEdibilityFilter(askForEdibilityFilter(terminalScanner)); break;
                case 5: PlantCatalog.resetFilters(); break;
                case 6: PlantCatalog.simulateGlobalWarming(); break;
                case 7: System.exit(-1); break;
            }
        }
    }
}