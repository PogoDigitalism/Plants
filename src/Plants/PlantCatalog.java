package Plants;

import Utils.Filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * A class that acts as database with utility functions for all the given Plants.
 */
public class PlantCatalog {
    private static List<Plant> plantList = new ArrayList<>();
    private static List<Plant> filteredPlantList = new ArrayList<>();

    /**
     * update the filtered plant list with a Plant size filter
     * @param size the Plant size to filter by
     */
    public static void setSizeFilter(int size) {
        filteredPlantList = Filter.filterBySize(filteredPlantList, size);
    }

    /**
     * update the filtered plant list with a Flower color filter
     * @param color the Flower color to filter by
     */
    public static void setColorFilter(String color) {
        filteredPlantList = Filter.filterByColor(filteredPlantList, color);
    }

    /**
     * update the filtered plant list with an edible boolean filter
     * @param edible true = filter out all non-Herb plants that are non-edible else filter out all non-Herb plants that are edible
     */
    public static void setEdibilityFilter(boolean edible) {
        filteredPlantList = Filter.filterByEdibility(filteredPlantList, edible);
    }

    /**
     * reset the filter and put revert the filtered plant list back to its unfiltered plant list
     */
    public static void resetFilters(){
        filteredPlantList = plantList;
    }

    /**
     * simulate global warming by increasing the growth range of all plants by 10%
     */
    public static void simulateGlobalWarming(){
        resetFilters();
        plantList.replaceAll(plant -> plant.increaseRange(1.10));
    }

    /**
     * get a list of all unique present colours in the filtered plant list
     */
    public static List<String> getDistinctFlowerColours(){
        List<String> colourList = new ArrayList<>();

        for (Plant plant: filteredPlantList) {
            if (plant.hasFlowers()) {
                Flower flower = plant.getFlower();
                colourList.add(flower.getColor());
            }
        }
        return colourList.stream().distinct().collect(Collectors.toList());
    }

    /**
     * Scanner to read file data and load in the data as objects into the catalog
     * @param scanner scanner that holds the contents of the data file
     */
    public static void read(Scanner scanner) {
        scanner.useDelimiter("\\r?\\n(?=HERB|TREE|SHRUB)");

        while (scanner.hasNext()) {
            String infoChunk = scanner.next();
            Plant plant = Plant.read(new Scanner(infoChunk));
            plantList.add(plant);
        }
        filteredPlantList = plantList;
    }

    /**
     * get a formatted string that represents an overview of the filtered plant list.
     */
    public static String outputFilteredPlants() {
        StringBuilder sb = new StringBuilder();

        for (Plant plant: filteredPlantList) {
            sb.append(plant.toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}
